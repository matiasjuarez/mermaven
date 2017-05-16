package IO.DB.structure.tablas;

import IO.DB.exceptions.InvalidTableDefinitionException;

import java.sql.*;
import java.util.ArrayList;

/**
 * Created by Matías on 29/04/2017.
 */
public class Table {

    private String name;
    private ArrayList<Field> fields;

    public Table(String name){
        this.name = name;
        this.fields = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public ArrayList<Field> fields(){ return fields; }

    public void addField(Field field){
        fields.add(field);
    }

    /**
     * Creates the table in the database to which the connection
     * is connected.
     * @param connection
     * @throws SQLException
     */
    public void create(Connection connection) throws SQLException, InvalidTableDefinitionException {
        Statement statement = connection.createStatement();
        statement.execute(getCreationStatement());
    }

    /**
     * Drop the table in the database to which the connection is connected
     * @param connection
     * @throws SQLException
     */
    public void delete(Connection connection) throws SQLException {
        String sentence = "drop table " + getName();

        Statement statement = connection.createStatement();
        statement.execute(sentence);
    }

    /**
     * Generates the creation statement for the table based on its fields.
     * @return the creation statement or null if the table has no defined fields
     */
    private String getCreationStatement() throws InvalidTableDefinitionException {
        if(this.fields == null || this.fields.size() == 0){
            throw new InvalidTableDefinitionException("The table has no fields defined");
        }

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
}
