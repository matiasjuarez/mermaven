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
public class ExcepcionMonedaIncompatible extends Exception{
    
    public ExcepcionMonedaIncompatible(String mensaje){
        super(mensaje);
    }
    
    public ExcepcionMonedaIncompatible(){
        this("Esta intentando operar con una moneda incorrecta");
    }
}
