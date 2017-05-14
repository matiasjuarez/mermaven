package IO.basedatos.estructura.tablas;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Created by Matías on 29/04/2017.
 */
public abstract class Table {

    protected String name;
    protected ArrayList<Field> fields;

    public Table(String name){
        this.name = name;
        addTableFields();
    }

    /**
     * Checks if the table already exists in the database
     * @param connection
     * @return true if the table exists
     */
    public boolean exists(Connection connection){
        return false;
    }

    /**
     * Creates the table if it doesn't exist in the database to which the connection
     * is connected
     * @param connection
     * @throws SQLException
     */
    public void create(Connection connection) throws SQLException {
        if(!exists(connection)){
            Statement statement = connection.createStatement();
            statement.execute(getCreationStatement());
        }
    }

    public String getName() {
        return name;
    }

    /**
     * Generates the creation statement for the table based on its fields.
     * @return the creation statement
     */
    private String getCreationStatement(){
        StringBuilder fields = new StringBuilder();

        for(Field field : this.fields){
            fields.append(generateFieldDefinition(field));
            fields.append(",");
        }

        String statement = "CREATE TABLE " + this.getName() + " (";
        statement += fields.toString().substring(0, fields.length() - 1);
        statement += ")";

        return statement;
    }

    /**
     * Generates the line inside a Create Statement for this field based on its
     * name and type
     * @param field - The field we want to generate
     * @return the required line for a create statement for this field
     */
    private String generateFieldDefinition(Field field){
        StringBuilder fieldDefinition = new StringBuilder();
        fieldDefinition.append(field.getName());
        fieldDefinition.append(" ");
        fieldDefinition.append(field.getDataType().toString());

        return fieldDefinition.toString();
    }

    /**
     * This is a template method for 'generateTableFields' methods.
     * It's invoked in the constructor for each table.
     */
    private void addTableFields(){
        this.fields = new ArrayList<>();

        ArrayList<Field> fields = generateTableFields();

        for(Field field : fields){
            fields.add(field);
        }
    }

    /**
     * The purpose for this method is to have a common place for all tables
     * so they can define their own fields.
     * @return and arrayList with the fields of the table
     */
    protected abstract ArrayList<Field> generateTableFields();
}
