package IO.FileRead;

import dataAnalysis.IndicatorData;
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

    public ArrayList<IndicatorData> readIndicatorFile(String url) throws Exception {

        ArrayList<IndicatorData> indicatorData = new ArrayList<>();

        SpreadsheetDocument file = SpreadsheetDocument.loadDocument(url);

        Table table = file.getTableByName(tableName);

        List<Row> rows = table.getRowList();

        for(int i = firstRowToRead; i < rows.size(); i++){

            Row row = rows.get(i);

            IndicatorData data = createIndicatorDataFromRow(row);

            indicatorData.add(data);

        }

        return indicatorData;
    }

    private IndicatorData createIndicatorDataFromRow(Row row){
        IndicatorData indicatorData = new IndicatorData();

        extractDate(indicatorData, row);
        extractClosingValue(indicatorData, row);
        extractOpeningValue(indicatorData, row);
        extractVariation(indicatorData, row);
        extractMinimum(indicatorData, row);
        extractMaximum(indicatorData, row);

        return indicatorData;
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

    private void extractDate(IndicatorData indicatorData, Row fila){
        String valorCelda = obtenerValorDeCelda(fila, dateColumn);

        Date fecha = null;
        try {
            fecha = ManejadorFechas.parseDate(dateFormat, valorCelda);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        indicatorData.setDate(fecha);
    }

    private  void extractClosingValue(IndicatorData indicatorData, Row fila){
        String valorCelda = obtenerValorDeCelda(fila, closingColumn);
        float valorCierre = parsearNumeroLeido(valorCelda);

        indicatorData.setClosing(valorCierre);
    }

    private void extractOpeningValue(IndicatorData indicatorData, Row fila){
        String valorCelda = obtenerValorDeCelda(fila, openingColumn);
        float valorApertura = parsearNumeroLeido(valorCelda);

        indicatorData.setOpening(valorApertura);
    }

    private void extractVariation(IndicatorData indicatorData, Row fila){
        String valorCelda = obtenerValorDeCelda(fila, variationColumn);
        float valorVariacion = parsearNumeroLeido(valorCelda);

        indicatorData.setVariation(valorVariacion);
    }

    private void extractMinimum(IndicatorData indicatorData, Row fila){
        String valorCelda = obtenerValorDeCelda(fila, minimumColumn);
        float valorMinimo = parsearNumeroLeido(valorCelda);

        indicatorData.setMinimum(valorMinimo);
    }

    private void extractMaximum(IndicatorData indicatorData, Row fila){
        String valorCelda = obtenerValorDeCelda(fila, maximumColumn);
        float valorMaximo = parsearNumeroLeido(valorCelda);

        indicatorData.setMaximum(valorMaximo);
    }

    private String obtenerValorDeCelda(Row fila, int posicion){
        Cell celda = fila.getCellByIndex(posicion);
        return celda.getStringValue();
    }
}
