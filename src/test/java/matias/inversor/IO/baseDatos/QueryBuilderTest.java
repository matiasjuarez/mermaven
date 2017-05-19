package matias.inversor.IO.baseDatos;

import IO.DB.DAO.utils.QueryBuilder;
import IO.DB.DAO.utils.QueryField;
import IO.DB.structure.tablas.Field;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;

/**
 * Created by matias on 19/05/17.
 */
public class QueryBuilderTest {
    private static String dbName;
    private static QueryField field1;
    private static QueryField field2;
    private static ArrayList<QueryField> fields;

    @Before
    public void initialize(){
        dbName = "database";
        field1 = new QueryField(new Field("field1", Field.Type.DATE), "10/10/1991");
        field2 = new QueryField(new Field("field2", Field.Type.FLOAT), 5.2);

        fields = new ArrayList<>();
        fields.add(field1);
        fields.add(field2);
    }

    @Test
    public void testInsertQuery(){
        String query = "INSERT INTO " + dbName + " (field1,field2,field3) VALUES ('" +
                field1.getValue() + "'," + field2.getValue() + ",null);";

        fields.add(new QueryField(new Field("field3", Field.Type.FLOAT)));

        String buildedQuery = QueryBuilder.getInsertionQuery(fields, dbName);

        Assert.assertEquals(query.toLowerCase(), buildedQuery.toLowerCase());
    }
}
