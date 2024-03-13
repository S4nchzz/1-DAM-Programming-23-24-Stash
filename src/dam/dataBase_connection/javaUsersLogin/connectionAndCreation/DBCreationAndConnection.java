package dam.dataBase_connection.javaUsersLogin.connectionAndCreation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Esta clase sirve para ver si el servidor se encuentra activo
 * y si se encuentra la base de datos java_users, si no esta la crea
 */
public class DBCreationAndConnection {
    /**
     * Este metodo iniciara una conexion al servidor de mariadb, si hay un 
     * error ira al catch si no proseguira y realizara otra conexion que se 
     * cerrara instantaneamente, esta sirve para comprobar si la base de datos
     * java_users existe, si no ira al catch la cual la creara haciendo uso de
     * 3 objetos de tipo PreparedStatement
     * @return
     */
    public static boolean createDBandTB() {
        final String url = "jdbc:mariadb://127.0.0.1:3310/";

        try {
            // Prueba de conexion al SERVIDOR
            Connection dbServer = DriverManager.getConnection(url, "root", "");

            try {
                // Prueba de conexion a la base de datos
                Connection checkDatabase = DriverManager.getConnection(url + "java_users", "root", "");
                checkDatabase.close(); // Se cierra la conexion instantaneamente.
                System.out.println("Database java_users founded");
            } catch (SQLException sqleNoDatabaseFound) {
                System.out.println("Creating database java_users...");
                // Creation database if not exist
                PreparedStatement setUpDatabase = dbServer.prepareStatement(
                        "CREATE DATABASE IF NOT EXISTS java_users;");

                PreparedStatement useDatabase = dbServer.prepareStatement("USE java_users;");
                PreparedStatement createTableUser = dbServer.prepareStatement(
                        "CREATE TABLE user (USERNAME VARCHAR(15) PRIMARY KEY, SALT VARCHAR(16) NOT NULL, PASS BINARY(32) NOT NULL);");

                setUpDatabase.executeQuery();
                useDatabase.executeQuery();
                createTableUser.executeQuery();

                setUpDatabase.close();
                useDatabase.close();
                createTableUser.close();
                dbServer.close();
            }

            dbServer.close();
            return true;
        } catch (SQLException sqle) {
            System.out.println("Error while trying establish connection to the database");

            return false;
        }
    }
}