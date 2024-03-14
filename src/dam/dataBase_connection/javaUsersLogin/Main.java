package dam.dataBase_connection.javaUsersLogin;

import java.sql.SQLException;
import java.util.Scanner;

import dam.dataBase_connection.javaUsersLogin.backend.connectionAndCreation.DBCreationAndConnection;
import dam.dataBase_connection.javaUsersLogin.backend.gestionUsuarios.UserGestion;
import dam.dataBase_connection.javaUsersLogin.frontend.menu.Menu;

public class Main {
    private static Scanner sc;

    public static void main(String[] args) throws SQLException {
        sc = new Scanner(System.in);
        int userInput = 0;
        
        System.out.println("Trying establish connection");

        if (DBCreationAndConnection.createDBandTB()) {
            do {
                new Menu();
                System.out.println("----------0----------");
                System.out.println("1. Añadir");
                System.out.println("2. Borrar");
                System.out.println("3. Cambiar Contraseña");
                System.out.println("4. Acceder");
                System.out.println("0. Salir");

                userInput = sc.nextInt();

            } while (userInput < 0 || userInput > 4);

            System.out.println(eleccion(userInput));

            sc.close();
            System.out.println("Exiting...");
        } else {
            System.out.println("Error while creating Database");
        }
    }

    /**
     * Metodo eleccion para gestionar la base de datos
     * @param eleccion numero de eleccion 1-4
     * @return true si la operacion realizada el el caso 1..4 correctamente, falso si no
     */
    public static boolean eleccion(int eleccion) {
        switch (eleccion) {
            case 1: 
                System.out.print("Nombre: ");
                String name = sc.next();

                System.out.print("Password: ");
                String pass = sc.next();

                boolean gestionResultAdd = UserGestion.anadir(name, pass);
                
                if (gestionResultAdd) {
                    System.out.println("Usuario añadido correctamente");
                    return true;
                } else {
                    System.out.println("Error al integrar el usuario " + name);
                    return false;
                }

            case 2:
                System.out.println("Nombre de usuario a eliminar: ");
                String userToRemove = sc.next();

                boolean gestionResultDelete = UserGestion.borrar(userToRemove);

                if (gestionResultDelete) {
                    System.out.println("Usuario borrado correctamente");
                    return true;
                } else {
                    System.out.println("Error al borrar el usuario " + userToRemove);
                    return false;
                }

            case 3:
                System.out.println("Nombre de usuario para cambiar la contraseña: ");
                String userName = sc.next();

                System.out.print("Contraseña nueva: ");
                String newPassword = sc.next();

                boolean gestionResultChangePass = UserGestion.cambiarContrasena(userName, newPassword);

                if (gestionResultChangePass) {
                    System.out.println("Contraseña del usuario " + userName + " correctamente");
                    return true;
                } else {
                    System.out.println("Error al cambiar la contraseña del usuario " + userName);
                    return false;
                }

            case 4:
                System.out.println("Username: ");
                String username = sc.next();

                System.out.println("Password: ");
                String password = sc.next();

                boolean gestionResultLogin = UserGestion.acceder(username, password);

                if (gestionResultLogin) {
                    System.out.println("Sesion iniciada correctamente");
                    return true;
                } else {
                    System.out.println("Error al iniciar sesion");
                    return false;
                }
            
            default:
                return false;
        }
    }
}