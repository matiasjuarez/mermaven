package IO.DB.DAO;

import IO.DB.DAO.condition.Condition;
import IO.DB.structure.tablas.Field;

import java.sql.ResultSet;
import java.util.ArrayList;

/**
 * Created by matias on 16/05/17.
 */
public class DAOHelper {

    public static ResultSet doSelect(ArrayList<Field> fields, Condition condition, String tableName){
        StringBuilder statement = new StringBuilder();
    }

    public static String getInsertionQuery(ArrayList<QueryField> fields, String tableName){
        StringBuilder statement = new StringBuilder();
        statement.append("INSERT INTO ");
        statement.append(tableName);
        statement.append("(");
        statement.append(getInsertionQueryFields(fields));
        statement.append(") ");
        statement.append("VALUES(");
        statement.append(getInsertionQueryValues(fields));
        statement.append(");");

        return statement.toString();
    }

    private static String getInsertionQueryFields(ArrayList<QueryField> fields){
        StringBuilder fieldsBuilder = new StringBuilder();
        for(QueryField field : fields){
            fieldsBuilder.append(field.getField().getName());
            fieldsBuilder.append(",");
        }

        String fieldString = fieldsBuilder.toString();
        return fieldString.substring(0, fieldString.length() - 1);
    }

    private static String getInsertionQueryValues(ArrayList<QueryField> fields){
        StringBuilder valuesBuilder = new StringBuilder();
        for(QueryField field : fields){
            valuesBuilder.append(FieldFormatter.formatField(field));
            valuesBuilder.append(",");
        }

        String valuesString = valuesBuilder.toString();
        return valuesString.substring(0, valuesString.length() - 1);
    }
}
