package matias.REST;

import matias.IO.DB.Repositories.MutualFundRepository;
import matias.conceptos.fondos.MutualFund;
import matias.conceptos.fondos.ShareQuotation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by matias on 01/07/17.
 */

@RestController
@RequestMapping("/mutualFund")
public class MutualFundService {

    @Autowired
    private MutualFundRepository repository;

    @RequestMapping("/add")
    public String add(@RequestBody MutualFund mutualFund){
        repository.save(mutualFund);

        return "Saved mutual fund: " + mutualFund.getName() + " from bank " + mutualFund.getBank().getName();
    }

    @RequestMapping("/{id}/shareQuotation/add")
    public String addShareQuotation(@RequestBody ShareQuotation shareQuotation,
                                    @PathVariable("id") int mutualFundId){
        return "";
    }
}
