package dataAnalysis.Analists;

import dataAnalysis.IndicatorData;


import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by matias on 09/06/17.
 */
public class BasicAnalyst extends Analyst {
    private Float averageVariation;

    public BasicAnalyst(ArrayList<IndicatorData> indicatorDataList){
        super(indicatorDataList);
    }

    public IndicatorData getBestVariation(){
        return getBestNVariations(1).get(0);
    }

    /**
     * Looks for the best N variations in the data of indicatorDataList
     * @param amount - How many variations we want
     * @return the best N variations in descending order
     */
    public ArrayList<IndicatorData> getBestNVariations(int amount){
        ArrayList<IndicatorData> variations = new ArrayList<>();

        for(IndicatorData indicatorData : this.indicatorDataList){

            boolean indicatorInserted = false;

            for(int i = 0; i < variations.size(); i++){
                if(indicatorData.getPorcentualVariation() > variations.get(i).getPorcentualVariation()){

                    if(variations.size() >= amount) {
                        variations.remove(amount - 1);
                    }

                    variations.add(i, indicatorData);
                    indicatorInserted = true;
                    break;
                }
            }

            if(!indicatorInserted){
                if(variations.size() < amount){
                    variations.add(indicatorData);
                }
            }
        }

        return variations;
    }

    public IndicatorData getWorstVariation(){
        return getWorstNVariations(1).get(0);
    }

    /**
     * Looks for the worst N variations in the data of indicatorDataList
     * @param amount - How many variations we want
     * @return the worst N variations in ascending order
     */
    public ArrayList<IndicatorData> getWorstNVariations(int amount){
        ArrayList<IndicatorData> variations = new ArrayList<>();

        for(IndicatorData indicatorData : this.indicatorDataList){

            boolean indicatorInserted = false;

            for(int i = 0; i < variations.size(); i++){

                if(indicatorData.getPorcentualVariation() < variations.get(i).getPorcentualVariation()){
                    if(variations.size() >= amount) {
                        variations.remove(amount - 1);
                    }

                    variations.add(i, indicatorData);
                    indicatorInserted = true;
                    break;
                }
            }

            if(!indicatorInserted){
                if(variations.size() < amount){
                    variations.add(indicatorData);
                }
            }
        }

        return variations;
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
