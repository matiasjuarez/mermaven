package IO.DB.DAO.utils;

import IO.DB.structure.tablas.Field;

/**
 * Created by matias on 16/05/17.
 */
public class QueryField {
    private Field field;
    private Object value;

    public Field getField() {
        return field;
    }

    public void setField(Field field) {
        this.field = field;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public QueryField(){}

    public QueryField(Field field){
        this(field, null);
    }

    public QueryField(Field field, Object value){
        this.field = field;
        this.value = value;
    }
}
