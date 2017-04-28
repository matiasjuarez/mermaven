/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simulacion.simuladores.ideasViejas;

import java.util.ArrayList;

/**
 *
 * @author Matías
 */
public class PresentadorResultados {
    
    private AnalizadorResultados analizador;
    
    public void setAnalizadorResultados(AnalizadorResultados analizador){
        this.analizador = analizador;
    }
    
    public void mostrarTodosLosResultadosCompletos(){
        ArrayList<ResultadoSimulacion> resultados = analizador.getResultados();
        for(ResultadoSimulacion resultadoSimulacion : resultados){
            System.out.println(construirInformacionDeResultado(resultadoSimulacion));
        }
    }
    
    public void mostrarMejorYPeor(){
        ResultadoSimulacion mejor = analizador.obtenerMaximo();
        ResultadoSimulacion peor = analizador.obtenerMinimo();
        
        System.out.println(construirInformacionDeResultado(mejor));
        System.out.println(construirInformacionDeResultado(peor));
    }
    
    public void mostrarLosNmejores(int cantidadResultados){
        for(ResultadoSimulacion resultadoSimulacion : analizador.obtenerLosNMejoresResultados(cantidadResultados)){
            System.out.println(construirInformacionDeResultado(resultadoSimulacion));
        }
    }
    
    private String construirInformacionDeResultado(ResultadoSimulacion resultado){
        String str = "Porcentaje: " + resultado.getPorcentajeDeInversionConstante();
        str += ". Monto invertido: " + resultado.getCapitalInvertido();
        str += ". Monto disponible: " + resultado.getCapitalDisponible();
        str += ". Resultado: " + resultado.calcularResultadoInversion();
        str += ". (" + Math.round(resultado.calcularVariacionPorcentualDeCapital() * 10000) / 100.0 + "%)";
        
        return str;
    }
}
