/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matias.conceptos.excepciones;

/**
 *
 * @author Matías
 */
public class ExcepcionCuentaNoActiva extends Exception{
    
    public ExcepcionCuentaNoActiva(String mensaje){
        super(mensaje);
    }
    
    public ExcepcionCuentaNoActiva(){
        this("La cuenta en la que intenta operar no se encuentra activa");
    }
}
