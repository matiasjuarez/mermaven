package matias.inversor.IO.baseDatos;

import IO.DB.structure.databases.Database;
import org.junit.After;
import org.junit.BeforeClass;

/**
 * Created by matias on 14/05/17.
 */
public class Tables {

    private static Database dbTest;

    @BeforeClass
    public static void intialize(){
        dbTest = DataSetupHelper.createTestDatabaseObject();
        DataSetupHelper.deleteDatabaseFromDisk(dbTest);
    }

    @After
    public void clean(){
        DataSetupHelper.deleteDatabaseFromDisk(dbTest);
    }
}
