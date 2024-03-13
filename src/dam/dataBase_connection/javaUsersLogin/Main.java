package dam.dataBase_connection.javaUsersLogin;

import java.sql.SQLException;
import java.util.Scanner;

import dam.dataBase_connection.javaUsersLogin.connectionAndCreation.DBCreationAndConnection;

public class Main {
    public static void main(String[] args) throws SQLException {
        Scanner sc = new Scanner(System.in);
        int userInput = 0;
        
        System.out.println("Trying establish connection");

        if (DBCreationAndConnection.createDBandTB()) {
            do {
                System.out.println("----------0----------");
                System.out.println("1. Añadir");
                System.out.println("2. Borrar");
                System.out.println("3. Cambiar Contraseña");
                System.out.println("4. Acceder");
                System.out.println("0. Salir");

                userInput = sc.nextInt();

            } while (userInput < 0 || userInput > 4);

            Choice.eleccion(userInput);

            sc.close();
            System.out.println("Chao");
        } else {
            System.out.println("Error while creating Database");
        }
    }
}