package matias.conceptos.fondos;

import matias.IO.DB.IdClasses.HoldingId;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by matias on 27/06/17.
 */
@Entity
@IdClass(HoldingId.class)
public class Holding implements Serializable{
    @Id
    private Date date;

    @ManyToOne
    @Id
    @JoinColumn
    private MutualFund mutualFund;
    private float shares;

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

    public float getShares() {
        return shares;
    }

    public void setShares(float shares) {
        this.shares = shares;
    }
}
