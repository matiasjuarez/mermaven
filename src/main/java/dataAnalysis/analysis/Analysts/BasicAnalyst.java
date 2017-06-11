package dataAnalysis.analysis.Analysts;

import dataAnalysis.IndicatorData;
import dataAnalysis.dataTools.Filter;
import utilidades.collections.CollectionFilterUtility;


import java.util.ArrayList;

/**
 * Created by matias on 09/06/17.
 */
public class BasicAnalyst {

    public static IndicatorData getBestVariation(ArrayList<IndicatorData> indicatorDataList) {
        return getBestNVariations(indicatorDataList, 1).get(0);
    }

    /**
     * Looks for the best N variations in the data of indicatorDataList
     *
     * @param indicatorDataList - The data we want to analyze
     * @param amount            - How many variations we want
     * @return the best N variations in descending order
     */
    public static ArrayList<IndicatorData> getBestNVariations(ArrayList<IndicatorData> indicatorDataList, int amount) {
        ArrayList<IndicatorData> variations = new ArrayList<>();

        for (IndicatorData indicatorData : indicatorDataList) {

            boolean indicatorInserted = false;

            for (int i = 0; i < variations.size(); i++) {
                if (indicatorData.getPorcentualVariation() > variations.get(i).getPorcentualVariation()) {

                    if (variations.size() >= amount) {
                        variations.remove(amount - 1);
                    }

                    variations.add(i, indicatorData);
                    indicatorInserted = true;
                    break;
                }
            }

            if (!indicatorInserted) {
                if (variations.size() < amount) {
                    variations.add(indicatorData);
                }
            }
        }

        return variations;
    }

    public static IndicatorData getWorstVariation(ArrayList<IndicatorData> indicatorDataList) {
        return getWorstNVariations(indicatorDataList, 1).get(0);
    }

    /**
     * Looks for the worst N variations in the data of indicatorDataList
     *
     * @param amount - How many variations we want
     * @return the worst N variations in ascending order
     */
    public static ArrayList<IndicatorData> getWorstNVariations(ArrayList<IndicatorData> indicatorDataList, int amount) {
        ArrayList<IndicatorData> variations = new ArrayList<>();

        for (IndicatorData indicatorData : indicatorDataList) {

            boolean indicatorInserted = false;

            for (int i = 0; i < variations.size(); i++) {

                if (indicatorData.getPorcentualVariation() < variations.get(i).getPorcentualVariation()) {
                    if (variations.size() >= amount) {
                        variations.remove(amount - 1);
                    }

                    variations.add(i, indicatorData);
                    indicatorInserted = true;
                    break;
                }
            }

            if (!indicatorInserted) {
                if (variations.size() < amount) {
                    variations.add(indicatorData);
                }
            }
        }

        return variations;
    }

    /**
     * Searches for the IndicatorData object with the minimal variation. It doesn't matter if the variation is positive or negative
     *
     * @param indicatorDataList - the data to analyze
     * @return the indicatorData object with the minimal variation
     */
    public static IndicatorData getMinVariation(ArrayList<IndicatorData> indicatorDataList) {
        return CollectionFilterUtility.getObjectFromCollection(indicatorDataList, (comparisonObject, nextObject) -> Math.abs(nextObject.getPorcentualVariation()) <
                Math.abs(comparisonObject.getPorcentualVariation()), true);
    }

    /**
     * Searches for the IndicatorData object with the maximal variation. It doesn't matter if the variation is positive or negative
     *
     * @param indicatorDataList - the data to analyze
     * @return the indicatorData object with the maximal variation
     */
    public static IndicatorData getMaxVariation(ArrayList<IndicatorData> indicatorDataList) {
        return CollectionFilterUtility.getObjectFromCollection(indicatorDataList, (comparisonObject, nextObject) -> Math.abs(nextObject.getPorcentualVariation()) >
                Math.abs(comparisonObject.getPorcentualVariation()), true);
    }

    public static IndicatorData getMinOpening(ArrayList<IndicatorData> indicatorDataList) {
        return CollectionFilterUtility.getObjectFromCollection(indicatorDataList, (comparisonObject, nextObject) -> Math.abs(nextObject.getOpening()) <
                Math.abs(comparisonObject.getOpening()), true);
    }

    public static IndicatorData getMaxClosing(ArrayList<IndicatorData> indicatorDataList) {
        return CollectionFilterUtility.getObjectFromCollection(indicatorDataList, (comparisonObject, nextObject) -> Math.abs(nextObject.getClosing()) > Math.abs(comparisonObject.getClosing()), true);
    }

    public static Float getAverageVariation(ArrayList<IndicatorData> indicatorDataList) {
        Float accumulator = getSumOfVariations(indicatorDataList);
        Float averageVariation = accumulator / indicatorDataList.size();

        return averageVariation;
    }

    public static Float getSumOfVariations(ArrayList<IndicatorData> indicatorDataList) {
        Float accumulator = 0f;

        for (IndicatorData indicatorData : indicatorDataList) {
            accumulator += indicatorData.getPorcentualVariation();
        }

        return accumulator;
    }

    public static Float getSumOfPositiveVariations(ArrayList<IndicatorData> indicatorDataList) {
        ArrayList<IndicatorData> filteredList = Filter.getIndicatorsWithPositiveVariation(indicatorDataList);
        return getSumOfVariations(filteredList);
    }

    public static Float getSumOfNegativeVariations(ArrayList<IndicatorData> indicatorDataList) {
        ArrayList<IndicatorData> filteredList = Filter.getIndicatorsWithNegativeVariation(indicatorDataList);
        return getSumOfVariations(filteredList);
    }

    public static ArrayList<IndicatorData> getIndicatorDataWithVariationAboveAverage(ArrayList<IndicatorData> indicatorDataList) {
        float average = getAverageVariation(indicatorDataList);

        return CollectionFilterUtility.getFilteredCollection(indicatorDataList, myObject -> myObject.getPorcentualVariation() > average);
    }

    public static ArrayList<IndicatorData> getIndicatorDataWithVariationBelowAverage(ArrayList<IndicatorData> indicatorDataList) {
        float average = getAverageVariation(indicatorDataList);

        return CollectionFilterUtility.getFilteredCollection(indicatorDataList, myObject -> myObject.getPorcentualVariation() < average);
    }

    /**
     * Gets all the indicatorData objects whose variation is close to the average variation. How far
     * the indicatorData object can be is determined by the allowedGap parameter.
     *
     * @param allowedGap - How far the variation of the indicator data object can be from the average variation
     * @return an arrayList of indicatorData objects that fulfill the requirement expressed in the description
     */
    public static ArrayList<IndicatorData> getIndicatorDataWithVariationCloseToAverage(ArrayList<IndicatorData> indicatorDataList, float allowedGap) {
        float average = getAverageVariation(indicatorDataList);

        return CollectionFilterUtility.getFilteredCollection(indicatorDataList, myObject -> {
            float distanceWithAverage = Math.abs(myObject.getPorcentualVariation() - average);
            return distanceWithAverage <= allowedGap;
        });
    }
}