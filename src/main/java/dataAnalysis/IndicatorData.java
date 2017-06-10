package dataAnalysis;

import java.util.Date;

/**
 * Created by Matías on 27/04/2017.
 */
public class IndicatorData {
    private Date date;
    private Float opening;
    private Float closing;
    private Float maximum;
    private Float minimum;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Float getOpening() {
        return opening;
    }

    public void setOpening(Float opening) {
        this.opening = opening;
    }

    public Float getClosing() {
        return closing;
    }

    public void setClosing(Float closing) {
        this.closing = closing;
    }

    public Float getMaximum() {
        return maximum;
    }

    public void setMaximum(Float maximum) {
        this.maximum = maximum;
    }

    public Float getMinimum() {
        return minimum;
    }

    public void setMinimum(Float minimum) {
        this.minimum = minimum;
    }

    public Float getPorcentualVariation() {
        if(closing == null || opening == null){
            return null;
        }

        Float variation = closing - opening;
        Float porcentualVariation = variation * 100 / opening;

        return porcentualVariation;
    }

    @Override
    public String toString(){
        String str = getDate() + ". Opening: " + getOpening();
        str += ". Closing: " + getClosing() + ". Var: " + getPorcentualVariation();
        str += ". Max: " + getMaximum() + ". Min: " + getMinimum();

        return str;
    }
}
