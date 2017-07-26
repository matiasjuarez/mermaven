package matias.REST.services;

import matias.miscellaneous.Initializer;
import org.springframework.beans.factory.annotation.Autowired;
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
        initializer.initialize();
        return "Initialized app data";
    }
}
