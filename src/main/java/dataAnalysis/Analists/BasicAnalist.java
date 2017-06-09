package dataAnalysis.Analists;

import dataAnalysis.IndicatorData;

import java.util.ArrayList;

/**
 * Created by matias on 09/06/17.
 */
public class BasicAnalist extends Analist{
    private Float averageVariation;

    public BasicAnalist(ArrayList<IndicatorData> indicatorDataList){
        super(indicatorDataList);
    }

    public IndicatorData getMaximumPositiveVariation(){
        IndicatorData maximumPositiveVariation = indicatorDataList.get(0);

        for(IndicatorData indicatorData : this.indicatorDataList){
            if(indicatorData.getPorcentualVariation() > maximumPositiveVariation.getPorcentualVariation()){
                maximumPositiveVariation = indicatorData;
            }
        }

        return maximumPositiveVariation;
    }

    public IndicatorData getMaximumNegativeVariation(){
        IndicatorData maximumNegativeVariation = indicatorDataList.get(0);

        for(IndicatorData indicatorData : this.indicatorDataList){
            if(indicatorData.getPorcentualVariation() < maximumNegativeVariation.getPorcentualVariation()){
                maximumNegativeVariation = indicatorData;
            }
        }

        return maximumNegativeVariation;
    }

    public Float getAverageVariation(){
        if(this.averageVariation == null){
            float acumulator = 0;

            for(IndicatorData indicatorData : indicatorDataList){
                Float porcentualVariation = indicatorData.getPorcentualVariation();

                if(porcentualVariation != null){
                    acumulator += porcentualVariation;
                }
            }

            this.averageVariation = acumulator / indicatorDataList.size();
        }

        return this.averageVariation;
    }

    public ArrayList<IndicatorData> getIndicatorDataWithVariationAboveAverage(){
        float average = getAverageVariation();

        ArrayList<IndicatorData> indicatorDataListRequired = new ArrayList<>();

        for(IndicatorData indicatorData : this.indicatorDataList){
            if(indicatorData.getPorcentualVariation() > average){
                indicatorDataListRequired.add(indicatorData);
            }
        }

        return indicatorDataListRequired;
    }

    public ArrayList<IndicatorData> getIndicatorDataWithVariationBelowAverage(){
        float average = getAverageVariation();

        ArrayList<IndicatorData> indicatorDataListRequired = new ArrayList<>();

        for(IndicatorData indicatorData : this.indicatorDataList){
            if(indicatorData.getPorcentualVariation() < average){
                indicatorDataListRequired.add(indicatorData);
            }
        }

        return indicatorDataListRequired;
    }

    /**
     * Gets all the indicatorData objects whose variation is close to the average variation. How far
     * the indicatorData object can be is determined by the allowedGap parameter.
     * @param allowedGap - How far the variation of the indicator data object can be from the average variation
     * @return an arrayList of indicatorData objects that fulfill the requirement expressed in the description
     */
    public ArrayList<IndicatorData> getIndicatorDataWithVariationCloseToAverage(float allowedGap){
        float average = getAverageVariation();

        ArrayList<IndicatorData> indicatorDataListRequired = new ArrayList<>();

        for(IndicatorData indicatorData : this.indicatorDataList){
            float distanceWithAverage = Math.abs(indicatorData.getPorcentualVariation() - average);

            if(distanceWithAverage <= allowedGap){
                indicatorDataListRequired.add(indicatorData);
            }
        }

        return indicatorDataListRequired;
    }
}
