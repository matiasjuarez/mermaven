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
public class DateHandler {
    
    public static Date addDays(Date date, int days){
        GregorianCalendar gc = new GregorianCalendar();
        gc.setTime(date);
        gc.add(GregorianCalendar.DATE, days);
        
        return gc.getTime();
    }
    
    public static Date parseDate(String dateFormat, String valueToParse) throws ParseException{
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
        
        return sdf.parse(valueToParse);
    }
}
