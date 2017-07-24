package matias.conceptos;

/**
 * Created by matias on 03/07/17.
 */
public enum CurrencyType {
    PESO("PESO", "$"),
    DOLLAR("DOLLAR", "U$S"),
    SHARE("SHARE");

    private String name;
    private String symbol;

    CurrencyType(String name, String symbol){
        this.name = name;
        this.symbol = symbol;
    }

    CurrencyType(String name){
        this(name, null);
    }

    public String getName() {
        return name;
    }

    public String getSymbol() {
        return symbol;
    }
}
