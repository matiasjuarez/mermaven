package matias.inversor.IO.baseDatos;

import IO.DB.structure.databases.Database;
import IO.DB.structure.tablas.Field;
import IO.DB.structure.tablas.Table;

import java.io.IOException;

/**
 * Created by matias on 14/05/17.
 */
public class DataSetupHelper {

    public static String getTestDatabaseName(){
        return "testDB";
    }

    public static String getTestTableName(){
        return "testTable";
    }

    public static Database createTestDatabaseObject(){
        Database database = new Database(getTestDatabaseName());

        Table table = new Table(getTestTableName());

        Field field1 = new Field("field1", Field.Type.DATE);
        Field field2 = new Field("field2", Field.Type.FLOAT);

        database.addTable(table);
        table.addField(field1);
        table.addField(field2);

        return database;
    }

    public static void deleteDatabaseFromDisk(Database database){
        if(database.exists()){
            try {
                database.delete();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
