package dam.tercer_trimestre_ejSueltos.databaseGenerator.src.database.dbContent;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import dam.tercer_trimestre_ejSueltos.databaseGenerator.src.database.DatabaseDataManagement;
import dam.tercer_trimestre_ejSueltos.databaseGenerator.src.database.dataRequest.RequestRS;

public class RowData {
    private String colName;
    private Connection conn;
    private DataType [] dataArr;

    public RowData (Column col) {
        this.colName = col.getColName();
        try {
            this.conn = DatabaseDataManagement.getConn();
        } catch (SQLException q) {

        }

        RequestRS rs = new RequestRS(colName);
        ResultSet data = rs.getRequestedData();

        int i = 0;
        try {
            while (data.next()) { //While No acabe el ResultSet de esa columna añade elementos de tipo datatype)
                //this.dataArr[i] = new DataType(String.valueOf(data.getInt(i)), data.getType(), 213);
                i++;
            }
        } catch (SQLException q) {

        }

    }
}
