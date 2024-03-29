package dam.dataBase_connection.javaUsersLogin.backend.gestionUsuarios;

import java.security.MessageDigest;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dam.dataBase_connection.javaUsersLogin.backend.connectionAndCreation.DBCreationAndConnection;
import dam.dataBase_connection.javaUsersLogin.backend.hashing.SHA256AndSalt;

/**
 * Clase que gestiona todo el control de la base de datos, metodos (anadir(),
 * borrar(), cambiarContrasena(), acceder())
 */
public class UserGestion {
    // URL global de la base de datos obtenido del String estatico de DBCreationAndConnection
    final static String url = DBCreationAndConnection.url;

    /**
     * Este metodo iniciara una conexion con la base de datos y creara un objeto de
     * tipo PreparedStatement el cual insertara la consulta para añadir este usuario
     * con sus correspondientes campos, generando el salt (esta generacion se encuentra
     * al principio de la clase) y generando la contraeña hasheada en forma de array de bytes 
     * @param name nombre del usuario a añadir en la base de datos
     * @param pass contraseña del usuario a añadir en la base de datos
     * @return true si se añadio correctamente false si hubo un error
     */
    public static boolean anadir(String name, String pass) {
        String salt = SHA256AndSalt.saltGenerator();
        String passwordAndSalt = salt + pass;

        try {
            // Se establece la conexion real a usar
            final Connection conn = DriverManager.getConnection(url, "root", "");
            // Statement para dar ejecutar la consulta en la base de datos si se realiza con
            // exito la conexion
            PreparedStatement st = conn.prepareStatement(
                    "INSERT INTO USER (USERNAME, SALT, PASS) VALUES (?, ?, ?);");

            st.setString(1, name);
            st.setString(2, salt);
            // En el parametro 3 del PreparedStatement se envia el array de bytes con la conversion
            // de SHA-356
            st.setBytes(3, SHA256AndSalt.sha256(passwordAndSalt));

            st.executeUpdate();
            st.close();
            
            return true;
        } catch (SQLException sqle) {
            
        }

        return false;
    }

    /**
     * Este metodo iniciara una conexion con la base de datos y creara un objeto de
     * tipo PreparedStatement haciendo una consulta para hacer un DELETE con este usuario
     * @param userToRemove usuario a eliminar de la base de datos
     * @return true si la operacion se realizo correctamente, false si hubo un error
     */
    public static boolean borrar(String userToRemove) {
        try {
            // SE ESTABLECE LA CONEXION
            final Connection conn = DriverManager.getConnection(url, "root", "");
            // STATEMENT PARA ELIMINAR EL USUARIO ELEGIDO
            PreparedStatement st = conn.prepareStatement("DELETE FROM USER WHERE USERNAME LIKE ?");

            st.setString(1, userToRemove);

            st.executeUpdate();
            st.close();

            return true;
        } catch (SQLException sqle) {

        }
        return false;
    }

    /**
     * Este metodo iniciara una conexion con la base de datos y creara una variable
     * de tipo String la cual contendra el salt nuevo del usuario, una vez se tenga
     * el salt se creara un objeto de tipo PreparedStatement el cual usando un UPDATE
     * actualizara la base de datos con estea nueva password, hara lo mismo generando
     * una contraseña codificada en SHA-256 con ese salt en forma de array de bytes,
     * despues de tener este array se hara uso del metodo setBytes para insertarlo en
     * la consulta, al final se ejecutara los 2 updates
     * @param userName    usuario a cambiar la contraseña
     * @param newPassword contraseña nueva a dar al usuario
     * @return true si la operacion se realizo correctamente, false si hubo un error
     */
    public static boolean cambiarContrasena(String userName, String newPassword) {
        try {
            final Connection conn = DriverManager.getConnection(url, "root", "");

            // Actualizacion del salt de la contraseña
            String salt = SHA256AndSalt.saltGenerator();

            PreparedStatement st = conn.prepareStatement("UPDATE USER SET SALT = ? WHERE USERNAME LIKE ?");
            st.setString(1, salt);
            st.setString(2, userName);

            // Actualizacion de la contraseña con el salt
            PreparedStatement st2 = conn.prepareStatement("UPDATE USER SET PASS = ? WHERE USERNAME LIKE ?");
            st2.setBytes(1, SHA256AndSalt.sha256(salt + newPassword));
            st2.setString(2, userName);

            st.executeUpdate();
            st2.executeUpdate();
            
            return true;
        } catch (SQLException sqle) {
            return false;
        }
        
    }

    /**
     * Este metodo inicia una conexion a la base de datos y crea un objeto de tipo
     * PreparedStatement el cual tiene como consulta SELECT * FROM USER WHERE 
     * USERNAME = @param username esta consulta da como resultado todos los campos
     * del usuario @param username, el objeto ResultSet ejecuta la consulta y se
     * guarda en un objeto de este tipo todo lo relacionado con el resultado de la
     * consulta, luego se accede al primer reusltado de la consulta y si el metodo
     * rs.next() == true significa que existe un registro en la consulta realizada,
     * despues se guarda el salt de la consulta asi como el hash en una variable
     * bytes [], una vez se tengan estos datos se hace una llamada a SHA256() con el
     * salt del usuario que existe en la base de datos + @param password despues esto
     * se guarda en un array de bytes [], una vez acaba esto se hace un if con un
     * objeto MessageDigest accediendo al metodo estatico .isEqual() ingresando los
     * dos arrays de bytes, este metodo comparara los arrays y retornara true si 
     * son iguales y false si no lo son, haciendo esto se sabe si el hash de la contraseña 
     * ingresada por el usuario es igual a la contraseña de la base de datos 
     * @param username usuario para acceder
     * @param password contraseña para acceder
     * @return true si la operacion se realizo correctamente, false si hubo un error
     */
    public static boolean acceder(String username, String password) {
        try {
            Connection conn = DriverManager.getConnection(url, "root", "");
            // Prepared statement con el usuario salt y contraseña de la tabla user
            PreparedStatement stUSP = conn.prepareStatement("SELECT * FROM USER WHERE USERNAME = ?");
            stUSP.setString(1, username);

            // Se almacena los valores anteriores en una variable de tipo ResultSet
            ResultSet rs = stUSP.executeQuery();

            //Accedemos al primer registro
            if (rs.next()) {
                // Salt del usuario en la base de datos
                String saltFromUser = rs.getString(2);
                // Contraseña hasheada de la base de datos
                byte[] passwordDatabaseHashed = rs.getBytes(3);

                // Contraseña ingresada por el usuario y el salt del usuario correcto
                byte[] passwordToCheck = SHA256AndSalt.sha256(saltFromUser + password);

                try {
                    // Si la contraseña hasheada con el salt del usuario
                    // es igual al hash completo de la base de datos entonces
                    // la contraesña sera la correcta
                    if (MessageDigest.isEqual(passwordDatabaseHashed, passwordToCheck)) {
                        return true;
                    }
                } catch (Exception e) {

                }
            }
        } catch (SQLException sqle) {

        }

        return false;
    }
}