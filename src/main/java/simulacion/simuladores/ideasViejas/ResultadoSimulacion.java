/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simulacion.simuladores.ideasViejas;

/**
 *
 * @author Matías
 */
public class ResultadoSimulacion implements Comparable{
    private float capitalInicial;
    private float capitalInvertido;
    private float capitalDisponible;
    private int cantidadDias;
    private float porcentajeDeInversionConstante;

    public float getCapitalInicial() {
        return capitalInicial;
    }

    public void setCapitalInicial(float capitalInicial) {
        this.capitalInicial = capitalInicial;
    }

    public float getCapitalInvertido() {
        return capitalInvertido;
    }

    public void setCapitalInvertido(float capitalInvertido) {
        this.capitalInvertido = capitalInvertido;
    }

    public float getCapitalDisponible() {
        return capitalDisponible;
    }

    public void setCapitalDisponible(float capitalDisponible) {
        this.capitalDisponible = capitalDisponible;
    }

    public int getCantidadDias() {
        return cantidadDias;
    }

    public void setCantidadDias(int cantidadDias) {
        this.cantidadDias = cantidadDias;
    }
    
    public float calcularResultadoInversion(){
        return (capitalDisponible + capitalInvertido) - capitalInicial;
    }
    
    public float calcularVariacionPorcentualDeCapital(){        
        float resultadoNumerico = capitalInvertido + capitalDisponible - capitalInicial;
                
        return (resultadoNumerico / capitalInicial);
    }

    public float getPorcentajeDeInversionConstante() {
        return porcentajeDeInversionConstante;
    }

    public void setPorcentajeDeInversionConstante(float porcentajeDeInversionConstante) {
        this.porcentajeDeInversionConstante = porcentajeDeInversionConstante;
    }
    
    @Override
    public int compareTo(Object o) {
        
        float otroResultado = ((ResultadoSimulacion)o).calcularResultadoInversion();
        float esteResultado = this.calcularResultadoInversion();
        
        return Math.round(esteResultado - otroResultado);
    }
}
