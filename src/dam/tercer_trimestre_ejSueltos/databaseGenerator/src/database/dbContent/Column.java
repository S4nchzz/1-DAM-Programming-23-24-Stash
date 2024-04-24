package dam.tercer_trimestre_ejSueltos.databaseGenerator.src.database.dbContent;

public class Column {
    private String colName;
    private RowData [] rowData;

    public Column () {
        RowData rd = new RowData(this);
    }

    public String getColName () {
        return this.colName;
    }
}
