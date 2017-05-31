package navigation.santander.InformationExtraction.processing;

/**
 * Created by matias on 28/05/17.
 */
public class Holding {
    private String fund;
    private float shareParts;
    private float lastQuotation;
    private float pesos;
    private float dolars;

    public String getFund() {
        return fund;
    }

    public void setFund(String fund) {
        this.fund = fund;
    }

    public float getShareParts() {
        return shareParts;
    }

    public void setShareParts(float shareParts) {
        this.shareParts = shareParts;
    }

    public float getLastQuotation() {
        return lastQuotation;
    }

    public void setLastQuotation(float lastQuotation) {
        this.lastQuotation = lastQuotation;
    }

    public float getPesos() {
        return pesos;
    }

    public void setPesos(float pesos) {
        this.pesos = pesos;
    }

    public float getDolars() {
        return dolars;
    }

    public void setDolars(float dolars) {
        this.dolars = dolars;
    }
}
