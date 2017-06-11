package entryPoints;

import dataAnalysis.FileReader.GoogleFinanceFileReader;
import dataAnalysis.IndicatorData;
import dataAnalysis.Output.Summarizer;
import dataAnalysis.Output.Summary;

import java.util.ArrayList;

/**
 * Created by matias on 10/06/17.
 */
public class DataAnalysis {
    public static void main(String args[]) throws Exception {
        String mervalDataURL = "/home/matias/Documents/Projects/mermaven/src/main/Datos/archivosMerval/mervalGoogleFinance.ods";

        GoogleFinanceFileReader fileReader = new GoogleFinanceFileReader();
        ArrayList<IndicatorData> indicatorDataList = fileReader.readIndicatorFile(mervalDataURL);

        Summarizer summarizer = new Summarizer(indicatorDataList);
        Summary summary = summarizer.buildSummary("MERVAL");

        System.out.print(summary.toString());
    }


}