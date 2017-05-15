package IO.DB.structure.databases;

import IO.DB.structure.tablas.MervalPositionsTable;
import IO.DB.structure.tablas.Table;

import java.util.ArrayList;

/**
 * Created by Matías on 30/04/2017.
 */
public class DB_Analysis_Merval_Evolution extends DataBase {

    public DB_Analysis_Merval_Evolution(){
        super("analysis_merval_evolution");
    }

    @Override
    protected ArrayList<Table> generateTables() {
        ArrayList<Table> tables = new ArrayList<>();
        tables.add(new MervalPositionsTable());

        return tables;
    }
}
