package matias.miscellaneous;

import matias.IO.DB.Repositories.CurrencyRepository;
import matias.IO.DB.Repositories.RepositoryHolder;
import matias.IO.SheetDataLoad.SheetDataLoader;
import matias.conceptos.Bank;
import matias.conceptos.Currency;
import matias.conceptos.CurrencyType;
import matias.conceptos.fondos.MutualFund;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by matias on 23/07/17.
 */
@Component
public class Initializer {
    @Autowired
    private SheetDataLoader sheetDataLoader;

    @Autowired
    private RepositoryHolder holder;

    public void initialize(){
        loadCurrencies();
        loadBanks();
        loadSheetData();
    }

    private void loadSheetData(){
        String url = "/home/matias/Desktop/Seguimiento.ods";
        Bank santander = holder.getBankRepository().findByName("santander").get(0);
        sheetDataLoader.setSheetURL(url);
        sheetDataLoader.setBank(santander);
        sheetDataLoader.loadDataIntoDatabase();
    }

    @Transactional
    private void loadCurrencies(){
        holder.getCurrencyRepository().save(new Currency(CurrencyType.PESO));
        holder.getCurrencyRepository().save(new Currency(CurrencyType.DOLLAR));
    }

    @Transactional
    private void loadBanks(){
        Bank bank = new Bank();
        bank.setName("santander");

        holder.getBankRepository().save(bank);
    }
}
