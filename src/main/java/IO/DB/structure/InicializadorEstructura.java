package IO.DB.structure;

import IO.DB.structure.databases.DB_Analysis_Merval_Evolution;
import IO.DB.structure.databases.DataBase;

import java.sql.SQLException;

/**
 * Created by Matías on 01/05/2017.
 */
public class InicializadorEstructura {

    public static void inicializarBasesDeDatos() throws SQLException {
        DataBase baseAnalisisEvolucion = new DB_Analysis_Merval_Evolution();
        baseAnalisisEvolucion.create();
    }
}
