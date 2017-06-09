package dataAnalysis;

import java.util.Date;

/**
 * Created by Matías on 27/04/2017.
 */
public class Indicator {
    private Date date;
    private float opening;
    private float closing;
    private float maximum;
    private float minimum;
    private float variation;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public float getOpening() {
        return opening;
    }

    public void setOpening(float opening) {
        this.opening = opening;
    }

    public float getClosing() {
        return closing;
    }

    public void setClosing(float closing) {
        this.closing = closing;
    }

    public float getMaximum() {
        return maximum;
    }

    public void setMaximum(float maximum) {
        this.maximum = maximum;
    }

    public float getMinimum() {
        return minimum;
    }

    public void setMinimum(float minimum) {
        this.minimum = minimum;
    }

    public float getVariation() {
        return variation;
    }

    public void setVariation(float variation) {
        this.variation = variation;
    }

    @Override
    public String toString(){
        String str = getDate() + ". Opening: " + getOpening();
        str += ". Closing: " + getClosing() + ". Var: " + getVariation();
        str += ". Max: " + getMaximum() + ". Min: " + getMinimum();

        return str;
    }
}
