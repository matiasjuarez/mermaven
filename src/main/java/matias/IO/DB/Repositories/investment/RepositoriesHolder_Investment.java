package matias.IO.DB.Repositories.investment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by matias on 25/07/17.
 */
@Component
public class RepositoriesHolder_Investment {
    @Autowired
    private InvestmentConceptOwnerRepository investmentConceptOwnerRepository;
    @Autowired
    private InvestmentConceptRepository investmentConceptRepository;
    @Autowired
    private QuotationRepository quotationRepository;
    @Autowired
    private HoldingRepository holdingRepository;

    public InvestmentConceptOwnerRepository getInvestmentConceptOwnerRepository() {
        return investmentConceptOwnerRepository;
    }

    public InvestmentConceptRepository getInvestmentConceptRepository() {
        return investmentConceptRepository;
    }

    public QuotationRepository getQuotationRepository() {
        return quotationRepository;
    }

    public HoldingRepository getHoldingRepository() {
        return holdingRepository;
    }
}
