package matias.conceptos.fondos;

import matias.conceptos.Bank;
import matias.conceptos.Currency;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by matias on 27/06/17.
 */
@Entity
public class MutualFund implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @ManyToOne(optional = false)
    private Bank bank;
    private String name;
    @ManyToOne(optional = false)
    private Currency currency;
    private float minimumInvestment;
    private float extractionLimit;
    private float porcentualSubscriptionCost;
    private float porcentualRescueCost;
    private int daysForRescue;
    private int daysForSubscription;
    @OneToMany(mappedBy = "mutualFund")
    private List<ShareQuotation> shareQuotations;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public float getMinimumInvestment() {
        return minimumInvestment;
    }

    public void setMinimumInvestment(float minimumInvestment) {
        this.minimumInvestment = minimumInvestment;
    }

    public float getExtractionLimit() {
        return extractionLimit;
    }

    public void setExtractionLimit(float extractionLimit) {
        this.extractionLimit = extractionLimit;
    }

    public float getPorcentualSubscriptionCost() {
        return porcentualSubscriptionCost;
    }

    public void setPorcentualSubscriptionCost(float porcentualSubscriptionCost) {
        this.porcentualSubscriptionCost = porcentualSubscriptionCost;
    }

    public float getPorcentualRescueCost() {
        return porcentualRescueCost;
    }

    public void setPorcentualRescueCost(float porcentualRescueCost) {
        this.porcentualRescueCost = porcentualRescueCost;
    }

    public int getDaysForRescue() {
        return daysForRescue;
    }

    public void setDaysForRescue(int daysForRescue) {
        this.daysForRescue = daysForRescue;
    }

    public int getDaysForSubscription() {
        return daysForSubscription;
    }

    public void setDaysForSubscription(int daysForSubscription) {
        this.daysForSubscription = daysForSubscription;
    }

    public List<ShareQuotation> getShareQuotations() {
        return shareQuotations;
    }

    public void setShareQuotations(List<ShareQuotation> shareQuotations) {
        this.shareQuotations = shareQuotations;
    }

    public void addShareQuotation(ShareQuotation shareQuotation){
        this.shareQuotations.add(shareQuotation);
    }

    public float getCurrentShareQuotation(){
        return getShareQuotations().get(getShareQuotations().size() - 1).getQuotation();
    }
}
