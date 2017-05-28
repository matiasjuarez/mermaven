package navigation;

/**
 * Created by matias on 28/05/17.
 */
public class Cotizacion {
    private String fondo;
    private String valor;
    private String variacionDiaria;
    private String variacion30;
    private String variacion90;
    private String variacion365;

    public String getFondo() {
        return fondo;
    }

    public void setFondo(String fondo) {
        this.fondo = fondo;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getVariacionDiaria() {
        return variacionDiaria;
    }

    public void setVariacionDiaria(String variacionDiaria) {
        this.variacionDiaria = variacionDiaria;
    }

    public String getVariacion30() {
        return variacion30;
    }

    public void setVariacion30(String variacion30) {
        this.variacion30 = variacion30;
    }

    public String getVariacion90() {
        return variacion90;
    }

    public void setVariacion90(String variacion90) {
        this.variacion90 = variacion90;
    }

    public String getVariacion365() {
        return variacion365;
    }

    public void setVariacion365(String variacion365) {
        this.variacion365 = variacion365;
    }
}
