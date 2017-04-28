/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simulacion.simuladores.ideasViejas;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Matías
 */
public class AnalizadorResultados {
    
    private ArrayList<ResultadoSimulacion> resultados;
    
    public AnalizadorResultados(ArrayList<ResultadoSimulacion> resultados){
        this.resultados = resultados;
    }
    
    public ResultadoSimulacion obtenerMaximo(){
        
        ResultadoSimulacion maximo = resultados.get(0);
        
        for(ResultadoSimulacion resultado : resultados){
            if(maximo.calcularResultadoInversion() < resultado.calcularResultadoInversion()){
                maximo = resultado;
            }
        }
        
        return maximo;
    }
    
    public ResultadoSimulacion obtenerMinimo(){
        ResultadoSimulacion minimo = resultados.get(0);
        
        for(ResultadoSimulacion resultado : resultados) {
            if(minimo.calcularResultadoInversion() > resultado.calcularResultadoInversion()){
                minimo = resultado;
            }
        }
        
        return minimo;
    }
    
    public ArrayList<ResultadoSimulacion> obtenerLosNMejoresResultados(int cantidadResultados){
        
        ArrayList<ResultadoSimulacion> mejoresResultados = new ArrayList<>();
        
        for(ResultadoSimulacion resultado : resultados){
            if(mejoresResultados.size() < cantidadResultados){
                mejoresResultados.add(resultado);
            }
            else{
                ResultadoSimulacion mejorResultado = mejoresResultados.get(cantidadResultados - 1);
                if(resultado.calcularResultadoInversion() > mejorResultado.calcularResultadoInversion()){
                    mejoresResultados.remove(0);
                    mejoresResultados.add(resultado);
                }
            }
            
            Collections.sort(mejoresResultados);
        }
        
        return mejoresResultados;
    }
    
    public ArrayList<ResultadoSimulacion> getResultados(){
        return this.resultados;
    }
}
