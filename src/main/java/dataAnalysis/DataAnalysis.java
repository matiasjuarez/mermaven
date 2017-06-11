package dataAnalysis;

import java.util.ArrayList;

/**
 * Created by matias on 11/06/17.
 */
public class DataAnalysis {
    private ArrayList<IndicatorData> indicatorDataList;

    private Float averageVariation;
    private Float sumOfVariations;
    private Float sumOfPositiveVariations;
    private Float sumOfNegativeVariations;
    private Float sumOfExceptionalVariations;

    private IndicatorData maxVariation;
    private IndicatorData minVariation;
    private IndicatorData maxClosing;
    private IndicatorData minOpening;

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

    public Float getSumOfExceptionalVariations() {
        return sumOfExceptionalVariations;
    }

    public void setSumOfExceptionalVariations(Float sumOfExceptionalVariations) {
        this.sumOfExceptionalVariations = sumOfExceptionalVariations;
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
}
