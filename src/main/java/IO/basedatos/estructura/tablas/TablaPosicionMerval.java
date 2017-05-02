package IO.basedatos.estructura.tablas;

import IO.basedatos.estructura.campos.Campo;

/**
 * Created by Matías on 01/05/2017.
 */
public class TablaPosicionMerval extends Tabla{

    public TablaPosicionMerval(){
        super("posicion_merval");
    }

    @Override
    protected void agregarCamposTabla() {
        agregarCampo("fecha", Campo.Tipo.DATE);
        agregarCampo("apertura", Campo.Tipo.FLOAT);
        agregarCampo("cierre", Campo.Tipo.FLOAT);
        agregarCampo("maximo", Campo.Tipo.FLOAT);
        agregarCampo("minimo", Campo.Tipo.FLOAT);
        agregarCampo("variacion", Campo.Tipo.FLOAT);
    }
}
