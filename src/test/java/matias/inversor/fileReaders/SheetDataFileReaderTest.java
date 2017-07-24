package matias.inversor.fileReaders;

import matias.IO.SheetDataLoad.SheetData;
import matias.IO.SheetDataLoad.SheetDataFileReader;
import org.junit.Test;

import java.util.ArrayList;

/**
 * Created by matias on 10/07/17.
 */
public class SheetDataFileReaderTest {

    @Test
    public void testReadOldDate() throws Exception {
        String url = "/home/matias/Desktop/Seguimiento.ods";
        SheetDataFileReader reader = new SheetDataFileReader(url);
        ArrayList<SheetData> data = reader.readOldDataFile();
        System.out.println(data.size());
    }
}
