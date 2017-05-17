package IO.DB.DAO.utils;

import IO.DB.structure.tablas.Field;

/**
 * Created by matias on 17/05/17.
 */
public class FieldFormatter {

    public static String formatField(QueryField queryField){
        Field.Type dataTytpe = queryField.getField().getDataType();

        if(dataTytpe == Field.Type.DATE){
            return "'" + queryField.getCurrentValue().toString() + "'";
        }
        else if(dataTytpe == Field.Type.FLOAT){
            return queryField.getCurrentValue().toString();
        }

        return null;
    }

    public static String formatField(Field field, Object value){
        return formatField(new QueryField(field, value));
    }
}
