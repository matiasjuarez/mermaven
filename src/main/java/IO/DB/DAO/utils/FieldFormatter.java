package IO.DB.DAO.utils;

import IO.DB.structure.tablas.Field;
import utilidades.StringHelper;

/**
 * Created by matias on 17/05/17.
 * This class contains the logic to get a value in the correct
 * format for queries.
 */
public class FieldFormatter {

    /**
     * Takes a QueryField and returns the value of the field surrounded or not by quotes
     * based on the type of the field.
     * @param queryField - The QueryField that has the value
     * @return the value of the QueryField as String
     */
    public static String formatField(QueryField queryField){
        if(queryField.getValue() == null){
            return "null";
        }

        if(areQuotesNeeded(queryField)){
            return StringHelper.encloseString(
                    queryField.getValue().toString(), StringHelper.EncloserElement.SINGLE_QUOTE);
        }

        return queryField.getValue().toString();
    }

    /**
     * Takes a Field and an Object and returns the value of the object
     * surrounded or not by quotes based on the type of the field.
     * @param field - The field which holds the dataType
     * @param value - The value we need to format
     * @return the Object value as a String
     */
    public static String formatField(Field field, Object value){
        return formatField(new QueryField(field, value));
    }

    /**
     * It determines if the value of the QueryField should be
     * surrounded by quotes based on the dataType of the field.
     * @param field
     * @return true if dataType is DATA, VARCHAR
     */
    private static boolean areQuotesNeeded(QueryField field){
        Field.Type dataTytpe = field.getField().getDataType();

        return dataTytpe == Field.Type.DATE;
    }
}
