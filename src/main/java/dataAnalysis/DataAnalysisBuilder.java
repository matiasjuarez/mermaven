package dataAnalysis;

import dataAnalysis.Analysts.BasicAnalyst;

import java.util.ArrayList;

/**
 * Created by matias on 11/06/17.
 */
public class DataAnalysisBuilder {

    public DataAnalysis buildDataAnalysis(ArrayList<IndicatorData> data){
        DataAnalysis dataAnalysis = new DataAnalysis();
        dataAnalysis.setIndicatorDataList(data);

        fillWithBasicAnalystData(dataAnalysis);
    }

    private void fillWithBasicAnalystData(DataAnalysis dataAnalysis){
        ArrayList<IndicatorData> data = dataAnalysis.getIndicatorDataList();

        dataAnalysis.setAverageVariation(BasicAnalyst.getAverageVariation(data));
        dataAnalysis.setSumOfVariations(BasicAnalyst.getSumOfVariations(data));
        dataAnalysis.setSumOfPositiveVariations(BasicAnalyst.getSumOfPositiveVariations(data));
        dataAnalysis.setSumOfNegativeVariations(BasicAnalyst.getSumOfNegativeVariations(data));

        dataAnalysis.setMaxVariation(BasicAnalyst.getMaxVariation(data));
        dataAnalysis.setMinVariation(BasicAnalyst.getMinVariation(data));
    }
}
