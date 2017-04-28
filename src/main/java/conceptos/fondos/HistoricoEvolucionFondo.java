/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conceptos.fondos;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;

/**
 * Representa como ha ido evolucionando un fondo a lo largo del tiempo.
 * @author Matías
 */
public class HistoricoEvolucionFondo {
    private HashSet<VariacionFondo> variaciones;
    
    public HistoricoEvolucionFondo(){
        this.variaciones = new HashSet<>();
    }
    
    public void agregarVariacion(VariacionFondo nuevaVariacion){
        variaciones.add(nuevaVariacion);
    }
    
    public void agregarVariacion(Date fecha, float varicionPorcentual){
        VariacionFondo nuevaVariacion = new VariacionFondo(fecha, varicionPorcentual);
        agregarVariacion(nuevaVariacion);
    }
    
    public ArrayList<VariacionFondo> getVariaciones(){
        Iterator<VariacionFondo> iterator = variaciones.iterator();
        ArrayList<VariacionFondo> listaVariaciones = new ArrayList<>();
        
        while(iterator.hasNext()){
            listaVariaciones.add(iterator.next());
        }

        return listaVariaciones;
    }

    public ArrayList<VariacionFondo> getVariacionesOrdenasPorFecha(){
        return getVariaciones();
    }
}
