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
public class ExcepcionLimiteDeposito extends Exception{
    
    public ExcepcionLimiteDeposito(String mensaje){
        super(mensaje);
    }
    
    public ExcepcionLimiteDeposito(){
        this("Error al intentar depositar");
    }
}
