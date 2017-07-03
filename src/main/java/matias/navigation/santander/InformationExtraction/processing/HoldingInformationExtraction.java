package matias.navigation.santander.InformationExtraction.processing;

/**
 * Created by matias on 28/05/17.
 */
public class HoldingInformationExtraction {
    private String fund;
    private String shareParts;
    private String lastQuotation;
    private String pesos;
    private String dolars;

    public String getFund() {
        return fund;
    }

    public void setFund(String fund) {
        this.fund = fund;
    }

    public String getShareParts() {
        return shareParts;
    }

    public void setShareParts(String shareParts) {
        this.shareParts = shareParts;
    }

    public String getLastQuotation() {
        return lastQuotation;
    }

    public void setLastQuotation(String lastQuotation) {
        this.lastQuotation = lastQuotation;
    }

    public String getPesos() {
        return pesos;
    }

    public void setPesos(String pesos) {
        this.pesos = pesos;
    }

    public String getDolars() {
        return dolars;
    }

    public void setDolars(String dolars) {
        this.dolars = dolars;
    }
}
