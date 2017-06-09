package IO.FileRead;

import dataAnalysis.Indicator;
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
public class IndicatorFileReader {

    private String tableName = "Hoja1";
    private String dateFormat = "d/M/yy";
    private int firstRowToRead = 1;
    private int dateColumn = 0;
    private int closingColumn = 1;
    private int openingColumn = 2;
    private int variationColumn = 3;
    private int maximumColumn = 4;
    private int minimumColumn = 5;

    public ArrayList<Indicator> readIndicatorFile(String url) throws Exception {

        ArrayList<Indicator> posicionesMerval = new ArrayList<>();

        SpreadsheetDocument archivo = SpreadsheetDocument.loadDocument(url);

        Table tabla = archivo.getTableByName(tableName);

        List<Row> filas = tabla.getRowList();

        for(int i = firstRowToRead; i < filas.size(); i++){

            Row fila = filas.get(i);

            Indicator indicator = cargarNuevaPosicionConValoresDeFila(fila);

            posicionesMerval.add(indicator);

        }

        return posicionesMerval;
    }

    private Indicator cargarNuevaPosicionConValoresDeFila(Row fila){
        Indicator indicator = new Indicator();

        extraerFecha(indicator, fila);
        extraerValorCierre(indicator, fila);
        extraerValorApertura(indicator, fila);
        extraerVariacion(indicator, fila);
        extraerMinimo(indicator, fila);
        extraerMaximo(indicator, fila);

        return indicator;
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

    private void extraerFecha(Indicator indicator, Row fila){
        String valorCelda = obtenerValorDeCelda(fila, dateColumn);

        Date fecha = null;
        try {
            fecha = ManejadorFechas.parseDate(dateFormat, valorCelda);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        indicator.setDate(fecha);
    }

    private  void extraerValorCierre(Indicator indicator, Row fila){
        String valorCelda = obtenerValorDeCelda(fila, closingColumn);
        float valorCierre = parsearNumeroLeido(valorCelda);

        indicator.setClosing(valorCierre);
    }

    private void extraerValorApertura(Indicator indicator, Row fila){
        String valorCelda = obtenerValorDeCelda(fila, openingColumn);
        float valorApertura = parsearNumeroLeido(valorCelda);

        indicator.setOpening(valorApertura);
    }

    private void extraerVariacion(Indicator indicator, Row fila){
        String valorCelda = obtenerValorDeCelda(fila, variationColumn);
        float valorVariacion = parsearNumeroLeido(valorCelda);

        indicator.setVariation(valorVariacion);
    }

    private void extraerMinimo(Indicator indicator, Row fila){
        String valorCelda = obtenerValorDeCelda(fila, minimumColumn);
        float valorMinimo = parsearNumeroLeido(valorCelda);

        indicator.setMinimum(valorMinimo);
    }

    private void extraerMaximo(Indicator indicator, Row fila){
        String valorCelda = obtenerValorDeCelda(fila, maximumColumn);
        float valorMaximo = parsearNumeroLeido(valorCelda);

        indicator.setMaximum(valorMaximo);
    }

    private String obtenerValorDeCelda(Row fila, int posicion){
        Cell celda = fila.getCellByIndex(posicion);
        return celda.getStringValue();
    }
}
