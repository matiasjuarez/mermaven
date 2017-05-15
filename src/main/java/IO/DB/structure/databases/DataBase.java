package IO.DB.structure.databases;

import IO.DB.DBConnection;
import IO.DB.structure.tablas.Table;
import configuracion.Configuration;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by Matías on 30/04/2017.
 */
public abstract class DataBase {
    private String name;
    protected ArrayList<Table> tables;

    public DataBase(String name){
        this.name = name;
        addTables();
    }

    public String getName() {
        return name;
    }

    /**
     * This is a template method for 'generateTables' method.
     */
    private void addTables(){
        this.tables = new ArrayList<>();

        ArrayList<Table> tables = generateTables();
        for(Table table : tables){
            this.tables.add(table);
        }
    }

    /**
     * This method should contain the code to generate an arrayList of the tables
     * that each database needs.
     * @return an ArrayList of the tables needed by a particular DB
     */
    protected abstract ArrayList<Table> generateTables();

    /**
     * Creates the database and its tables.
     * @throws SQLException
     */
    public void create() throws SQLException{
        Connection connection = getConnectionToDatabase();
        connection.setAutoCommit(true);

        for(Table table : tables){
            table.create(connection);
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
