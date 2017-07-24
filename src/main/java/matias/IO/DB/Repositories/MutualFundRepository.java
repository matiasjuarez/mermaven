package matias.IO.DB.Repositories;

import matias.conceptos.fondos.MutualFund;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by matias on 27/06/17.
 */
public interface MutualFundRepository extends CrudRepository<MutualFund, Integer>{
    List<MutualFund> findByName(String name);
}
