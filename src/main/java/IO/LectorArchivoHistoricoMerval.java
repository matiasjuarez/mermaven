package IO;

import evolutionAnalysis.MervalPosition;
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

    public ArrayList<MervalPosition> leerArchivoHistoricoMerval(String url) throws Exception {

        ArrayList<MervalPosition> posicionesMerval = new ArrayList<>();

        SpreadsheetDocument archivo = SpreadsheetDocument.loadDocument(url);

        Table tabla = archivo.getTableByName(nombreTabla);

        List<Row> filas = tabla.getRowList();

        for(int i = primeraFilaParaLeer; i < filas.size(); i++){

            Row fila = filas.get(i);

            MervalPosition mervalPosition = cargarNuevaPosicionConValoresDeFila(fila);

            posicionesMerval.add(mervalPosition);

        }

        return posicionesMerval;
    }

    private MervalPosition cargarNuevaPosicionConValoresDeFila(Row fila){
        MervalPosition mervalPosition = new MervalPosition();

        extraerFecha(mervalPosition, fila);
        extraerValorCierre(mervalPosition, fila);
        extraerValorApertura(mervalPosition, fila);
        extraerVariacion(mervalPosition, fila);
        extraerMinimo(mervalPosition, fila);
        extraerMaximo(mervalPosition, fila);

        return mervalPosition;
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

    private void extraerFecha(MervalPosition mervalPosition, Row fila){
        String valorCelda = obtenerValorDeCelda(fila, posicionFecha);

        Date fecha = null;
        try {
            fecha = ManejadorFechas.parseDate(formatoFecha, valorCelda);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        mervalPosition.setDate(fecha);
    }

    private  void extraerValorCierre(MervalPosition mervalPosition, Row fila){
        String valorCelda = obtenerValorDeCelda(fila, posicionCierre);
        float valorCierre = parsearNumeroLeido(valorCelda);

        mervalPosition.setClosing(valorCierre);
    }

    private void extraerValorApertura(MervalPosition mervalPosition, Row fila){
        String valorCelda = obtenerValorDeCelda(fila, posicionApertura);
        float valorApertura = parsearNumeroLeido(valorCelda);

        mervalPosition.setOpening(valorApertura);
    }

    private void extraerVariacion(MervalPosition mervalPosition, Row fila){
        String valorCelda = obtenerValorDeCelda(fila, posicionVariacion);
        float valorVariacion = parsearNumeroLeido(valorCelda);

        mervalPosition.setVariation(valorVariacion);
    }

    private void extraerMinimo(MervalPosition mervalPosition, Row fila){
        String valorCelda = obtenerValorDeCelda(fila, posicionMinimo);
        float valorMinimo = parsearNumeroLeido(valorCelda);

        mervalPosition.setMinimum(valorMinimo);
    }

    private void extraerMaximo(MervalPosition mervalPosition, Row fila){
        String valorCelda = obtenerValorDeCelda(fila, posicionMaximo);
        float valorMaximo = parsearNumeroLeido(valorCelda);

        mervalPosition.setMaximum(valorMaximo);
    }

    private String obtenerValorDeCelda(Row fila, int posicion){
        Cell celda = fila.getCellByIndex(posicion);
        return celda.getStringValue();
    }
}
