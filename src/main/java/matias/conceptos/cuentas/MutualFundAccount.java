package matias.conceptos.cuentas;

import matias.conceptos.Currency;
import matias.conceptos.fondos.MutualFund;

/**
 * Created by matias on 03/07/17.
 */
public class MutualFundAccount extends Account{
    private Currency fundCurrency;
    private MutualFund mutualFund;

    public MutualFundAccount(Currency currency, MutualFund mutualFund){
        super(new Currency());
        this.fundCurrency = currency;
        this.mutualFund = mutualFund;
    }

    public Currency getFundCurrency() {
        return fundCurrency;
    }

    public MutualFund getMutualFund() {
        return mutualFund;
    }
}
