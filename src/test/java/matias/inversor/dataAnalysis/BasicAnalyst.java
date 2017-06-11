package matias.inversor.dataAnalysis;

import dataAnalysis.IndicatorData;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

/**
 * Created by matias on 10/06/17.
 */
public class BasicAnalyst {
    private static dataAnalysis.Analists.BasicAnalyst basicAnalyst;

    @Before
    public void setup(){
        basicAnalyst = new dataAnalysis.Analists.BasicAnalyst(DataSetupHelper.getIndicatorDataForTest());
    }

    @Test
    public void testBestVariation(){
        IndicatorData indicatorData = basicAnalyst.getBestVariation();
        Float porcentualVariation = indicatorData.getPorcentualVariation();

        Assert.assertEquals(26.66, porcentualVariation, 0.1);
    }

    @Test
    public void testWorstVariation(){
        IndicatorData indicatorData = basicAnalyst.getWorstVariation();
        Float porcentualVariation = indicatorData.getPorcentualVariation();

        Assert.assertEquals(-20, porcentualVariation, 0.1);
    }

    @Test
    public void testAverageVariation(){
        Float averageVariation = basicAnalyst.getAverageVariation();

        Assert.assertEquals(6.22, averageVariation, 0.1);
    }

    @Test
    public void testGetIndicatorsVariationAboveAverage(){
        Float averageVariation = basicAnalyst.getAverageVariation();
        ArrayList<IndicatorData> indicatorDataList = basicAnalyst.getIndicatorDataWithVariationAboveAverage();

        Assert.assertEquals(2, indicatorDataList.size());

        for(IndicatorData indicatorData : indicatorDataList){
            Assert.assertTrue(indicatorData.getPorcentualVariation() > averageVariation);
        }
    }

    @Test
    public void testGetIndicatorsVariationBelowAverage(){
        Float averageVariation = basicAnalyst.getAverageVariation();
        ArrayList<IndicatorData> indicatorDataList = basicAnalyst.getIndicatorDataWithVariationBelowAverage();

        Assert.assertEquals(1, indicatorDataList.size());

        for(IndicatorData indicatorData : indicatorDataList){
            Assert.assertTrue(indicatorData.getPorcentualVariation() < averageVariation);
        }
    }

    @Test
    public void testGetIndicatorsVariationCloseToAverage(){
        Float averageVariation = basicAnalyst.getAverageVariation();

        Float allowedGap = 10f;
        ArrayList<IndicatorData> indicatorDataList = basicAnalyst.getIndicatorDataWithVariationCloseToAverage(allowedGap);
        Assert.assertEquals(1, indicatorDataList.size());

        for(IndicatorData indicatorData : indicatorDataList){
            Assert.assertTrue(isDistanceBetweenValuesValid(indicatorData.getPorcentualVariation(), averageVariation, allowedGap));
        }

        allowedGap = 30f;
        indicatorDataList = basicAnalyst.getIndicatorDataWithVariationCloseToAverage(allowedGap);
        Assert.assertEquals(3, indicatorDataList.size());

        for(IndicatorData indicatorData : indicatorDataList){
            Assert.assertTrue(isDistanceBetweenValuesValid(indicatorData.getPorcentualVariation(), averageVariation, allowedGap));
        }

        allowedGap = 21f;
        indicatorDataList = basicAnalyst.getIndicatorDataWithVariationCloseToAverage(allowedGap);
        Assert.assertEquals(2, indicatorDataList.size());

        for(IndicatorData indicatorData : indicatorDataList){
            Assert.assertTrue(isDistanceBetweenValuesValid(indicatorData.getPorcentualVariation(), averageVariation, allowedGap));
        }
    }

    @Test
    public void testGetBestNVariations(){
        ArrayList<IndicatorData> bestVariations;

        bestVariations = basicAnalyst.getBestNVariations(10);

        Assert.assertEquals(3, bestVariations.size());
        Assert.assertTrue(bestVariations.get(0).getPorcentualVariation() > bestVariations.get(1).getPorcentualVariation());
        Assert.assertTrue(bestVariations.get(1).getPorcentualVariation() > bestVariations.get(2).getPorcentualVariation());

        bestVariations = basicAnalyst.getBestNVariations(2);

        Assert.assertEquals(2, bestVariations.size());
        Assert.assertTrue(bestVariations.get(0).getPorcentualVariation() > bestVariations.get(1).getPorcentualVariation());
    }

    @Test
    public void testGetWorstNVariations(){
        ArrayList<IndicatorData> worstVariations;

        worstVariations = basicAnalyst.getWorstNVariations(10);

        Assert.assertEquals(3, worstVariations.size());
        Assert.assertTrue(worstVariations.get(0).getPorcentualVariation() < worstVariations.get(1).getPorcentualVariation());
        Assert.assertTrue(worstVariations.get(1).getPorcentualVariation() < worstVariations.get(2).getPorcentualVariation());

        worstVariations = basicAnalyst.getWorstNVariations(2);

        Assert.assertEquals(2, worstVariations.size());
        Assert.assertTrue(worstVariations.get(0).getPorcentualVariation() < worstVariations.get(1).getPorcentualVariation());
    }

    private boolean isDistanceBetweenValuesValid(Float value1, Float value2, Float allowedGap){
        Float distance = Math.abs(value1 - value2);
        return distance <= allowedGap;
    }
}
