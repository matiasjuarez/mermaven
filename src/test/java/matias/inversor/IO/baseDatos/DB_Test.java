package matias.inversor.IO.baseDatos;

import IO.DB.structure.databases.DataBase;
import IO.DB.structure.tablas.Table;

import java.util.ArrayList;

/**
 * Created by matias on 14/05/17.
 */
public class DB_Test extends DataBase{

    public DB_Test(){
        super("DB_TEST");
    }

    @Override
    protected ArrayList<Table> generateTables() {
        ArrayList<Table> tables = new ArrayList<>();
        tables.add(new Table_Test());
        return tables;
    }
}
