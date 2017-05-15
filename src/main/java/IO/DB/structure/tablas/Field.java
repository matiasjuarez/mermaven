package IO.DB.structure.tablas;

/**
 * Created by Matías on 01/05/2017.
 * Represents a Field of a table.
 */
public class Field {

    public enum Type {
        FLOAT("FLOAT"),
        DATE("DATE");

        private String name;

        Type(String name){
            this.name = name;
        }

        public String toString(){
            return name;
        }
    }

    private String name;
    private Type dataType;

    public Field(String name, Type dataType){
        this.name = name;
        this.dataType = dataType;
    }

    public String getName() {
        return name;
    }

    public Type getDataType() {
        return dataType;
    }
}
