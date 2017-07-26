package matias.IO.SheetDataLoad;

/**
 * Created by matias on 09/07/17.
 */
public class SheetData {
    private String investmentConceptName;
    private String currencySymbol;
    private String holdings;
    private String quotation;
    private String date;

    public String getInvestmentConceptName() {
        return investmentConceptName;
    }

    public void setInvestmentConceptName(String investmentConceptName) {
        this.investmentConceptName = investmentConceptName;
    }

    public String getCurrencySymbol() {
        return currencySymbol;
    }

    public void setCurrencySymbol(String currencySymbol) {
        this.currencySymbol = currencySymbol;
    }

    public String getHoldings() {
        return holdings;
    }

    public void setHoldings(String holdings) {
        this.holdings = holdings;
    }

    public String getQuotation() {
        return quotation;
    }

    public void setQuotation(String quotation) {
        this.quotation = quotation;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
