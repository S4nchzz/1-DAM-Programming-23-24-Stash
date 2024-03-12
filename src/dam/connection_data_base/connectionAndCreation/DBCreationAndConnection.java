package dam.connection_data_base.connectionAndCreation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DBCreationAndConnection {
    public static boolean createDBandTB() {
        final String url = "jdbc:mariadb://127.0.0.1:3310/";

        try {
            Connection checkServer = DriverManager.getConnection(url, "root", "");

            try {
                Connection checDatabase = DriverManager.getConnection(url + "java_users", "root", "");
                checDatabase.close();
                System.out.println("Database java_users founded");
            } catch (SQLException sqleNoDatabaseFound) {
                System.out.println("Creating database java_users...");
                // Creation database if not exist
                PreparedStatement setUpDatabase = checkServer.prepareStatement(
                        "CREATE DATABASE IF NOT EXISTS java_users;");

                PreparedStatement useDatabase = checkServer.prepareStatement("USE java_users;");
                PreparedStatement createTableUser = checkServer.prepareStatement(
                        "CREATE TABLE user (USERNAME VARCHAR(15) PRIMARY KEY, SALT VARCHAR(16) NOT NULL, PASS VARCHAR(16) NOT NULL);");

                setUpDatabase.executeQuery();
                useDatabase.executeQuery();
                createTableUser.executeQuery();

                setUpDatabase.close();
                useDatabase.close();
                createTableUser.close();
                checkServer.close();
            }

            checkServer.close();
            return true;
        } catch (SQLException sqle) {
            System.out.println("Error while trying establish connection to the database");
            return false;
        }
    }
}