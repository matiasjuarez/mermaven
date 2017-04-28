/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conceptos.excepciones;

/**
 *
 * @author Matías
 */
public class ExcepcionFondosInsuficientes extends Exception{
    
    public ExcepcionFondosInsuficientes(String mensaje){
        super(mensaje);
    }
    
    public ExcepcionFondosInsuficientes(){
        this("No se puede realizar la operacion porque no hay suficientes fondos");
    }
}
