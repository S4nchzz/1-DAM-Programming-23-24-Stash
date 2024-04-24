package dam.tercer_trimestre_ejSueltos.databaseGenerator.src.database.dataRequest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dam.tercer_trimestre_ejSueltos.databaseGenerator.src.database.DatabaseDataManagement;

public class RequestRS {
    private Connection conn;
    private ResultSet data;

    public RequestRS (String data) {
        try {
            conn = DatabaseDataManagement.getConn();
            PreparedStatement st = conn.prepareStatement("SELECT * FROM ?");
            st.setString(1, data);
            st.executeUpdate();
        } catch (SQLException q) {

        }
    }

    public ResultSet getRequestedData() {
        return this.data;
    }
}
