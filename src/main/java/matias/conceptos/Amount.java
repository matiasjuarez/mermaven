package matias.conceptos;

/**
 * Represent an amount of something along with its unit.
 * @author Matías
 */
public class Amount {
    private float quantity;
    private Currency currency;
    
    public Amount(){ }
    
    public Amount(Currency currency, float quantity){
        this.currency = currency;
        this.quantity = quantity;
    }
    
    public float getQuantity() {
        return quantity;
    }

    public void setQuantity(float quantity) {
        this.quantity = quantity;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }
}
