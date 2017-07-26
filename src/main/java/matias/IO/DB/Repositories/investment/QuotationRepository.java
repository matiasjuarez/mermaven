package matias.IO.DB.Repositories.investment;

import matias.conceptos.investment.Quotation;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;

/**
 * Created by matias on 25/07/17.
 */
public interface QuotationRepository extends CrudRepository<Quotation, Integer>{
    Quotation findByDate(Date date);
}
