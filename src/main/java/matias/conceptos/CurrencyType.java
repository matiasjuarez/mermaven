package matias.conceptos;

/**
 * Created by matias on 03/07/17.
 */
public enum CurrencyType {
    PESO("PESO"),
    DOLLAR("DOLLAR"),
    SHARE("SHARE");

    private String name;

    CurrencyType(String name){
        this.name = name;
    }
}
