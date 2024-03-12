package dam.connection_data_base;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;
import dam.connection_data_base.gestionUsuarios.UserGestion;

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
                UserGestion.anadir();
                break;

            case 2:
                UserGestion.borrar();
                break;

            case 3:
                UserGestion.cambiarContrasena();
                break;

            case 4:
                UserGestion.acceder();
                break;
        }
    }
}