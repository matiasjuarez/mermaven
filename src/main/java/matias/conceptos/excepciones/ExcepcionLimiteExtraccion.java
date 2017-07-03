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
public class ExcepcionLimiteExtraccion extends Exception{
    
    public ExcepcionLimiteExtraccion(String mensaje){
        super(mensaje);
    }
    
    public ExcepcionLimiteExtraccion(){
        this("Error al intentar extraer fondos");
    }
}
