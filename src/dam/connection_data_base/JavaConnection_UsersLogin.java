package dam.connection_data_base;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class JavaConnection_UsersLogin {
    public static void main(String[] args) {
        final String url = "jdbc:mariadb://127.0.0.1:3310/";
        Scanner sc = new Scanner(System.in);
        int userInput = 0;

        try {
            Connection checkServer = DriverManager.getConnection(url, "root", "");

            System.out.print("Desea crear la base de datos desde 0 (S/N): ");
            String dbCreated = sc.next();

            
            if (dbCreated.equalsIgnoreCase("S")) {
                // Creation database if not exist
                PreparedStatement setUpDatabase = checkServer.prepareStatement(
                        "CREATE OR REPLACE DATABASE java_users;");

                PreparedStatement useDatabase = checkServer.prepareStatement("USE java_users;");
                PreparedStatement createTableUser = checkServer.prepareStatement("CREATE TABLE java_users (USERNAME VARCHAR(15) PRIMARY KEY, SALT VARCHAR(16) NOT NULL, PASS VARCHAR(16) NOT NULL);");

                setUpDatabase.executeQuery();
                useDatabase.executeQuery();
                createTableUser.executeQuery();

                setUpDatabase.close();
                useDatabase.close();
                createTableUser.close();
            }

            checkServer.close();
            do {
                System.out.println("----------0----------");
                System.out.println("1. Añadir");
                System.out.println("2. Borrar");
                System.out.println("3. Cambiar Contraseña");
                System.out.println("4. Acceder");
                System.out.println("0. Salir");

                userInput = sc.nextInt();

            } while (userInput < 0 || userInput > 4);

            try {
                eleccion(userInput);
            } catch (SQLException sqleUserInput) {
                System.out.println(sqleUserInput.getMessage());
            }
            
            sc.close();

        } catch (SQLException sqle) {
            System.out.println("Error while trying establish connection to the database");
        }
    }

    public static void eleccion(int eleccion) throws SQLException {
        switch (eleccion) {
            case 1:
                anadir();
                break;

            case 2:
                borrar();
                break;

            case 3:
                cambiarContrasena();
                break;

            case 4:
                acceder();
                break;
        }
    }

    private static void anadir() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nombre: ");
        String name = sc.next();

        System.out.print("Password: ");
        String pass = sc.next();

        String salt = saltGenerator();
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
            st.setBytes(3, sha256(passwordAndSalt));

            st.executeQuery();
            st.close();
            sc.close();
        } catch (SQLException sqle) {
            System.out.println(sqle.getMessage());
        }
    }

    private static void borrar() {
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

    private static void cambiarContrasena() throws SQLException {
        // URL CON CONEXION A LA BASE DE DATOS
        final String url = "jdbc:mariadb://127.0.0.1:3310/java_users";
        Scanner sc = new Scanner(System.in);

        System.out.println("Nombre de usuario para cambiar la contraseña: ");
        String userName = sc.next();

        System.out.print("Contraseña nueva: ");
        String newPassword = sc.next();

        sc.close();

        String salt = saltGenerator();

        final Connection conn = DriverManager.getConnection(url, "root", "");

        PreparedStatement st = conn.prepareStatement("UPDATE USER SET SALT = ? WHERE USERNAME LIKE ?");
        st.setString(1, salt);
        st.setString(2, userName);

        PreparedStatement st2 = conn.prepareStatement("UPDATE USER SET PASS = ? WHERE USERNAME LIKE ?");
        st2.setBytes(1, sha256(salt + newPassword));
        st2.setString(2, userName);

        st.executeQuery();
        st2.executeQuery();
    }

    private static void acceder() throws SQLException {
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
        byte[] passAndSalt = sha256(saltFromUser + password);

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

    private static String saltGenerator() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 15; i++) {
            sb.append((char) (33 + (int) (Math.random() * 94)));
        }

        return sb.toString();
    }

    public static String hashToString(byte[] hash) {
        final StringBuilder r = new StringBuilder();

        for (int k = 0; k < hash.length; k++) {
            r.append(toHex((hash[k] >> 4) & 0xF));
            r.append(toHex(hash[k] & 0xF));
        }

        return r.toString();
    }

    public static char toHex(int x) {
        if (x < 0) {
            return '?';
        } else if (x < 10) {
            return (char) ('0' + x);
        } else if (x < 16) {
            return (char) ('A' + x - 10);
        } else {
            return '?';
        }
    }

    public static byte[] sha256(String s) {
        final byte[] b = s.getBytes();

        try {
            MessageDigest m = MessageDigest.getInstance("SHA-256");
            return m.digest(b);
        } catch (NoSuchAlgorithmException e) {
            return null;
        }
    }
}