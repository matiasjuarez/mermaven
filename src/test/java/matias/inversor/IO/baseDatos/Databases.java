package matias.inversor.IO.baseDatos;

import IO.DB.DBConnection;
import IO.DB.exceptions.InvalidTableDefinitionException;
import IO.DB.structure.databases.Database;
import IO.DB.structure.tablas.Field;
import IO.DB.structure.tablas.Table;
import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import static org.junit.Assert.*;

/**
 * Created by Matías on 29/04/2017.
 */
public class Databases {

    private final String ERROR_CONNECTION_STATUS_CHECK = "There was an error while verifying the status of the connection";

    private static Database dbTest;

    @BeforeClass
    public static void intialize(){
        dbTest = DataSetupHelper.createTestDatabaseObject();
        DataSetupHelper.deleteDatabaseFromDisk(dbTest);
    }

    @After
    public void clean(){
        DataSetupHelper.deleteDatabaseFromDisk(dbTest);
    }

    @Test
    public void testConnectionDisconnection(){
        boolean connectedSuccesfully = false;
        Connection connection = null;

        try {
            connection = dbTest.getConnectionToDatabase();
            connectedSuccesfully = true;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        assertTrue(connectedSuccesfully);
        assertNotNull(connection);

        try {
            assertFalse(connection.isClosed());
        } catch (SQLException e) {
            fail(ERROR_CONNECTION_STATUS_CHECK);
        }

        DBConnection.disconnect(connection);

        try {
            assertTrue(connection.isClosed());
        } catch (SQLException e) {
            fail(ERROR_CONNECTION_STATUS_CHECK);
        }
    }

    @Test
    public void testCreationDeletionOfDatabase(){
        assertFalse(dbTest.exists());

        try {
            dbTest.create();
        } catch (Exception e) {
            e.printStackTrace();
            fail(e.getMessage());
        }

        assertTrue(dbTest.exists());

        try {
            dbTest.delete();
        } catch (IOException e) {
            e.printStackTrace();
        }

        assertFalse(dbTest.exists());
    }

    @Test
    public void testTableExistence(){
        String fakeTableName = "fakeTable";
        try {
            dbTest.create();
        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }

        try {
            assertTrue(dbTest.tableExists(DataSetupHelper.getTestTableName()));
            assertFalse(dbTest.tableExists(fakeTableName));

            Table table = new Table(fakeTableName);
            table.addField(new Field("dummyField", Field.Type.FLOAT));
            dbTest.addTable(table);
            dbTest.create();

            assertTrue(dbTest.tableExists(fakeTableName));
        } catch (SQLException e) {
            e.printStackTrace();
            fail("A problem ocurred while validating table existence");
        } catch (InvalidTableDefinitionException e){
            e.printStackTrace();
            fail("One or more of the tables of 'dbTest' database has an invalid definition");
        }
    }
}
