package analisisEvolucion;

import java.util.Date;

/**
 * Created by Matías on 27/04/2017.
 */
public class PosicionMerval {
    private Date fecha;
    private float apertura;
    private float cierre;
    private float maximo;
    private float minimo;
    private float variacionPorcentual;

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public float getApertura() {
        return apertura;
    }

    public void setApertura(float apertura) {
        this.apertura = apertura;
    }

    public float getCierre() {
        return cierre;
    }

    public void setCierre(float cierre) {
        this.cierre = cierre;
    }

    public float getMaximo() {
        return maximo;
    }

    public void setMaximo(float maximo) {
        this.maximo = maximo;
    }

    public float getMinimo() {
        return minimo;
    }

    public void setMinimo(float minimo) {
        this.minimo = minimo;
    }

    public float getVariacionPorcentual() {
        return variacionPorcentual;
    }

    public void setVariacionPorcentual(float variacionPorcentual) {
        this.variacionPorcentual = variacionPorcentual;
    }

    public String toString(){
        String str = getFecha() + ". Ap: " + getApertura();
        str += ". Ci: " + getCierre() + ". Var: " + getVariacionPorcentual();
        str += ". Max: " + getMaximo() + ". Min: " + getMinimo();

        return str;
    }
}
