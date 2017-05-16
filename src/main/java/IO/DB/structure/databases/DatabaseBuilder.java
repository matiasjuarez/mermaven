package IO.DB.structure.databases;

import IO.DB.structure.tablas.TableBuilder;

/**
 * Created by matias on 14/05/17.
 */
public class DatabaseBuilder {

    public static Database buildAnalysisMervalEvolutionDB(){
        String dbName = "analysis_merval_evolution";
        Database database = new Database(dbName);

        database.addTable(TableBuilder.buildMervalPositionTable());

        return database;
    }
}
