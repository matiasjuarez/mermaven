package matias.dataAnalysis.FileReader;

import matias.dataAnalysis.IndicatorData;
import matias.dataAnalysis.IndicatorParser.GoogleFinanceIndicatorParser;

import java.util.ArrayList;

/**
 * Created by matias on 09/06/17.
 */
public class GoogleFinanceFileReader {

    private IndicatorFileReader indicatorFileReader;

    public GoogleFinanceFileReader(){
        String tableName = "data";

        indicatorFileReader = new IndicatorFileReader();
        indicatorFileReader.setDateColumn(0);
        indicatorFileReader.setOpeningColumn(1);
        indicatorFileReader.setMaximumColumn(2);
        indicatorFileReader.setMinimumColumn(3);
        indicatorFileReader.setClosingColumn(4);
        indicatorFileReader.setFirstRowToRead(1);
        indicatorFileReader.setTableName(tableName);
    }

    public ArrayList<IndicatorData> readIndicatorFile(String url) throws Exception {
        ArrayList<RawIndicatorData> rawIndicatorDataList = indicatorFileReader.readIndicatorFile(url);
        ArrayList<IndicatorData> indicatorDataList = GoogleFinanceIndicatorParser.parseRawIndicatorList(rawIndicatorDataList);

        return indicatorDataList;
    }
}
