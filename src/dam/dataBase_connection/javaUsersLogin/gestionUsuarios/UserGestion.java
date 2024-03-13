package dam.dataBase_connection.javaUsersLogin.gestionUsuarios;

import java.security.MessageDigest;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dam.dataBase_connection.javaUsersLogin.hashing.SHA256AndSalt;

public class UserGestion {
    final static String url = "jdbc:mariadb://127.0.0.1:3310/java_users";

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

    public static boolean cambiarContrasena(String userName, String newPassword) {
        String salt = SHA256AndSalt.saltGenerator();

        try {
            final Connection conn = DriverManager.getConnection(url, "root", "");

            PreparedStatement st = conn.prepareStatement("UPDATE USER SET SALT = ? WHERE USERNAME LIKE ?");
            st.setString(1, salt);
            st.setString(2, userName);

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

    public static boolean acceder(String username, String password) {
        try {
            Connection conn = DriverManager.getConnection(url, "root", "");
            // Prepared statement con el usuario salt y contraseña de la fila
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
                    // es igual a la hash completo de la base de datos entonces
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