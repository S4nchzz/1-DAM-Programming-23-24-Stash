package dam.dataBase_connection;

import java.sql.SQLException;

import dam.dataBase_connection.javaUsersLogin.backend.connectionAndCreation.DBCreationAndConnection;
import dam.dataBase_connection.javaUsersLogin.frontend.JPort;
import dam.dataBase_connection.javaUsersLogin.frontend.JU_Window;

public class Main {
    public static void main(String[] args) throws SQLException, InterruptedException {

        if (DBCreationAndConnection.createDBandTB(3310)) {
            new JU_Window();
        } else if (DBCreationAndConnection.createDBandTB(3306)) {
            new JU_Window();
        } else {
            JPort port = new JPort();

            while (!port.entryRecived()) {
                Thread.sleep(1);
            }

            if (port.entryRecived()) {
                if (DBCreationAndConnection.createDBandTB(port.getEntry())) {
                    new JU_Window();
                } else {
                    System.out.println("Error while creating Database");
                }
            }
        }
    }
}