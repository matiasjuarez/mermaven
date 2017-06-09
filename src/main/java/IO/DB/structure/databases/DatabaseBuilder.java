package IO.DB.structure.databases;

import IO.DB.structure.tablas.Table_Quotation;
import IO.DB.structure.tablas.Table_MervalPosition;

/**
 * Created by matias on 14/05/17.
 */
public class DatabaseBuilder {

    public static Database buildMervalAnalysisEvolutionDB(){
        String dbName = "merval_analysis_evolution";
        Database database = new Database(dbName);

        Table_MervalPosition mervalPosition = Table_MervalPosition.getInstance();
        database.addTable(mervalPosition.buildTable());

        return database;
    }

    public static Database buildFoundInformationDB(){
        String dbName = "found_information";
        Database database = new Database(dbName);

        Table_Quotation table_quotation = Table_Quotation.getInstance();
        database.addTable(table_quotation.buildTable());

        return database;
    }
}
