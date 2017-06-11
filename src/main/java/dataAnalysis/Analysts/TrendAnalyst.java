package dataAnalysis.Analysts;

import dataAnalysis.IndicatorData;
import dataAnalysis.Output.TrendAnalysis;
import dataAnalysis.Trend;

import java.util.ArrayList;

/**
 * Created by matias on 11/06/17.
 */
public class TrendAnalyst {

    public static TrendAnalysis analyzeTrend(ArrayList<IndicatorData> indicatorDataList){

        Trend trend = new Trend();

        trend.setAverageVariation(BasicAnalyst.getAverageVariation(indicatorDataList));
        trend.setSumOfVariations(BasicAnalyst.getSumOfVariations(indicatorDataList));
        trend.setSumOfPositiveVariations(BasicAnalyst.getSumOfPositiveVariations(indicatorDataList));
        trend.setSumOfNegativeVariations(BasicAnalyst.getSumOfNegativeVariations(indicatorDataList));


        trend.setMinVariation(BasicAnalyst.getMinVariation(indicatorDataList));
        trend.setMaxVariation(BasicAnalyst.getMaxVariation(indicatorDataList));
    }
}
