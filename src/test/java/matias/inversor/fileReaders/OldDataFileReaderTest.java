package matias.inversor.fileReaders;

import matias.IO.OldDataLoad.HoldingDataRaw;
import matias.IO.OldDataLoad.OldDataFileReader;
import org.junit.Test;

import java.util.ArrayList;

/**
 * Created by matias on 10/07/17.
 */
public class OldDataFileReaderTest {

    @Test
    public void testReadOldDate() throws Exception {
        String url = "/home/matias/Desktop/Seguimiento.ods";
        OldDataFileReader reader = new OldDataFileReader(url);
        ArrayList<HoldingDataRaw> data = reader.readOldDataFile();
        System.out.println(data.size());
    }
}
