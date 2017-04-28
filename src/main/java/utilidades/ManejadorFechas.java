/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilidades;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 *
 * @author Matías
 */
public class ManejadorFechas {
    
    public static Date sumarDiasFecha(Date date, int dias){
        GregorianCalendar gc = new GregorianCalendar();
        gc.setTime(date);
        gc.add(GregorianCalendar.DATE, dias);
        
        return gc.getTime();
    }
    
    public static Date parseDate(String dateFormat, String valueToParse) throws ParseException{
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
        
        return sdf.parse(valueToParse);
    }
}
