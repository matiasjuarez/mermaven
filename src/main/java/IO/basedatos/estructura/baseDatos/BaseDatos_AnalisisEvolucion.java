package IO.basedatos.estructura.baseDatos;

import IO.basedatos.Conexion;
import IO.basedatos.estructura.tablas.Tabla;
import IO.basedatos.estructura.tablas.TablaPosicionMerval;
import configuracion.Configuracion;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by Matías on 30/04/2017.
 */
public class BaseDatos_AnalisisEvolucion extends BaseDeDatos{

    public BaseDatos_AnalisisEvolucion(){
        super("ANALISIS_EVOLUCION");
    }

    @Override
    public void agregarTablas() {
        agregarTabla(new TablaPosicionMerval());
    }
}
