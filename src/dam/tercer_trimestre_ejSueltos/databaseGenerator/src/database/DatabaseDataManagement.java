package dam.tercer_trimestre_ejSueltos.databaseGenerator.src.database;

import java.sql.*;

public class DatabaseDataManagement {
    public static Connection getConn () throws SQLException{
        DBConnection db = new DBConnection();
        return db.getConnection();
    }
}