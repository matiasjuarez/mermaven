package matias.inversor.IO.baseDatos;

import IO.basedatos.DBConnection;
import IO.basedatos.estructura.InicializadorEstructura;
import configuracion.Configuration;
import junit.framework.Assert;
import junit.framework.TestCase;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by Matías on 29/04/2017.
 */
public class Databases extends TestCase{

    private final String ERROR_CONNECTION_STATUS_CHECK = "There was an error while verifying the status of the connection";

    private final String DB_TEST_URL = Configuration.getInstance().getPathToDatabases() + "DB_TEST";

    public void testConnectionDisconnection(){
        boolean connectedSuccesfully = false;
        Connection connection = null;

        try {
            connection = DBConnection.createConnection(DB_TEST_URL);
            connectedSuccesfully = true;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        assertTrue(connectedSuccesfully);
        assertNotNull(connection);

        try {
            assertFalse(connection.isClosed());
        } catch (SQLException e) {
            Assert.fail(ERROR_CONNECTION_STATUS_CHECK);
        }

        DBConnection.disconnect(connection);

        try {
            assertTrue(connection.isClosed());
        } catch (SQLException e) {
            Assert.fail(ERROR_CONNECTION_STATUS_CHECK);
        }
    }

    public void testInicializadorBaseDatos(){
        try {
            InicializadorEstructura.inicializarBasesDeDatos();
            assertTrue(true);
        } catch (SQLException e) {
            e.printStackTrace();
            fail();
        }
    }
}
