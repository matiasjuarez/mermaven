package IO.DB.DAO.utils.condition;

import utilidades.StringHelper;

/**
 * Created by matias on 17/05/17.
 */
public class BinaryCondition extends Condition{
    private Condition firstCondition;
    private Condition secondCondition;
    private OPERATOR operator;
    // This field is used to determine if we have to surround the result string of this condition with parenthesis
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
        String result =
                StringHelper.mixStrings(" ",
                        firstCondition.getStringRepresentation(),
                        operator.toString(),
                        secondCondition.getStringRepresentation());

        if(this.group){
            result = StringHelper.
                    encloseString(result, StringHelper.EncloserElement.PARENTHESIS);
        }

        return result;
    }
}
