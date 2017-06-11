package dataAnalysis.dataTools;

import dataAnalysis.IndicatorData;
import utilidades.DateHandler;
import utilidades.collections.CollectionFilter;
import utilidades.collections.CollectionFilterUtility;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by matias on 10/06/17.
 */
public class Filter {
    public static ArrayList<IndicatorData> getIndicatorsBetweenDates(
            ArrayList<IndicatorData> indicatorDataList, Date fromDate, Date toDate){

        Date fromDateMinus1 = DateHandler.addDays(fromDate, -1);
        Date toDatePlus1 = DateHandler.addDays(toDate, 1);

        return getFilteredList(indicatorDataList, myObject -> {
            Date indicatorDate = myObject.getDate();

            return indicatorDate.after(fromDateMinus1) && indicatorDate.before(toDatePlus1);
        });
    }

    public static ArrayList<IndicatorData> getIndicatorsAfterDate(
            ArrayList<IndicatorData> indicatorDataList, Date fromDate){

        return getFilteredList(indicatorDataList, myObject -> myObject.getDate().after(fromDate));
    }

    public static ArrayList<IndicatorData> getIndicatorsBeforeDate(
            ArrayList<IndicatorData> indicatorDataList, Date toDate){

        return getFilteredList(indicatorDataList, myObject -> myObject.getDate().before(toDate));
    }

    public static ArrayList<IndicatorData> getIndicatorsWithPositiveVariation(ArrayList<IndicatorData> indicatorDataList){
        return getFilteredList(indicatorDataList, myObject -> myObject.getPorcentualVariation() >= 0);
    }

    public static ArrayList<IndicatorData> getIndicatorsWithNegativeVariation(ArrayList<IndicatorData> indicatorDataList){
        return getFilteredList(indicatorDataList, myObject -> myObject.getPorcentualVariation() < 0);
    }

    private static ArrayList<IndicatorData> getFilteredList(ArrayList<IndicatorData> list, CollectionFilter<IndicatorData> filter){
        return CollectionFilterUtility.getFilteredCollection(list, filter);
    }
}
