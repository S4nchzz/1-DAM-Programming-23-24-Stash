package dam.connection_data_base;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        final String url = "jdbc:mariadb://127.0.0.1:3310/usuarios";
        Connection conn = null;

        try {
            conn = DriverManager.getConnection(url, "root", "");
        } catch (SQLException sqle) {
            System.exit(0);
        }

        System.out.println("----------0----------");
        System.out.println("1. Añadir");
        System.out.println("2. Borrar");
        System.out.println("3. Cambiar Contraseña Contraseña");
        System.out.println("4. Abrir sesion");
        
        Scanner sc = new Scanner(System.in);
        int userInput = 0;

        do {
            try {
                userInput = sc.nextInt();
                if (userInput >= 0 && userInput <= 5) {
                    break;
                }
            } catch (InputMismatchException ime) {
                sc.next();
            }
        } while (true);

        if (conn == null) {
            return;
        }

        eleccion(userInput, conn);
    }

    public static void eleccion (int eleccion, Connection conn) {
        Scanner sc = new Scanner(System.in);
        switch (eleccion) {
            case 1:
                System.out.print("Escriba el nombre del usuario: ");
                String userName = sc.next();
                
                System.out.print("Escriba la contraseña del usuario: ");
                String userPassword = sc.next();

                try {
                    PreparedStatement st = conn.prepareStatement("INSERT INTO USERS (USERNAME, PASSWORD) VALUES (\" " + userName + "\", \"" + userPassword + "\")");
                    ResultSet r = st.executeQuery();
                } catch (SQLException sqle) {
                    sqle.getMessage();
                }
                
            break;
            
            case 2:
            break;

            case 3:
            break;

            case 4:
            break;

            default:
                System.out.println("Error on choose");
            break;
        }        
    }

    public static void main1(String[] args) {
        final Scanner sc = new Scanner(System.in);
        final String s = sc.nextLine();
        System.out.println(s);

        try {
            final String url = "jdbc:mariadb://127.0.0.1:3310/ajedrez";
            final String sql = "SELECT ID, NOMBRE"
                    + " FROM JUGADOR"
                    + " WHERE NOMBRE LIKE ?";

            System.out.println(sql);

            final Connection con = DriverManager.getConnection(url, "root", "");
            final PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, "%" + s + "%");
            final ResultSet r = st.executeQuery();

            while (r.next()) {
                final int id = r.getInt(1);
                final String nombre = r.getString(2);
                System.out.println(id + " - " + nombre);
            }

            r.close();
            st.close();
            con.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

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

    public static String hashToString(byte[] hash) {
        final StringBuilder r = new StringBuilder();

        for (int k = 0; k < hash.length; k++) {
            r.append(toHex((hash[k] >> 4) & 0xF));
            r.append(toHex(hash[k] & 0xF));
        }

        return r.toString();
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
