package IO.DB.structure;

import IO.DB.exceptions.InvalidTableDefinitionException;
import IO.DB.structure.databases.Database;
import IO.DB.structure.databases.DatabaseBuilder;

import java.sql.SQLException;

/**
 * Created by Matías on 01/05/2017.
 */
public class DatabaseStructureInitializer {

    public static void initializeStructure() throws SQLException, InvalidTableDefinitionException {
        Database mervalAnalysisEvolution = DatabaseBuilder.buildMervalAnalysisEvolutionDB();
        mervalAnalysisEvolution.create();

        Database foundInformation = DatabaseBuilder.buildFoundInformationDB();
        foundInformation.create();
    }
}
