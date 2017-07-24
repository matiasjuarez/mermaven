package matias.IO.DB.Repositories;

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
}
