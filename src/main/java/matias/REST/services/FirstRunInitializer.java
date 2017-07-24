package matias.REST.services;

import matias.IO.DB.Repositories.CurrencyRepository;
import matias.IO.SheetDataLoad.SheetDataLoader;
import matias.REST.mappingRequestObjects.ExternalDataResource;
import matias.conceptos.Currency;
import matias.miscellaneous.Initializer;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by matias on 23/07/17.
 */

@RestController
@RequestMapping("/initializer")
public class FirstRunInitializer {

    @Autowired
    private Initializer initializer;

    @RequestMapping("/init")
    public String loadData(){
        String url = "/home/matias/Desktop/SheetDataExample.ods";
        initializer.initialize();
        return "Initialized app data";
    }
}
