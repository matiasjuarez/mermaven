package IO.DB.DAO.condition;

/**
 * Created by matias on 17/05/17.
 */
public class BinaryCondition extends Condition{
    private Condition firstCondition;
    private Condition secondCondition;
    private OPERATOR operator;
    private boolean group;

    public BinaryCondition(Condition firstCondition, Condition secondCondition, OPERATOR operator){
        this(firstCondition, secondCondition, operator, false);
    }

    public BinaryCondition(Condition firstCondition, Condition secondCondition, OPERATOR operator, boolean group){
        this.firstCondition = firstCondition;
        this.secondCondition = secondCondition;
        this.operator = operator;
        this.group = group;
    }

    @Override
    protected String buildStringRepresentation() {
        StringBuilder builder = new StringBuilder();
        builder.append(firstCondition.getStringRepresentation());
        builder.append(" ");
        builder.append(operator.toString());
        builder.append(" ");
        builder.append(secondCondition.getStringRepresentation());

        String result = builder.toString();

        if(this.group){
            StringBuilder groupBuilder = new StringBuilder();
            groupBuilder.append("(");
            groupBuilder.append(result);
            groupBuilder.append(")");
            result = groupBuilder.toString();
        }

        return result;
    }
}
