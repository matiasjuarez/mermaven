package dataAnalysis.analysis;

import dataAnalysis.IndicatorData;

import java.util.ArrayList;

/**
 * Created by matias on 11/06/17.
 */
public class BasicAnalystData {
    private ArrayList<IndicatorData> indicatorDataList;

    private Float averageVariation;
    private Float sumOfVariations;
    private Float sumOfPositiveVariations;
    private Float sumOfNegativeVariations;

    private IndicatorData maxVariation;
    private IndicatorData minVariation;
    private IndicatorData maxClosing;
    private IndicatorData minOpening;

    private IndicatorData bestVariation;
    private IndicatorData worstVariation;

    private ArrayList<IndicatorData> bestVariations;
    private ArrayList<IndicatorData> worstVariations;

    private ArrayList<IndicatorData> variationsAboveAverage;
    private ArrayList<IndicatorData> variationsBelowAverage;
    private ArrayList<IndicatorData> variationsCloseToAverage;

    public ArrayList<IndicatorData> getIndicatorDataList() {
        return indicatorDataList;
    }

    public void setIndicatorDataList(ArrayList<IndicatorData> indicatorDataList) {
        this.indicatorDataList = indicatorDataList;
    }

    public Float getAverageVariation() {
        return averageVariation;
    }

    public void setAverageVariation(Float averageVariation) {
        this.averageVariation = averageVariation;
    }

    public Float getSumOfVariations() {
        return sumOfVariations;
    }

    public void setSumOfVariations(Float sumOfVariations) {
        this.sumOfVariations = sumOfVariations;
    }

    public Float getSumOfPositiveVariations() {
        return sumOfPositiveVariations;
    }

    public void setSumOfPositiveVariations(Float sumOfPositiveVariations) {
        this.sumOfPositiveVariations = sumOfPositiveVariations;
    }

    public Float getSumOfNegativeVariations() {
        return sumOfNegativeVariations;
    }

    public void setSumOfNegativeVariations(Float sumOfNegativeVariations) {
        this.sumOfNegativeVariations = sumOfNegativeVariations;
    }

    public IndicatorData getMaxVariation() {
        return maxVariation;
    }

    public void setMaxVariation(IndicatorData maxVariation) {
        this.maxVariation = maxVariation;
    }

    public IndicatorData getMinVariation() {
        return minVariation;
    }

    public void setMinVariation(IndicatorData minVariation) {
        this.minVariation = minVariation;
    }

    public IndicatorData getMinOpening() {
        return minOpening;
    }

    public void setMinOpening(IndicatorData minOpening) {
        this.minOpening = minOpening;
    }

    public IndicatorData getMaxClosing() {
        return maxClosing;
    }

    public void setMaxClosing(IndicatorData maxClosing) {
        this.maxClosing = maxClosing;
    }

    public IndicatorData getBestVariation() {
        return bestVariation;
    }

    public void setBestVariation(IndicatorData bestVariation) {
        this.bestVariation = bestVariation;
    }

    public IndicatorData getWorstVariation() {
        return worstVariation;
    }

    public void setWorstVariation(IndicatorData worstVariation) {
        this.worstVariation = worstVariation;
    }

    public ArrayList<IndicatorData> getBestVariations() {
        return bestVariations;
    }

    public void setBestVariations(ArrayList<IndicatorData> bestVariations) {
        this.bestVariations = bestVariations;
    }

    public ArrayList<IndicatorData> getWorstVariations() {
        return worstVariations;
    }

    public void setWorstVariations(ArrayList<IndicatorData> worstVariations) {
        this.worstVariations = worstVariations;
    }

    public ArrayList<IndicatorData> getVariationsAboveAverage() {
        return variationsAboveAverage;
    }

    public void setVariationsAboveAverage(ArrayList<IndicatorData> variationsAboveAverage) {
        this.variationsAboveAverage = variationsAboveAverage;
    }

    public ArrayList<IndicatorData> getVariationsBelowAverage() {
        return variationsBelowAverage;
    }

    public void setVariationsBelowAverage(ArrayList<IndicatorData> variationsBelowAverage) {
        this.variationsBelowAverage = variationsBelowAverage;
    }

    public ArrayList<IndicatorData> getVariationsCloseToAverage() {
        return variationsCloseToAverage;
    }

    public void setVariationsCloseToAverage(ArrayList<IndicatorData> variationsCloseToAverage) {
        this.variationsCloseToAverage = variationsCloseToAverage;
    }
}
