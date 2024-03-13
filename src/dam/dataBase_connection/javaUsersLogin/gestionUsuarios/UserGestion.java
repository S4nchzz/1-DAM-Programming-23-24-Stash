package dam.dataBase_connection.javaUsersLogin.gestionUsuarios;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLDataException;
import java.sql.SQLException;
import java.util.Scanner;

import dam.dataBase_connection.javaUsersLogin.saltGenerator.Salting;
import dam.dataBase_connection.javaUsersLogin.encodingSHA256.ConversionSHA256;

public class UserGestion {
    public static void anadir() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nombre: ");
        String name = sc.next();

        System.out.print("Password: ");
        String pass = sc.next();

        String salt = Salting.saltGenerator();
        String passwordAndSalt = salt + pass;

        // URL con la conexion a la base de datos
        final String url = "jdbc:mariadb://127.0.0.1:3310/java_users";

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
            st.setBytes(3, ConversionSHA256.sha256(passwordAndSalt));

            st.executeQuery();
            st.close();
            sc.close();
        } catch (SQLException sqle) {
            System.out.println(sqle.getMessage());
        }
    }

    public static void borrar() {
        // URL CON CONEXION A LA BASE DE DATOS
        final String url = "jdbc:mariadb://127.0.0.1:3310/java_users";
        Scanner sc = new Scanner(System.in);

        System.out.println("Nombre de usuario a eliminar: ");
        String userToRemove = sc.next();

        try {
            // SE ESTABLECE LA CONEXION
            final Connection conn = DriverManager.getConnection(url, "root", "");
            // STATEMENT PARA ELIMINAR EL USUARIO ELEGIDO
            PreparedStatement st = conn.prepareStatement("DELETE FROM USER WHERE USERNAME LIKE ?");

            st.setString(1, userToRemove);

            st.executeQuery();
            st.close();
            sc.close();
        } catch (SQLException sqle) {
            System.out.println(sqle.getMessage());
        }
    }

    public static void cambiarContrasena() throws SQLException {
        // URL CON CONEXION A LA BASE DE DATOS
        final String url = "jdbc:mariadb://127.0.0.1:3310/java_users";
        Scanner sc = new Scanner(System.in);

        System.out.println("Nombre de usuario para cambiar la contraseña: ");
        String userName = sc.next();

        System.out.print("Contraseña nueva: ");
        String newPassword = sc.next();

        sc.close();

        String salt = Salting.saltGenerator();

        final Connection conn = DriverManager.getConnection(url, "root", "");

        PreparedStatement st = conn.prepareStatement("UPDATE USER SET SALT = ? WHERE USERNAME LIKE ?");
        st.setString(1, salt);
        st.setString(2, userName);

        PreparedStatement st2 = conn.prepareStatement("UPDATE USER SET PASS = ? WHERE USERNAME LIKE ?");
        st2.setBytes(1, ConversionSHA256.sha256(salt + newPassword));
        st2.setString(2, userName);

        st.executeQuery();
        st2.executeQuery();
    }

    public static boolean acceder() throws SQLException {
        final String url = "jdbc:mariadb://127.0.0.1:3310/java_users";
        Scanner sc = new Scanner(System.in);

        System.out.println("Username: ");
        String username = sc.next();

        System.out.println("Password: ");
        String password = sc.next();

        sc.close();

        Connection conn = DriverManager.getConnection(url, "root", "");
        //Prepared statement con el usuario salt y contraseña de la fila
        PreparedStatement stUSP = conn.prepareStatement("SELECT USERNAME, SALT, PASS FROM USER");
        //Se almacena los valores anteriores en una variable de tipo ResultSet
        ResultSet rs = stUSP.executeQuery();

        String saltFromUser = "";

        //Si el usuario existe guardamos en una variable su salt para comprobarlo posteriormente
        int posicion = 1;
        while (rs.next()) {
            if (rs.getString(1).equals(username)) {
                saltFromUser = rs.getString(2);
                break;
            }
            posicion++;
        }

        // Contraseña ingresada por el usuario y el salt del usuario correcto
        byte [] passAndSalt = ConversionSHA256.sha256(saltFromUser + password);

        //Nueva variable de tipo ResultSet para reiniciar la consulta desde la primera fila
        ResultSet rsCheckPassword = stUSP.executeQuery();

        // Vamos a la posicion del usuario que quiere acceder
        // para no recorrer la BBDD
        // de nuevo
        rsCheckPassword.absolute(posicion);

        // Si el nombre del usuario y el hash de la contraseña coinciden se pone a true
        // el boolean haciendo referencia al que la contraseña para ese usuario en 
        // especifico es correcto

        byte [] passOnBytes = null;

        try {
            try {
                // Se comprueba por ultima vez si el usuario existe, esto se debe a que puede que
                // exista la posibilidad de que se haya borrado.
                boolean userExists = rsCheckPassword.getString(1).equals(username);

                // Si el usuario existe se guarda si contraseña en forma de array de bytes
                if (userExists) {
                    passOnBytes = rsCheckPassword.getBytes(3);
                }

            } catch (SQLDataException sqlde) {
                System.out.println("El usuario no existe, saliendo...");
                return false;
            }

            // Si el array de bytes no es null y la contraseña hasheada con el salt del usuario
            // es igual a la hash completo de la base de datos entonces la contraesña sera la 
            // correcta
            if (passOnBytes != null && MessageDigest.isEqual(passOnBytes, passAndSalt)) {
                System.out.println("Sesion iniciada");
                return true;
            } else {
                System.out.println("Inicio de sesion erroneo");
            }

        } catch(Exception e) {
            System.out.println(e.getMessage());
        }

        return false;
    }
}
