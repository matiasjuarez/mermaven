package IO.DB.DAO.utils;

import IO.DB.DAO.utils.condition.Condition;
import IO.DB.structure.tablas.Field;

import java.util.ArrayList;

/**
 * Created by matias on 16/05/17.
 */
public class QueryBuilder {

    public static String getSelectQuery(ArrayList<Field> fields, Condition condition, String tableName){
        StringBuilder statement = new StringBuilder();
        statement.append("SELECT ");
        statement.append(getFieldNamesSeparatedByComma_Field(fields));
        statement.append(" FROM ");
        statement.append(tableName);
        statement.append(" ");
        statement.append(buildWhereCondition(condition));
        statement.append(";");

        return statement.toString();
    }

    private static String buildWhereCondition(Condition condition){
        StringBuilder builder = new StringBuilder();
        builder.append("WHERE ");
        builder.append(condition.toString());
        return builder.toString();
    }

    public static String getInsertionQuery(ArrayList<QueryField> fields, String tableName){
        StringBuilder statement = new StringBuilder();
        statement.append("INSERT INTO ");
        statement.append(tableName);
        statement.append("(");
        statement.append(getFieldNamesSeparatedByComma_QueryField(fields));
        statement.append(") ");
        statement.append("VALUES(");
        statement.append(getInsertionQueryValues(fields));
        statement.append(");");

        return statement.toString();
    }

    private static String getFieldNamesSeparatedByComma_QueryField(ArrayList<QueryField> queryFields){
        ArrayList<Field> fields = new ArrayList<>();

        for(QueryField queryField : queryFields){
            fields.add(queryField.getField());
        }

        return getFieldNamesSeparatedByComma_Field(fields);
    }

    private static String getFieldNamesSeparatedByComma_Field(ArrayList<Field> fields){
        StringBuilder fieldsBuilder = new StringBuilder();
        for(Field field : fields){
            fieldsBuilder.append(field.getName());
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
