package dam.tercer_trimestre_ejSueltos.databaseGenerator.src.database;

import java.sql.*;

public class DBConnection {
    private final String url;
    private final Connection conn;

    public DBConnection () throws SQLException{
        url = "127.0.0.1:3310";
        conn = DriverManager.getConnection(url, "root", "");
    }

    public Connection getConnection() {
        return this.conn;
    }
}
