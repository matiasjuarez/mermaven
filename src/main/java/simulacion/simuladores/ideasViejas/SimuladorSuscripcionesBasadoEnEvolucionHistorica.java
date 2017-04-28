/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simulacion.simuladores.ideasViejas;

import conceptos.fondos.VariacionFondo;

import java.util.ArrayList;

/**
 *
 * @author Matías
 */
public class SimuladorSuscripcionesBasadoEnEvolucionHistorica {
    
    private ArrayList<VariacionFondo> variaciones;
    private float capitalInicial;
    private int diasDeEspera;
    
    // Variables de simulacion que cambian
    private float capitalDisponible;
    private float capitalInvertido;
    private float inversionMinima;
    private int diasQueFaltanPorEsperar;
    private boolean capitalDisponibleAgotado;
    
    public SimuladorSuscripcionesBasadoEnEvolucionHistorica(ArrayList<VariacionFondo> variaciones, 
            float capitalInicial){
        this(variaciones, capitalInicial, 0);
    }
    
    public SimuladorSuscripcionesBasadoEnEvolucionHistorica(ArrayList<VariacionFondo> variaciones, 
            float capitalInicial, float inversionMinima){

        this(variaciones, capitalInicial, inversionMinima, 0);
    }
    
    private SimuladorSuscripcionesBasadoEnEvolucionHistorica(ArrayList<VariacionFondo> variaciones, 
            float capitalInicial, float inversionMinima, int diasDeEspera){
        
        this.variaciones = variaciones;
        this.capitalInicial = capitalInicial;
        this.inversionMinima = inversionMinima;
        this.diasDeEspera = diasDeEspera;
    }
        
    public ResultadoSimulacion simularConPorcentajeDeSuscripcionConstante(float porcentaje){
        this.inicializarVariablesDeSimulacion();
        
        for(VariacionFondo variacion : variaciones){
            invertirPorcentajeCapitalDisponible(porcentaje);
            capitalInvertido += capitalInvertido * variacion.getVariacion() / 100;
        }
        
        ResultadoSimulacion resultado = new ResultadoSimulacion();
        resultado.setCantidadDias(variaciones.size());
        resultado.setCapitalDisponible(capitalDisponible);
        resultado.setCapitalInicial(capitalInicial);
        resultado.setCapitalInvertido(capitalInvertido);
        resultado.setPorcentajeDeInversionConstante(porcentaje);
        
        return resultado;
    }
    
    public ArrayList<ResultadoSimulacion> simularConPorcentajeDeSuscripcionConstante(float porcentajeMinimo, 
            float porcentajeMaximo, float paso){
        
        ArrayList<ResultadoSimulacion> resultados = new ArrayList<>();
        
        float porcentajeActual = porcentajeMinimo;
        
        while(porcentajeActual < porcentajeMaximo){
            resultados.add(simularConPorcentajeDeSuscripcionConstante(porcentajeActual));
            porcentajeActual += paso;
        }
        
        return resultados;
    }
    
    public ArrayList<ResultadoSimulacion> simularConPorcentajeRespectoAlCapitalInvertidoYSalidaFinal(float porcentajeInicial, 
            float porcentajeRespectoAlCapitalInvertido){
        
        this.inicializarVariablesDeSimulacion();
        
        invertirPorcentajeCapitalDisponible(porcentajeInicial);
        
        for(VariacionFondo variacion : variaciones){
            
            capitalInvertido += capitalInvertido * variacion.getVariacion() / 100;
            invertirPorcentajeCapitalInvertido(porcentajeRespectoAlCapitalInvertido);
        }

        return null;
    }
    
    private void invertirPorcentajeCapitalInvertido(float porcentaje){
        float inversion = capitalInvertido * porcentaje / 100;
        invertirCantidadDeCapitalDisponible(inversion);
    }
    
    private void invertirPorcentajeCapitalDisponible(float porcentaje){
        float inversion = capitalDisponible * porcentaje / 100;
        invertirCantidadDeCapitalDisponible(inversion);
    }
    
    private void invertirCantidadDeCapitalDisponible(float inversion){
        
        if(capitalDisponible >= inversionMinima){
            if(inversion < inversionMinima){
                inversion = inversionMinima;
            }
            else if(inversion > capitalDisponible){
                inversion = capitalDisponible;
            }
        } else{
            inversion = 0;
            this.capitalDisponibleAgotado = true;
        }
        
        capitalInvertido += inversion;
        capitalDisponible -= inversion;
    }
    
    private void inicializarVariablesDeSimulacion(){
        this.capitalDisponible = this.capitalInicial;
        this.capitalDisponibleAgotado = false;
        this.capitalInvertido = 0;
        this.diasQueFaltanPorEsperar = 0;
    }
}
