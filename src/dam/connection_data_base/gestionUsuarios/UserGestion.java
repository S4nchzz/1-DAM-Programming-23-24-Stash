package dam.connection_data_base.gestionUsuarios;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import dam.connection_data_base.saltGenerator.Salting;
import dam.connection_data_base.encodingSHA256.ConversionSHA256;

public class UserGestion {
    public static void anadir() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nombre: ");
        String name = sc.next();

        System.out.print("Password: ");
        String pass = sc.next();

        String salt = Salting.saltGenerator();
        String passwordAndSalt = salt + pass;

        // URL CON CONEXION A LA BASE DE DATOS
        final String url = "jdbc:mariadb://127.0.0.1:3310/java_users";

        try {
            // SE ESTABLECE LA CONEXION
            final Connection conn = DriverManager.getConnection(url, "root", "");
            // STATEMENT PARA DAR EJECUTAR LA CONSULTA EN LA BASE DE DATOS SI SE REALIZA CON
            // EXITO LA CONEXION
            PreparedStatement st = conn.prepareStatement(
                    "INSERT INTO USER (USERNAME, SALT, PASS) VALUES (?, ?, ?);");

            st.setString(1, name);
            st.setString(2, salt);
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
            sqle.getMessage();
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

    public static void acceder() throws SQLException {
        final String url = "jdbc:mariadb://127.0.0.1:3310/java_users";
        Scanner sc = new Scanner(System.in);

        System.out.println("Username: ");
        String username = sc.next();

        System.out.println("Password: ");
        String password = sc.next();

        sc.close();

        Connection conn = DriverManager.getConnection(url, "root", "");
        PreparedStatement stUS = conn.prepareStatement("SELECT USERNAME, SALT FROM USER");
        ResultSet rs = stUS.executeQuery();

        String saltFromUser = "";

        int posicion = 1;
        while (rs.next()) {
            if (rs.getString(1).equals(username)) {
                saltFromUser = rs.getString(2);
                System.out.println(saltFromUser);
                break;
            }
            posicion++;
        }

        // Contraseña ingresada por el usuario y el salt del usuario correcto
        byte[] passAndSalt = ConversionSHA256.sha256(saltFromUser + password);

        PreparedStatement stUSP = conn.prepareStatement("SELECT USERNAME, SALT, PASS FROM USER");
        ResultSet rsCheckPassword = stUSP.executeQuery();
        boolean truePass = false;

        // Vamos a la posicion del usuario que quiere acceder
        // para no recorrer la BBDD
        // de nuevo
        rsCheckPassword.absolute(posicion);

        // Si el nombre del usuario y el hash de la contraseña coinciden se pone a true
        // el boolean de que el usuario que intenta acceder es el correcto
        // ! SOLUCIONR ESTO NO SE PUEDE DAR UN ARRAY DE BYTES Y QUE RETORNE UN STRING
        if (rsCheckPassword.getString(1).equals(username) && 
                rsCheckPassword.getString(3).equals(passAndSalt)) {
            truePass = true;
        }

        if (truePass) {
            System.out.println("Sesion Iniciada");
        } else {
            System.out.println("Error en inicio de sesion");
        }
    }
}
