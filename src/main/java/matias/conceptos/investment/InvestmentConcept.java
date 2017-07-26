package matias.conceptos.investment;

import matias.conceptos.Currency;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by matias on 24/07/17.
 */
@Entity
public class InvestmentConcept implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private String symbol;
    @ManyToOne(optional = false)
    private Currency currency;
    @ManyToOne
    private InvestmentConceptOwner investmentConceptOwner;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public InvestmentConceptOwner getInvestmentConceptOwner() {
        return investmentConceptOwner;
    }

    public void setInvestmentConceptOwner(InvestmentConceptOwner investmentConceptOwner) {
        this.investmentConceptOwner = investmentConceptOwner;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }
}
