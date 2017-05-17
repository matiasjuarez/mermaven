package IO.DB.DAO;

import IO.DB.structure.tablas.Field;

/**
 * Created by matias on 16/05/17.
 */
public class QueryField {
    private Field field;
    private Object currentValue;
    private Object newValue;

    public Field getField() {
        return field;
    }

    public void setField(Field field) {
        this.field = field;
    }

    public Object getCurrentValue() {
        return currentValue;
    }

    public void setCurrentValue(Object currentValue) {
        this.currentValue = currentValue;
    }

    public Object getNewValue() {
        return newValue;
    }

    public void setNewValue(Object newValue) {
        this.newValue = newValue;
    }

    public QueryField(){}

    public QueryField(Field field){
        this(field, null);
    }

    public QueryField(Field field, Object currentValue){
        this.field = field;
        this.currentValue = currentValue;
    }
}
