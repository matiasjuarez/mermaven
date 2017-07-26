package matias.conceptos.investment;

import matias.IO.DB.IdClasses.investment.QuotationId;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by matias on 24/07/17.
 */
@Entity
@IdClass(QuotationId.class)
public class Quotation implements Serializable{
    @Id
    private Date date;

    @ManyToOne
    @Id
    @JoinColumn
    private InvestmentConcept investmentConcept;
    private float opening;
    private float closing;

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

    public float getOpening() {
        return opening;
    }

    public void setOpening(float opening) {
        this.opening = opening;
    }

    public float getClosing() {
        return closing;
    }

    public void setClosing(float closing) {
        this.closing = closing;
    }
}
