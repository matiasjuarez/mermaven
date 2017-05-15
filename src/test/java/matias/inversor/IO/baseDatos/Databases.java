package matias.inversor.IO.baseDatos;

import IO.DB.DBConnection;
import IO.DB.structure.databases.DataBase;
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

    private static DataBase dbTest;

    @BeforeClass
    public static void intialize(){
        dbTest = new DB_Test();
        deleteTestDatabase();
    }

    @After
    public void clean(){
        deleteTestDatabase();
    }

    private static void deleteTestDatabase(){
        if(dbTest.exists()){
            try {
                dbTest.delete();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
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
        } catch (SQLException e) {
            e.printStackTrace();
        }

        assertTrue(dbTest.exists());

        try {
            dbTest.delete();
        } catch (IOException e) {
            e.printStackTrace();
        }

        assertFalse(dbTest.exists());
    }
}
