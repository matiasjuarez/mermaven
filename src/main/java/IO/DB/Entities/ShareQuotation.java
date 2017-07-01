package IO.DB.Entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

/**
 * Created by matias on 27/06/17.
 */
@Entity
public class ShareQuotation {
    @Id private Date date;
    @Id private int commonFund;
    private float quotation;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getCommonFund() {
        return commonFund;
    }

    public void setCommonFund(int commonFund) {
        this.commonFund = commonFund;
    }

    public float getQuotation() {
        return quotation;
    }

    public void setQuotation(float quotation) {
        this.quotation = quotation;
    }
}
