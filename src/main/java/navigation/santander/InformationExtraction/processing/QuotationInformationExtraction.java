package navigation.santander.InformationExtraction.processing;

/**
 * Created by matias on 28/05/17.
 */
public class QuotationInformationExtraction {
    private String fund;
    private String value;
    private String variationDaily;
    private String variation30;
    private String variation90;
    private String variation365;

    public String getFund() {
        return fund;
    }

    public void setFund(String fund) {
        this.fund = fund;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getVariationDaily() {
        return variationDaily;
    }

    public void setVariationDaily(String variationDaily) {
        this.variationDaily = variationDaily;
    }

    public String getVariation30() {
        return variation30;
    }

    public void setVariation30(String variation30) {
        this.variation30 = variation30;
    }

    public String getVariation90() {
        return variation90;
    }

    public void setVariation90(String variation90) {
        this.variation90 = variation90;
    }

    public String getVariation365() {
        return variation365;
    }

    public void setVariation365(String variation365) {
        this.variation365 = variation365;
    }
}
