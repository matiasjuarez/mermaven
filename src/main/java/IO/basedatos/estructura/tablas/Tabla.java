package IO.basedatos.estructura.tablas;

import IO.basedatos.estructura.campos.Campo;
import IO.basedatos.estructura.campos.CampoAtributosExtra;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Created by Matías on 29/04/2017.
 */
public abstract class Tabla {

    protected String nombre;
    protected ArrayList<Campo> campos;

    public Tabla(String nombre){
        this.nombre = nombre;
        campos = new ArrayList<>();
        agregarCamposTabla();
    }

    public boolean existeTabla(Connection connection){
        return false;
    }

    public void crear(String baseDatos, Connection connection) throws SQLException {
        if(!existeTabla(connection)){
            Statement statement = connection.createStatement();
            statement.execute(getSentenciaCreacion());
        }
    }

    public String getNombre() {
        return nombre;
    }

    protected void agregarCampo(Campo campo){
        campos.add(campo);
    }

    protected void agregarCampo(String nombre, Campo.Tipo tipo){
        agregarCampo(nombre, tipo, null);
    }

    protected void agregarCampo(String nombre, Campo.Tipo tipo, CampoAtributosExtra campoAtributosExtra){
        Campo campo = new Campo(nombre, tipo, campoAtributosExtra);
        agregarCampo(campo);
    }

    protected String getSentenciaCreacion(){
        String porcionCampos = "";

        for(Campo campo : campos){
            porcionCampos += campo.getNombre() + " ";
            porcionCampos += campo.getTipoValor().toString() + ",";
        }

        porcionCampos = porcionCampos.substring(0, porcionCampos.length() - 1);

        String sentencia = "CREATE TABLE " + this.getNombre() + " (";
        sentencia += porcionCampos;
        sentencia += ")";

        return sentencia;
    }

    protected abstract void agregarCamposTabla();

}
