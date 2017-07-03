package matias.conceptos.fondos;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

/**
 * Represents an operation that will be done upon a MutualFund.
 * @author Matías
 */
@Entity
public class Request {
    
    public enum Type {
        RESCUE,
        SUBSCRIPTION
    };

    public enum Status {
        CREATED, // The operation has just been created
        STARTED, // The operation has started
        PROCESSED // The operation has ended
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private MutualFund mutualFund;
    private Type type;
    private Status status;
    private Date creationDate;
    private Date startedDate;
    private Date processedDate;

    // The operation can be specified in these two quantities
    private float shares;
    private float moneyAmount;

    public MutualFund getMutualFund() {
        return mutualFund;
    }

    public void setMutualFund(MutualFund mutualFund) {
        this.mutualFund = mutualFund;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Date getStartedDate() {
        return startedDate;
    }

    public void setStartedDate(Date startedDate) {
        this.startedDate = startedDate;
    }

    public Date getProcessedDate() {
        return processedDate;
    }

    public void setProcessedDate(Date processedDate) {
        this.processedDate = processedDate;
    }

    public float getShares() {
        return shares;
    }

    public void setShares(float shares) {
        this.shares = shares;
    }

    public float getMoneyAmount() {
        return moneyAmount;
    }

    public void setMoneyAmount(float moneyAmount) {
        this.moneyAmount = moneyAmount;
    }
}
