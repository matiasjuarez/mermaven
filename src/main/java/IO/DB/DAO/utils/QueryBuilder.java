package IO.DB.DAO.utils;

import IO.DB.DAO.utils.condition.Condition;
import IO.DB.structure.tablas.Field;
import utilidades.StringHelper;

import java.util.ArrayList;

/**
 * Created by matias on 16/05/17.
 */
public class QueryBuilder {
    private static final String SELECT = "SELECT";
    private static final String FROM = "FROM";
    private static final String WHERE = "WHERE";
    private static final String INSERT = "INSERT";
    private static final String INTO = "INTO";
    private static final String VALUES = "VALUES";

    /**
     * Builds up a select query.
     * @param fields - The fields we want to select
     * @param condition - The condition in the where clause
     * @param tableName - The table we need
     * @return a select query.
     */
    public static String getSelectQuery(ArrayList<QueryField> fields, Condition condition, String tableName){
        String statement = StringHelper.mixStrings(" ",
                SELECT,
                getFieldNamesSeparatedByComma_QueryField(fields),
                FROM,
                tableName,
                buildWhereCondition(condition));

        return finishStatementWithSemicolon(statement);
    }

    /**
     * Builds the condition of a statement.
     * @param condition
     * @return
     */
    private static String buildWhereCondition(Condition condition){
        if(condition == null){
            return "";
        }

        return StringHelper.
                mixStrings(" ",
                        WHERE,
                        condition.getStringRepresentation());
    }

    /**
     * Builds an insert query based on the values and dataTypes of the fields
     * and the name of the table.
     * @param fields - The fields into which we want to insert values
     * @param tableName - The goal table
     * @return the insert query
     */
    public static String getInsertionQuery(ArrayList<QueryField> fields, String tableName){
        String statement = StringHelper.mixStrings(" ",
                INSERT,
                INTO,
                tableName,
                StringHelper.encloseString(getFieldNamesSeparatedByComma_QueryField(fields), StringHelper.EncloserElement.PARENTHESIS),
                VALUES,
                StringHelper.encloseString(getInsertionQueryValues(fields), StringHelper.EncloserElement.PARENTHESIS));
        return finishStatementWithSemicolon(statement);
    }

    private static String finishStatementWithSemicolon(String statement){
        return statement + ";";
    }

    /**
     * Builds up a String with the names of the QueryField objects.
     * @param queryFields
     * @return a String with the name of the QueryField objects separated by commas
     */
    private static String getFieldNamesSeparatedByComma_QueryField(ArrayList<QueryField> queryFields){
        ArrayList<Field> fields = new ArrayList<>();

        for(QueryField queryField : queryFields){
            fields.add(queryField.getField());
        }

        return getFieldNamesSeparatedByComma_Field(fields);
    }

    /**
     * Builds up a String with the names of the Field objects.
     * @param fields
     * @return a String with the name of the Field objects separated by commas
     */
    private static String getFieldNamesSeparatedByComma_Field(ArrayList<Field> fields){
        ArrayList<String> fieldNames = new ArrayList<>();
        for(Field field : fields){
            fieldNames.add(field.getName());
        }

        return StringHelper.mixStrings(",", fieldNames);
    }

    /**
     * Builds up a String with the values of the QueryField objects
     * inside the ArrayList separated by commas.
     * @param fields
     * @return the values of the QueryField objects separated by comma
     */
    private static String getInsertionQueryValues(ArrayList<QueryField> fields){
        ArrayList<String> values = new ArrayList<>();
        for(QueryField field : fields){
            values.add(FieldFormatter.formatField(field));
        }

        return StringHelper.mixStrings(",", values);
    }
}
