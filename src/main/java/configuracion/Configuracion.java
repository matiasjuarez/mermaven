package configuracion;

/**
 * Created by Matías on 01/05/2017.
 */
public class Configuracion {
    private static Configuracion configuracion;

    private String pathBaseDatos = "./src/main/Datos/bases/";

    private Configuracion(){}

    public static Configuracion getInstance(){
        if(configuracion == null){
            configuracion = new Configuracion();
        }

        return configuracion;
    }

    public String getPathBaseDatos(){
        return pathBaseDatos;
    }
}
