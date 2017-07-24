package matias.IO.DB.Repositories;

import matias.conceptos.Bank;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by matias on 27/06/17.
 */
public interface BankRepository extends CrudRepository<Bank, Integer>{
    List<Bank> findByName(String name);
}
