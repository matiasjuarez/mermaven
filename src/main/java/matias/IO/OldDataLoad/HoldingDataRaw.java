package matias.IO.OldDataLoad;

import java.util.Date;

/**
 * Created by matias on 09/07/17.
 */
public class HoldingDataRaw {
    private String fundName;
    private String shares;
    private String quotation;
    private String date;

    public String getFundName() {
        return fundName;
    }

    public void setFundName(String fundName) {
        this.fundName = fundName;
    }

    public String getShares() {
        return shares;
    }

    public void setShares(String shares) {
        this.shares = shares;
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
