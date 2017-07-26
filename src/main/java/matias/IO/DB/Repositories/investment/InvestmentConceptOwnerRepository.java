package matias.IO.DB.Repositories.investment;

import matias.conceptos.investment.InvestmentConceptOwner;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by matias on 25/07/17.
 */
public interface InvestmentConceptOwnerRepository extends CrudRepository<InvestmentConceptOwner, Integer>{
    InvestmentConceptOwner findByName(String name);
}
