package IO;

import analisisEvolucion.PosicionMerval;
import org.odftoolkit.simple.SpreadsheetDocument;
import org.odftoolkit.simple.table.Cell;
import org.odftoolkit.simple.table.Row;
import org.odftoolkit.simple.table.Table;
import utilidades.ManejadorFechas;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Matías on 27/04/2017.
 */
public class LectorArchivoHistoricoMerval {

    private String nombreTabla = "Hoja1";
    private String formatoFecha = "d/M/yy";
    private int primeraFilaParaLeer = 1;
    private int posicionFecha = 0;
    private int posicionCierre = 1;
    private int posicionApertura = 2;
    private int posicionVariacion = 3;
    private int posicionMaximo = 4;
    private int posicionMinimo = 5;

    public ArrayList<PosicionMerval> leerArchivoHistoricoMerval(String url) throws Exception {

        ArrayList<PosicionMerval> posicionesMerval = new ArrayList<>();

        SpreadsheetDocument archivo = SpreadsheetDocument.loadDocument(url);

        Table tabla = archivo.getTableByName(nombreTabla);

        List<Row> filas = tabla.getRowList();

        for(int i = primeraFilaParaLeer; i < filas.size(); i++){

            Row fila = filas.get(i);

            PosicionMerval posicionMerval = cargarNuevaPosicionConValoresDeFila(fila);

            posicionesMerval.add(posicionMerval);

        }

        return posicionesMerval;
    }

    private PosicionMerval cargarNuevaPosicionConValoresDeFila(Row fila){
        PosicionMerval posicionMerval = new PosicionMerval();

        extraerFecha(posicionMerval, fila);
        extraerValorCierre(posicionMerval, fila);
        extraerValorApertura(posicionMerval, fila);
        extraerVariacion(posicionMerval, fila);
        extraerMinimo(posicionMerval, fila);
        extraerMaximo(posicionMerval, fila);

        return posicionMerval;
    }

    private float parsearNumeroLeido(String numero){
        float numeroConvertido = 0;

        try{
            numeroConvertido = Float.parseFloat(numero);
        }
        catch(Exception e){
            numeroConvertido = convertirNumeroConComaYPunto(numero);
        }

        return numeroConvertido;
    }

    private float convertirNumeroConComaYPunto(String numero){
        String sinPuntos = numero.replace(".", "");
        String remplazoComaPorPunto = sinPuntos.replace(",", ".");

        float numeroConvertido = Float.parseFloat(remplazoComaPorPunto);

        return numeroConvertido;
    }

    private void extraerFecha(PosicionMerval posicionMerval, Row fila){
        String valorCelda = obtenerValorDeCelda(fila, posicionFecha);

        Date fecha = null;
        try {
            fecha = ManejadorFechas.parseDate(formatoFecha, valorCelda);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        posicionMerval.setFecha(fecha);
    }

    private  void extraerValorCierre(PosicionMerval posicionMerval, Row fila){
        String valorCelda = obtenerValorDeCelda(fila, posicionCierre);
        float valorCierre = parsearNumeroLeido(valorCelda);

        posicionMerval.setCierre(valorCierre);
    }

    private void extraerValorApertura(PosicionMerval posicionMerval, Row fila){
        String valorCelda = obtenerValorDeCelda(fila, posicionApertura);
        float valorApertura = parsearNumeroLeido(valorCelda);

        posicionMerval.setApertura(valorApertura);
    }

    private void extraerVariacion(PosicionMerval posicionMerval, Row fila){
        String valorCelda = obtenerValorDeCelda(fila, posicionVariacion);
        float valorVariacion = parsearNumeroLeido(valorCelda);

        posicionMerval.setVariacionPorcentual(valorVariacion);
    }

    private void extraerMinimo(PosicionMerval posicionMerval, Row fila){
        String valorCelda = obtenerValorDeCelda(fila, posicionMinimo);
        float valorMinimo = parsearNumeroLeido(valorCelda);

        posicionMerval.setMinimo(valorMinimo);
    }

    private void extraerMaximo(PosicionMerval posicionMerval, Row fila){
        String valorCelda = obtenerValorDeCelda(fila, posicionMaximo);
        float valorMaximo = parsearNumeroLeido(valorCelda);

        posicionMerval.setMaximo(valorMaximo);
    }

    private String obtenerValorDeCelda(Row fila, int posicion){
        Cell celda = fila.getCellByIndex(posicion);
        return celda.getStringValue();
    }
}
