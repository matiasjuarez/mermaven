package matias.navigation.santander.InformationExtraction.processing;

import matias.conceptos.Currency;
import matias.conceptos.CurrencyType;

/**
 * Created by matias on 28/05/17.
 */
public class Quotation {
    private String fund;
    private float value;
    private float dailyVariation;
    private float variation30;
    private float variation60;
    private float variaiton365;
    private Currency currency;

    private final String pesoSymbol = "$";
    private final String dolarSymbol = "U$S";

    public Quotation(QuotationInformationExtraction quotation){
        fund = quotation.getFund();
        dailyVariation = Float.parseFloat(quotation.getValue());
        variation30 = Float.parseFloat(quotation.getVariation30());
        variation60 = Float.parseFloat(quotation.getVariation90());
        variaiton365 = Float.parseFloat(quotation.getVariation365());

        String rawValue = quotation.getValue();
        if(rawValue.contains(pesoSymbol)){
            currency = new Currency(CurrencyType.PESO);
            rawValue.replaceAll(pesoSymbol, "");
        }
    }

    public String getFund() {
        return fund;
    }

    public float getValue() {
        return value;
    }

    public float getDailyVariation() {
        return dailyVariation;
    }

    public float getVariation30() {
        return variation30;
    }

    public float getVariation60() {
        return variation60;
    }

    public float getVariaiton365() {
        return variaiton365;
    }

    public Currency getCurrency() {
        return currency;
    }
}
