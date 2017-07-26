package matias.miscellaneous;

import matias.IO.DB.Repositories.RepositoryHolder;
import matias.IO.SheetDataLoad.secondApproach.SheetDataLoader;
import matias.conceptos.Bank;
import matias.conceptos.Currency;
import matias.conceptos.CurrencyType;
import matias.conceptos.investment.InvestmentConceptOwner;
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
        loadInvestmentConceptOwners();
        loadSheetData();
    }

    private void loadSheetData(){
        String url = "/home/matias/Desktop/SeguimientoCompleto.ods";
        InvestmentConceptOwner santander =
                holder.getRepositoriesHolder_investment().
                        getInvestmentConceptOwnerRepository().findByName("santander");

        sheetDataLoader.setSheetURL(url);
        sheetDataLoader.setInvestmentConceptOwner(santander);
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

    private void loadInvestmentConceptOwners(){
        InvestmentConceptOwner santander = new InvestmentConceptOwner();
        santander.setName("santander");

        holder.getRepositoriesHolder_investment().getInvestmentConceptOwnerRepository().save(santander);
    }
}
