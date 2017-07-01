package IO.DB.Repositories;

import IO.DB.Entities.Bank;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by matias on 27/06/17.
 */
public interface BankRepository extends CrudRepository<Bank, Integer>{

}
