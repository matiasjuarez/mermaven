package IO.basedatos.estructura;

import IO.basedatos.estructura.baseDatos.BaseDatos_AnalisisEvolucion;
import IO.basedatos.estructura.baseDatos.BaseDeDatos;

import java.sql.SQLException;

/**
 * Created by Matías on 01/05/2017.
 */
public class InicializadorEstructura {

    public static void inicializarBasesDeDatos() throws SQLException {
        BaseDeDatos baseAnalisisEvolucion = new BaseDatos_AnalisisEvolucion();
        baseAnalisisEvolucion.crear();
    }
}
