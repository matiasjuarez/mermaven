package IO.DB.structure.databases;

import IO.DB.DBConnection;
import IO.DB.exceptions.InvalidTableDefinitionException;
import IO.DB.structure.tablas.Table;
import configuracion.Configuration;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by Matías on 30/04/2017.
 */
public class Database {
    private String name;
    private ArrayList<Table> tables;

    public Database(String name){
        this.name = name;
        this.tables = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public ArrayList<Table> getTables(){
        return tables;
    }

    public void addTable(Table table){
        this.tables.add(table);
    }

    /**
     * Creates the database and its tables.
     * @throws SQLException
     */
    public void create() throws SQLException, InvalidTableDefinitionException {
        Connection connection = getConnectionToDatabase();
        connection.setAutoCommit(true);

        for(Table table : tables){
            if(!tableExists(table.getName())){
                table.create(connection);
            }
        }

        DBConnection.disconnect(connection);
    }

    /**
     * This method tries to delete the database.
     * @return true if the database was deleted
     */
    public void delete() throws IOException {
        if(!exists()){
            throw new IOException("Couldn't find DB " + getDatabaseURL());
        }

        try {
            FileUtils.deleteDirectory(new File(getDatabaseURL()));
        }
        catch(IOException e) {
            throw new IOException("There was a problem while deleting the DB: " + e.getMessage());
        }
    }

    /**
     * Checks if the database exists.
     * @return true if it exists
     */
    public boolean exists(){
        File file = new File(getDatabaseURL());

        return file.exists();
    }

    /**
     * Checks if the table already exists in the database
     * @param tableName - The name of the table we want to check
     * @return true if the table exists
     */
    public boolean tableExists(String tableName) throws SQLException {
        Connection connection = getConnectionToDatabase();

        DatabaseMetaData metadata = connection.getMetaData();
        ResultSet resultSet = metadata.getTables( null, null, tableName.toUpperCase(), null);

        boolean tableExists = false;

        while( resultSet.next())
        {
            String table = resultSet.getString( "TABLE_NAME");

            if(table.equalsIgnoreCase(tableName)){
                tableExists = true;
                break;
            }
        }

        DBConnection.disconnect(connection);

        return tableExists;
    }

    /**
     * Builds the URL to the database
     * @return the URL of the database
     */
    public String getDatabaseURL(){
        String DBurl = Configuration.getInstance().getPathToDatabases();
        DBurl += this.getName();

        return DBurl;
    }

    /**
     * Creates a connection to the database
     * @return a Connection object connected to the database
     * @throws SQLException
     */
    public Connection getConnectionToDatabase() throws SQLException {
        Connection connection = DBConnection.createConnection(getDatabaseURL());
        return connection;
    }
}
