package IO.basedatos.estructura.baseDatos;

import IO.basedatos.Conexion;
import IO.basedatos.estructura.tablas.Tabla;
import configuracion.Configuracion;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by Matías on 30/04/2017.
 */
public abstract class BaseDeDatos {
    private String nombreDB;
    protected ArrayList<Tabla> tablas;

    public BaseDeDatos(String nombreDB){
        tablas = new ArrayList<>();
        this.nombreDB = nombreDB;

        agregarTablas();
    }

    public String getNombreDB() {
        return nombreDB;
    }

    protected void agregarTabla(Tabla tabla){
        tablas.add(tabla);
    }

    public void crear() throws SQLException{
        String urlBD = Configuracion.getInstance().getPathBaseDatos() + nombreDB;

        Conexion conexion = new Conexion(urlBD);
        Connection connection = conexion.conectar(true);

        for(Tabla tabla : tablas){
            tabla.crear(nombreDB, connection);
        }
    }



    protected abstract void agregarTablas();
}
