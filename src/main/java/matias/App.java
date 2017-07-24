package matias;

import matias.IO.SheetDataLoad.SheetDataLoader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Hello world!
 *
 */
@SpringBootApplication
public class App 
{
    @Autowired
    private SheetDataLoader sheetDataLoader;

    public static void main(String[] args) throws Exception {
        SpringApplication.run(App.class, args);


    }
}
