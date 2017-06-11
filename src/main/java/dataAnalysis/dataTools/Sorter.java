package dataAnalysis.dataTools;

import dataAnalysis.IndicatorData;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;

/**
 * Created by matias on 11/06/17.
 */
public class Sorter {

    public static int ASCENDING = 0;
    public static int DESCENDING = 1;

    public static void sortByDate(ArrayList<IndicatorData> data, int order) {

        Collections.sort(data, new Comparator<IndicatorData>() {
            @Override
            public int compare(IndicatorData indicatorData, IndicatorData t1) {
                Date date1 = indicatorData.getDate();
                Date date2 = t1.getDate();

                if (date1.before(date2)) {
                    return -1;
                } else if (date1.after(date2)) {
                    return 1;
                } else {
                    return 0;
                }

            }
        });

        if(order == Sorter.DESCENDING){
            Collections.reverse(data);
        }
    }
}
