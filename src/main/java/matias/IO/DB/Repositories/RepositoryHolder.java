package matias.IO.DB.Repositories;

import matias.IO.DB.Repositories.investment.HoldingRepository;
import matias.IO.DB.Repositories.investment.RepositoriesHolder_Investment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by matias on 23/07/17.
 */
@Component
public class RepositoryHolder {
    @Autowired
    private BankRepository bankRepository;
    @Autowired
    private MutualFundRepository mutualFundRepository;
    @Autowired
    private HoldingRepository holdingRepository;
    @Autowired
    private ShareQuotationRepository shareQuotationRepository;
    @Autowired
    private RepositoriesHolder_Investment repositoriesHolder_investment;

    @Autowired
    private CurrencyRepository currencyRepository;

    public BankRepository getBankRepository() {
        return bankRepository;
    }

    public void setBankRepository(BankRepository bankRepository) {
        this.bankRepository = bankRepository;
    }

    public MutualFundRepository getMutualFundRepository() {
        return mutualFundRepository;
    }

    public void setMutualFundRepository(MutualFundRepository mutualFundRepository) {
        this.mutualFundRepository = mutualFundRepository;
    }

    public HoldingRepository getHoldingRepository() {
        return holdingRepository;
    }

    public void setHoldingRepository(HoldingRepository holdingRepository) {
        this.holdingRepository = holdingRepository;
    }

    public ShareQuotationRepository getShareQuotationRepository() {
        return shareQuotationRepository;
    }

    public void setShareQuotationRepository(ShareQuotationRepository shareQuotationRepository) {
        this.shareQuotationRepository = shareQuotationRepository;
    }

    public CurrencyRepository getCurrencyRepository() {
        return currencyRepository;
    }

    public void setCurrencyRepository(CurrencyRepository currencyRepository) {
        this.currencyRepository = currencyRepository;
    }

    public RepositoriesHolder_Investment getRepositoriesHolder_investment() {
        return repositoriesHolder_investment;
    }

    public void setRepositoriesHolder_investment(RepositoriesHolder_Investment repositoriesHolder_investment) {
        this.repositoriesHolder_investment = repositoriesHolder_investment;
    }
}
