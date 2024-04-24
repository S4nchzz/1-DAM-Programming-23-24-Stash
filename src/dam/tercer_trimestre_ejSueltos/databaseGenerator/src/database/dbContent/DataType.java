package dam.tercer_trimestre_ejSueltos.databaseGenerator.src.database.dbContent;

public class DataType {
    private String fieldName;
    private int type;
    private int length;
    private boolean allowNull;
    private boolean setAutoIncrement;
    
    public DataType(String fieldName, int type, int length, boolean allowNull, boolean setAutoIncrement) {
        this.fieldName = fieldName;
        this.type = type;
        this.length = length;
        this.allowNull = allowNull;
        this.setAutoIncrement = setAutoIncrement;
    }
    
    public String getFieldName() {
        return fieldName;
    }

    public int getType() {
        return type;
    }

    public int getLength() {
        return length;
    }

    public boolean isAllowNull() {
        return allowNull;
    }

    public boolean isSetAutoIncrement() {
        return setAutoIncrement;
    }
}
