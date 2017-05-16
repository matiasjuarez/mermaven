package IO.DB.structure;

import IO.DB.structure.databases.Database;
import IO.DB.structure.databases.DatabaseBuilder;

import java.sql.SQLException;

/**
 * Created by Matías on 01/05/2017.
 */
public class InicializadorEstructura {

    public static void inicializarBasesDeDatos() throws SQLException {
        Database baseAnalisisEvolucion = DatabaseBuilder.buildAnalysisMervalEvolutionDB();
        //baseAnalisisEvolucion.create();
    }
}
