/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IO;

import conceptos.fondos.VariacionFondo;
import utilidades.LectorArchivos;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Matías
 */
public class VariacionFondoDAO {
    
    public static ArrayList<VariacionFondo> leerValoresHistoricosVariacion(String URL){
        ArrayList<VariacionFondo> variaciones = new ArrayList<>();
        ArrayList<String> lineasLeidas = LectorArchivos.leerLineaPorLinea(URL);
        
        for(String linea : lineasLeidas){
            float valorHistorico = Float.parseFloat(linea);
            variaciones.add(new VariacionFondo(new Date(), valorHistorico));
        }
        
        return variaciones;
    }
    
    public static ArrayList<VariacionFondo> leerValoresHistoricosFechaVariacion(String URL){
        ArrayList<VariacionFondo> variaciones = new ArrayList<>();
        ArrayList<String> lineasLeidas = LectorArchivos.leerLineaPorLinea(URL);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");
        
        for(String linea : lineasLeidas){
            String[] valores = linea.split(",");
            
            try {
                Date date = sdf.parse(valores[0]);
                float valorHistorico = Float.parseFloat(linea);
                variaciones.add(new VariacionFondo(date, valorHistorico));
            } catch (ParseException ex) {
                Logger.getLogger(VariacionFondoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return variaciones;
    }
}
