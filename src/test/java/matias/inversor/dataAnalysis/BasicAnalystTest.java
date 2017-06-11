package matias.inversor.dataAnalysis;

import dataAnalysis.Analysts.BasicAnalyst;
import dataAnalysis.IndicatorData;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

/**
 * Created by matias on 10/06/17.
 */
public class BasicAnalystTest {
    private static ArrayList<IndicatorData> indicatorDataList;

    @Before
    public void setup(){
        indicatorDataList = DataSetupHelper.getIndicatorDataForTest();
    }

    @Test
    public void testBestVariation(){
        IndicatorData indicatorData = BasicAnalyst.getBestVariation(indicatorDataList);
        Float porcentualVariation = indicatorData.getPorcentualVariation();

        Assert.assertEquals(26.66, porcentualVariation, 0.1);
    }

    @Test
    public void testWorstVariation(){
        IndicatorData indicatorData = BasicAnalyst.getWorstVariation(indicatorDataList);
        Float porcentualVariation = indicatorData.getPorcentualVariation();

        Assert.assertEquals(-20, porcentualVariation, 0.1);
    }

    @Test
    public void testAverageVariation(){
        Float averageVariation = BasicAnalyst.getAverageVariation(indicatorDataList);

        Assert.assertEquals(6.22, averageVariation, 0.1);
    }

    @Test
    public void testGetIndicatorsVariationAboveAverage(){
        Float averageVariation = BasicAnalyst.getAverageVariation(indicatorDataList);
        ArrayList<IndicatorData> indicatorDataAboveAverage = BasicAnalyst.getIndicatorDataWithVariationAboveAverage(indicatorDataList);

        Assert.assertEquals(2, indicatorDataAboveAverage.size());

        for(IndicatorData indicatorData : indicatorDataAboveAverage){
            Assert.assertTrue(indicatorData.getPorcentualVariation() > averageVariation);
        }
    }

    @Test
    public void testGetIndicatorsVariationBelowAverage(){
        Float averageVariation = BasicAnalyst.getAverageVariation(indicatorDataList);
        ArrayList<IndicatorData> indicatorDataBelowAverage = BasicAnalyst.getIndicatorDataWithVariationBelowAverage(indicatorDataList);

        Assert.assertEquals(1, indicatorDataBelowAverage.size());

        for(IndicatorData indicatorData : indicatorDataBelowAverage){
            Assert.assertTrue(indicatorData.getPorcentualVariation() < averageVariation);
        }
    }

    @Test
    public void testGetIndicatorsVariationCloseToAverage(){
        Float averageVariation = BasicAnalyst.getAverageVariation(indicatorDataList);

        Float allowedGap = 10f;
        ArrayList<IndicatorData> indicatorDataCloseToAverage = BasicAnalyst.getIndicatorDataWithVariationCloseToAverage(indicatorDataList, allowedGap);
        Assert.assertEquals(1, indicatorDataCloseToAverage.size());

        for(IndicatorData indicatorData : indicatorDataCloseToAverage){
            Assert.assertTrue(isDistanceBetweenValuesValid(indicatorData.getPorcentualVariation(), averageVariation, allowedGap));
        }

        allowedGap = 30f;
        indicatorDataCloseToAverage = BasicAnalyst.getIndicatorDataWithVariationCloseToAverage(indicatorDataList, allowedGap);
        Assert.assertEquals(3, indicatorDataCloseToAverage.size());

        for(IndicatorData indicatorData : indicatorDataCloseToAverage){
            Assert.assertTrue(isDistanceBetweenValuesValid(indicatorData.getPorcentualVariation(), averageVariation, allowedGap));
        }

        allowedGap = 21f;
        indicatorDataCloseToAverage = BasicAnalyst.getIndicatorDataWithVariationCloseToAverage(indicatorDataList, allowedGap);
        Assert.assertEquals(2, indicatorDataCloseToAverage.size());

        for(IndicatorData indicatorData : indicatorDataCloseToAverage){
            Assert.assertTrue(isDistanceBetweenValuesValid(indicatorData.getPorcentualVariation(), averageVariation, allowedGap));
        }
    }

    @Test
    public void testGetBestNVariations(){
        ArrayList<IndicatorData> bestVariations;

        bestVariations = BasicAnalyst.getBestNVariations(indicatorDataList, 10);

        Assert.assertEquals(3, bestVariations.size());
        Assert.assertTrue(bestVariations.get(0).getPorcentualVariation() > bestVariations.get(1).getPorcentualVariation());
        Assert.assertTrue(bestVariations.get(1).getPorcentualVariation() > bestVariations.get(2).getPorcentualVariation());

        bestVariations = BasicAnalyst.getBestNVariations(indicatorDataList, 2);

        Assert.assertEquals(2, bestVariations.size());
        Assert.assertTrue(bestVariations.get(0).getPorcentualVariation() > bestVariations.get(1).getPorcentualVariation());
    }

    @Test
    public void testGetWorstNVariations(){
        ArrayList<IndicatorData> worstVariations;

        worstVariations = BasicAnalyst.getWorstNVariations(indicatorDataList, 10);

        Assert.assertEquals(3, worstVariations.size());
        Assert.assertTrue(worstVariations.get(0).getPorcentualVariation() < worstVariations.get(1).getPorcentualVariation());
        Assert.assertTrue(worstVariations.get(1).getPorcentualVariation() < worstVariations.get(2).getPorcentualVariation());

        worstVariations = BasicAnalyst.getWorstNVariations(indicatorDataList, 2);

        Assert.assertEquals(2, worstVariations.size());
        Assert.assertTrue(worstVariations.get(0).getPorcentualVariation() < worstVariations.get(1).getPorcentualVariation());
    }

    private boolean isDistanceBetweenValuesValid(Float value1, Float value2, Float allowedGap){
        Float distance = Math.abs(value1 - value2);
        return distance <= allowedGap;
    }
}
