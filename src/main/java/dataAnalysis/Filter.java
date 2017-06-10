package dataAnalysis;

import utilidades.DateHandler;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by matias on 10/06/17.
 */
public class Filter {
    private ArrayList<IndicatorData> indicatorDataList;

    public Filter(ArrayList<IndicatorData> indicatorDataList){
        this.indicatorDataList = indicatorDataList;
    }

    public ArrayList<IndicatorData> getIndicatorsBetweenDates(Date fromDate, Date toDate){
        ArrayList<IndicatorData> filteredList = new ArrayList<>();
        Date fromDateMinus1 = DateHandler.addDays(fromDate, -1);
        Date toDatePlus1 = DateHandler.addDays(toDate, 1);

        for(IndicatorData indicatorData : indicatorDataList){
            Date indicatorDate = indicatorData.getDate();

            if(indicatorDate.after(fromDateMinus1) && indicatorDate.before(toDatePlus1)) {
                filteredList.add(indicatorData);
            }
        }

        return filteredList;
    }

    public ArrayList<IndicatorData> getIndicatorsAfterDate(Date fromDate){
        ArrayList<IndicatorData> filteredList = new ArrayList<>();

        for(IndicatorData indicatorData : indicatorDataList){
            Date indicatorDate = indicatorData.getDate();

            if(indicatorDate.after(fromDate)){
                filteredList.add(indicatorData);
            }
        }

        return filteredList;
    }

    public ArrayList<IndicatorData> getIndicatorsBeforeDate(Date toDate){
        ArrayList<IndicatorData> filteredList = new ArrayList<>();

        for(IndicatorData indicatorData : indicatorDataList){
            Date indicatorDate = indicatorData.getDate();

            if(indicatorDate.before(toDate)){
                filteredList.add(indicatorData);
            }
        }

        return filteredList;
    }
}
