package IO.DB.DAO.condition;

/**
 * Created by matias on 17/05/17.
 */
public abstract class Condition {
    public enum OPERATOR{
        EQ("="),
        NEQ("!="),
        LT("<"),
        LET("<="),
        GT(">"),
        GET(">="),
        AND("and"),
        OR("or");

        private String symbol;

        OPERATOR(String symbol){
            this.symbol = symbol;
        }

        @Override
        public String toString(){
            return symbol;
        }
    }

    private boolean isNegated;

    public boolean isNegated() {
        return isNegated;
    }

    public void setNegated(boolean negated) {
        isNegated = negated;
    }

    public String getStringRepresentation(){
        String condition = buildStringRepresentation();

        if(isNegated){
            StringBuilder builder = new StringBuilder();
            builder.append("NOT ");
            builder.append(condition);

            return builder.toString();
        }

        return condition;
    }

    protected abstract String buildStringRepresentation();
}
