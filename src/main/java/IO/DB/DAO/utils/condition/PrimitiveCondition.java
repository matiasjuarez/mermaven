package IO.DB.DAO.utils.condition;

import IO.DB.DAO.utils.FieldFormatter;
import IO.DB.structure.tablas.Field;

/**
 * Created by matias on 17/05/17.
 */
public class PrimitiveCondition extends Condition {
    private Field field;
    private Object value;
    private OPERATOR operator;

    public PrimitiveCondition(Field field, Object value, OPERATOR operator) {
        this.field = field;
        this.value = value;
        this.operator = operator;
    }

    @Override
    protected String buildStringRepresentation() {
        StringBuilder builder = new StringBuilder();
        builder.append(field.getName());
        builder.append(operator.toString());

        /**
         * We check if the value is another Field. If that's the case,
         * the we build the condition with the name of that field.
         * Otherwise, we treat the value as a literal and we format it.
         */
        if (value instanceof Field) {
            Field field = (Field) value;
            builder.append(field.getName());
        } else {
            builder.append(FieldFormatter.formatField(field, value));
        }

        return builder.toString();
    }
}
