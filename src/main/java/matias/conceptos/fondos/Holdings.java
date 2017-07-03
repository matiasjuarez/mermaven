package matias.conceptos.fondos;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by matias on 27/06/17.
 */
@Entity
public class Holdings implements Serializable{
    @Id private Date date;
    @Id private int commonFund;
    private float shares;

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

    public float getShares() {
        return shares;
    }

    public void setShares(float shares) {
        this.shares = shares;
    }
}
