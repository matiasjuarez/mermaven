package IO.DB.Entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by matias on 27/06/17.
 */
@Entity
public class CommonFund {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private int bank;
    private String name;
    private int currency;

    public int getBank() {
        return bank;
    }

    public void setBank(int bank) {
        this.bank = bank;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCurrency() {
        return currency;
    }

    public void setCurrency(int currency) {
        this.currency = currency;
    }
}
