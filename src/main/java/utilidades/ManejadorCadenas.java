package utilidades;

import java.util.ArrayList;

/**
 * Created by Matías on 16/04/2017.
 */
public class ManejadorCadenas {

    private ManejadorCadenas(){}

    public static String combinarCadenas(String cadena1, String cadena2, String separador){
        String resultado = cadena1 + separador + cadena2;
        return resultado;
    }

    public static String combinarCadenas(ArrayList<String> cadenas, String separador){
        String resultado = "";
        for(String otraCadena : cadenas){
            resultado = combinarCadenas(resultado, otraCadena, separador);
        }

        return resultado;
    }
}
