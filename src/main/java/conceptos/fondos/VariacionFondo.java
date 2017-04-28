/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conceptos.fondos;

import java.util.Date;
import java.util.Objects;

/**
 *
 * @author Matías
 */

/**
 * Representa la variacion proporcional de un fondo en una fecha dada.
 * @author Matías
 */

public class VariacionFondo {
    private final Date fecha;
    private final float variacion;
    
    public VariacionFondo(Date fecha, float variacion){
        this.fecha = fecha;
        this.variacion = variacion;
    }
    
    public Date getFecha() {
        return fecha;
    }

    public float getVariacion() {
        return variacion;
    }
    
    @Override
    public int hashCode(){
        return this.fecha.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final VariacionFondo other = (VariacionFondo) obj;
        if (!Objects.equals(this.fecha, other.fecha)) {
            return false;
        }
        return true;
    }
    
    @Override
    public String toString(){
        return Float.toString(getVariacion());
    }
}
