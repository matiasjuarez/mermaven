package matias.conceptos.fondos;

import matias.IO.DB.IdClasses.HoldingId;
import matias.conceptos.investment.InvestmentConcept;

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
    private InvestmentConcept investmentConcept;
    private float amount;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public InvestmentConcept getInvestmentConcept() {
        return investmentConcept;
    }

    public void setInvestmentConcept(InvestmentConcept investmentConcept) {
        this.investmentConcept = investmentConcept;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }
}
