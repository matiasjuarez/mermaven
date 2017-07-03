package matias.utilidades;

import matias.IO.Logger;

/**
 * Created by matias on 28/05/17.
 */
public class NumberHelper {

    public static Float convertToFloat(String numberToConvert){
        String cleanNumber = numberToConvert.replace(".", "");
        cleanNumber = cleanNumber.replace(",", ".");

        try{
            return Float.parseFloat(cleanNumber);
        } catch(NumberFormatException nfe){
            Logger.getInstance().log("Could not convert value to number: " + numberToConvert);
            return null;
        }
    }
}
