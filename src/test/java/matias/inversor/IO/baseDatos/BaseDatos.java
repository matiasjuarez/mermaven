package matias.inversor.IO.baseDatos;

import IO.basedatos.Conexion;
import IO.basedatos.estructura.InicializadorEstructura;
import configuracion.Configuracion;
import junit.framework.Assert;
import junit.framework.TestCase;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by Matías on 29/04/2017.
 */
public class BaseDatos extends TestCase{

    private final String errorVerificarEstadoConexion = "Error al verificar el estado de la conexion";

    private final String nombreBaseDeDatos = Configuracion.getInstance().getPathBaseDatos() + "BASE_PRUEBA";

    public void testConexionDesconexion(){
        Conexion conexion = new Conexion(nombreBaseDeDatos);

        boolean conexionExitosa = false;
        Connection connection = null;

        try {
            connection = conexion.conectar(true);
            conexionExitosa = true;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        assertTrue(conexionExitosa);
        assertNotNull(connection);

        try {
            assertFalse(connection.isClosed());
        } catch (SQLException e) {
            Assert.fail(errorVerificarEstadoConexion);
        }

        conexion.desconectar();

        try {
            assertTrue(connection.isClosed());
        } catch (SQLException e) {
            Assert.fail(errorVerificarEstadoConexion);
        }

        assertNull(conexion.getConnection());
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
