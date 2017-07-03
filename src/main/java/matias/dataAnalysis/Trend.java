package matias.dataAnalysis;

import java.util.ArrayList;

/**
 * Created by matias on 11/06/17.
 */
public class Trend {
    public enum TYPE {
        ASCENDING_STRONG("ASCENDING_STRONG"),
        ASCENDING_OSCILATING("ASCENDING_OSCILATING"),
        ASCENDING_FLAT("ASCENDING_FLAT"),
        DESCENDING_STRONG("DESCENDING_STRONG"),
        DESCENDING_OSCILATING("DESCENDING_OSCILATING"),
        DESCENDING_FLAT("DESCENDING_FLAT"),
        FLAT("FLAT");

        private String name;

        TYPE(String name){
            this.name = name;
        }
    }

    private ArrayList<IndicatorData> indicatorDataList;

    private Float averageVariation;
    private Float sumOfVariations;
    private Float sumOfPositiveVariations;
    private Float sumOfNegativeVariations;
    private Float sumOfExceptionalVariations;

    private IndicatorData maxVariation;
    private IndicatorData minVariation;
    private IndicatorData minOpening;
    private IndicatorData maxClosing;

    private TYPE type;

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
}
