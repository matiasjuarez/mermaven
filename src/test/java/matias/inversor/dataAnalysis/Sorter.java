package matias.inversor.dataAnalysis;

import dataAnalysis.IndicatorData;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

/**
 * Created by matias on 11/06/17.
 */
public class Sorter {

    @Test
    public void testSortByDate(){
        ArrayList<IndicatorData> data = DataSetupHelper.getIndicatorDataForTest();

        dataAnalysis.dataTools.Sorter.sortByDate(data, dataAnalysis.dataTools.Sorter.ASCENDING);

        for(int i = 0; i < data.size() - 1; i++){
            Assert.assertTrue(data.get(i).getDate().before(data.get(i + 1).getDate()));
        }

        dataAnalysis.dataTools.Sorter.sortByDate(data, dataAnalysis.dataTools.Sorter.DESCENDING);

        for(int i = 0; i < data.size() - 1; i++){
            Assert.assertTrue(data.get(i).getDate().after(data.get(i + 1).getDate()));
        }
    }
}
