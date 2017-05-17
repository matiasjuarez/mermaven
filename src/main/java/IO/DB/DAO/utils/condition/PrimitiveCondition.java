package IO.DB.DAO.utils.condition;

import IO.DB.DAO.utils.FieldFormatter;
import IO.DB.structure.tablas.Field;

/**
 * Created by matias on 17/05/17.
 */
public class PrimitiveCondition extends Condition{
    private Field field;
    private Object value;
    private OPERATOR operator;

    public PrimitiveCondition(Field field, Object value, OPERATOR operator){
        this.field = field;
        this.value = value;
        this.operator = operator;
    }

    @Override
    protected String buildStringRepresentation() {
        StringBuilder builder = new StringBuilder();
        builder.append(field.getName());
        builder.append(operator.toString());
        builder.append(FieldFormatter.formatField(field, value));

        return builder.toString();
    }
}
