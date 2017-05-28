package IO;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by matias on 22/05/17.
 */
public class PlainTextFileReader {

    public ArrayList<String> getLinesAsSeparatedStrings(String URL){
        ArrayList<String> lines = new ArrayList<>();

        BufferedReader br = null;
        FileReader fr = null;

        try {
            fr = new FileReader(URL);
            br = new BufferedReader(fr);

            String sCurrentLine;

            while ((sCurrentLine = br.readLine()) != null) {
                lines.add(sCurrentLine);
            }

        } catch (IOException e) {
            e.printStackTrace();
            lines = null;

        } finally {
            try {

                if (br != null)
                    br.close();

                if (fr != null)
                    fr.close();

            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

        return lines;
    }
}
