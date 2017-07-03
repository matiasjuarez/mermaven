package matias.inversor.dataAnalysis;

import matias.dataAnalysis.IndicatorData;
import matias.utilidades.DateHandler;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by matias on 10/06/17.
 */
public class DataSetupHelper {
    private static String dateFormat = "dd/MM/yyyy";

    public static ArrayList<IndicatorData> getIndicatorDataForTest(){
        IndicatorData indicatorData1 = new IndicatorData();
        indicatorData1.setMinimum(100f);
        indicatorData1.setMaximum(150f);
        indicatorData1.setOpening(125f);
        indicatorData1.setClosing(140f);
        indicatorData1.setDate(getDateFromString("02/05/2000"));

        IndicatorData indicatorData2 = new IndicatorData();
        indicatorData2.setMinimum(100f);
        indicatorData2.setMaximum(200f);
        indicatorData2.setOpening(150f);
        indicatorData2.setClosing(120f);
        indicatorData2.setDate(getDateFromString("04/05/2000"));

        IndicatorData indicatorData3 = new IndicatorData();
        indicatorData3.setMinimum(130f);
        indicatorData3.setMaximum(220f);
        indicatorData3.setOpening(150f);
        indicatorData3.setClosing(190f);
        indicatorData3.setDate(getDateFromString("03/05/2000"));

        ArrayList<IndicatorData> indicatorDataList = new ArrayList<>();
        indicatorDataList.add(indicatorData1);
        indicatorDataList.add(indicatorData2);
        indicatorDataList.add(indicatorData3);

        return indicatorDataList;
    }

    private static Date getDateFromString(String string){
        try {
            Date date = DateHandler.parseDate(dateFormat, string);
            return date;
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }
}
