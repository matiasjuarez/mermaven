package matias.IO.DB.Repositories;

import matias.conceptos.Currency;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by matias on 23/07/17.
 */
public interface CurrencyRepository extends CrudRepository<Currency, Integer> {

    Currency findBySymbol(String symbol);
}
