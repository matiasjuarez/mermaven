/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matias.utilidades;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Matías
 */
public class LectorArchivos {
    
    public static ArrayList<String> leerLineaPorLinea(String URL){
        
        ArrayList<String> lineas = new ArrayList<>();
        
        try(BufferedReader br = new BufferedReader(new FileReader(URL))){
            String currentLine;
            while((currentLine = br.readLine()) != null){
                lineas.add(currentLine);
            }
        }
        catch(IOException e){
            e.printStackTrace();
        }
        
        return lineas;
    }
}
