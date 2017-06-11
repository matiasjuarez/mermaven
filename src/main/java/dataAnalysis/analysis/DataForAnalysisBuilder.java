package dataAnalysis.analysis;

import dataAnalysis.IndicatorData;
import dataAnalysis.analysis.Analysts.BasicAnalyst;
import dataAnalysis.analysis.BasicAnalystData;

import java.util.ArrayList;

/**
 * Created by matias on 11/06/17.
 */
public class DataForAnalysisBuilder {

    private int worstVariationsAmount;
    private int bestVariationsAmount;
    private float allowedGapFromAverage;

    public DataForAnalysisBuilder(){
        this(10, 10);
    }

    public DataForAnalysisBuilder(int worstVariationsAmount, int bestVariationsAmount){
        this(worstVariationsAmount, bestVariationsAmount, 0.5f);
    }

    public DataForAnalysisBuilder(int worstVariationsAmount, int bestVariationsAmount, float allowedGapFromAverage){
        this.worstVariationsAmount = worstVariationsAmount;
        this.bestVariationsAmount = bestVariationsAmount;
        this.allowedGapFromAverage = allowedGapFromAverage;
    }

    public DataForAnalysis buildDataForAnalysis(ArrayList<IndicatorData> data){
        DataForAnalysis dataForAnalysis = new DataForAnalysis();
        dataForAnalysis.setBasicAnalystData(getBasicAnalystData(data));

        return dataForAnalysis;
    }

    private BasicAnalystData getBasicAnalystData(ArrayList<IndicatorData> list){
        BasicAnalystData data = new BasicAnalystData();

        data.setIndicatorDataList(list);

        data.setAverageVariation(BasicAnalyst.getAverageVariation(list));
        data.setSumOfVariations(BasicAnalyst.getSumOfVariations(list));
        data.setSumOfPositiveVariations(BasicAnalyst.getSumOfPositiveVariations(list));
        data.setSumOfNegativeVariations(BasicAnalyst.getSumOfNegativeVariations(list));

        data.setMaxVariation(BasicAnalyst.getMaxVariation(list));
        data.setMinVariation(BasicAnalyst.getMinVariation(list));
        data.setMaxClosing(BasicAnalyst.getMaxClosing(list));
        data.setMinOpening(BasicAnalyst.getMinOpening(list));

        data.setBestVariation(BasicAnalyst.getBestVariation(list));
        data.setWorstVariation(BasicAnalyst.getWorstVariation(list));
        data.setBestVariations(BasicAnalyst.getBestNVariations(list, bestVariationsAmount));
        data.setWorstVariations(BasicAnalyst.getWorstNVariations(list, worstVariationsAmount));
        data.setVariationsCloseToAverage(BasicAnalyst.getIndicatorDataWithVariationCloseToAverage(list, allowedGapFromAverage));

        return data;
    }
}
