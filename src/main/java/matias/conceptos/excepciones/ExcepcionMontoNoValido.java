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
public class ExcepcionMontoNoValido extends Exception{
    
    public ExcepcionMontoNoValido(String mensaje){
        super(mensaje);
    }
    
    public ExcepcionMontoNoValido(){
        this("El monto ingresado para la operacion no es valido");
    }
}
