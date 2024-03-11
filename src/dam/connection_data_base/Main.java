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
import java.util.Random;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        final String url = "jdbc:mariadb://127.0.0.1:3310/java_users";
        
        try {
            final Connection conn = DriverManager.getConnection(url, "root", "");
        } catch (SQLException sqle) {
            sqle.getMessage();
            System.exit(0);
        }
        
        Scanner sc = new Scanner(System.in);
        int userInput = 0;

        do {
            System.out.println("----------0----------");
            System.out.println("1. Añadir");
            System.out.println("2. Borrar");
            System.out.println("3. Cambiar Contraseña");
            System.out.println("4. Acceder");
            System.out.println("0. Salir");

            userInput = sc.nextInt();

        } while (userInput < 0 || userInput > 4);

        eleccion(userInput);
    }

    public static void eleccion (int eleccion) {
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

    private static void anadir () {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nombre: ");
        String name = sc.next();

        System.out.print("Password: ");
        String pass = sc.next();

        String salt = saltGenerator();
        String passwordAndSalt = salt + pass;

        final String url = "jdbc:mariadb://127.0.0.1:3310/java_users";

        try {
            final Connection conn = DriverManager.getConnection(url, "root", "");
            PreparedStatement st = conn.prepareStatement(
                    "INSERT INTO USER (USERNAME, SALT, PASS) VALUES (?, ?, ?);");
            
            st.setString(1, name);
            st.setString(2, salt);
            st.setBytes(3, sha256(passwordAndSalt));

            st.executeQuery();
            st.close();
        } catch (SQLException sqle) {
            sqle.getMessage();
        }


        //insert
    }
    
    private static void borrar() {

    }
    
    private static void cambiarContrasena() {

    }
    
    private static void acceder() {

    }

    private static String saltGenerator() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 15; i++) {
            sb.append ((char)(33 + (int)(Math.random() * 94)));
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
