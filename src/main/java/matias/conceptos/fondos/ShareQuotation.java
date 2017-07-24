package matias.conceptos.fondos;

import matias.IO.DB.IdClasses.ShareQuotationId;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by matias on 27/06/17.
 */
@Entity
@IdClass(ShareQuotationId.class)
public class ShareQuotation implements Serializable{
    @Id
    private Date date;

    @ManyToOne
    @Id
    @JoinColumn
    private MutualFund mutualFund;
    private float quotation;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public MutualFund getMutualFund() {
        return mutualFund;
    }

    public void setMutualFund(MutualFund mutualFund) {
        this.mutualFund = mutualFund;
    }

    public float getQuotation() {
        return quotation;
    }

    public void setQuotation(float quotation) {
        this.quotation = quotation;
    }
}
