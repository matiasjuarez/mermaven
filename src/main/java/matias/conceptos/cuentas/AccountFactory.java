package matias.conceptos.cuentas;

import matias.conceptos.Currency;
import matias.conceptos.CurrencyType;

/**
 * Created by matias on 03/07/17.
 */
public class AccountFactory {

    public static Account createSavingsAccount(Currency currency){
        Account account = new Account(currency);
        account.setOverdraftLimit(0);

        return account;
    }

    public static Account createMutualFundAccount(){
        Currency currency = new Currency(CurrencyType.SHARE);
        Account account = new Account(currency);
        account.setOverdraftLimit(0);

        return account;
    }
}
