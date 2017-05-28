package navigation.santander.InformationExtraction;

import navigation.Cotizacion;
import navigation.Tenencia;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilidades.NavigationUtils;

import java.util.ArrayList;

/**
 * Created by matias on 28/05/17.
 */
public class CotizacionInformationExtractor {
    private final String LOC_TBL_PESOS = "//*[@id=\"cont\"]/div/div/table[2]/tbody";
    private final String LOC_TBL_DOLARES = "//*[@id=\"cont\"]/div/div/table[3]/tbody";

    private final String LOC_TR_TD_SUFIX = "/tr[@ROW]/td[@COL]";
    private final String LOC_TXT_FOUND_NAME = "/table/tbody/tr/td[1]";

    private final int FOUND_NAME_COL = 1;
    private final int VALOR_FECHA = 2;
    private final int VARIACION_DIARIA = 3;
    private final int VARIACION_ULTIMOS_30 = 4;
    private final int VARIACION_ULTIMOS_90 = 5;
    private final int VARIACION_ANUAL = 6;

    private final int STARTING_ROW_INFO = 4;

    private final int timeout = 10;

    public ArrayList<Cotizacion> extractCotizacionInformation(WebDriver driver){
        ArrayList<Cotizacion> cotizaciones = new ArrayList<>();

        cotizaciones.addAll(extractCotizacionInformationFromTable(LOC_TBL_PESOS, driver));
        cotizaciones.addAll(extractCotizacionInformationFromTable(LOC_TBL_DOLARES, driver));

        return cotizaciones;
    }

    private ArrayList<Cotizacion> extractCotizacionInformationFromTable(String tablePrefix, WebDriver driver){
        ArrayList<Cotizacion> cotizaciones = new ArrayList<>();
        int currentRow = STARTING_ROW_INFO;

        while(rowExists(tablePrefix, currentRow, driver)){
            Cotizacion newCotizacion = new Cotizacion();
            newCotizacion.setFondo(extractFoundNameFromRow(tablePrefix, currentRow, driver));
            newCotizacion.setValor(extractInfoFromRowCol(tablePrefix, currentRow, VALOR_FECHA, driver));
            newCotizacion.setVariacionDiaria(extractInfoFromRowCol(tablePrefix, currentRow, VARIACION_DIARIA, driver));
            newCotizacion.setVariacion30(extractInfoFromRowCol(tablePrefix, currentRow, VARIACION_ULTIMOS_30, driver));
            newCotizacion.setVariacion90(extractInfoFromRowCol(tablePrefix, currentRow, VARIACION_ULTIMOS_90, driver));
            newCotizacion.setVariacion365(extractInfoFromRowCol(tablePrefix, currentRow, VARIACION_ANUAL, driver));

            cotizaciones.add(newCotizacion);

            currentRow++;
        }

        return  cotizaciones;
    }

    private boolean rowExists(String tablePrefix, int row, WebDriver driver){
        StringBuilder builder = new StringBuilder();
        builder.append(tablePrefix).
                append(getRowColPart(row, FOUND_NAME_COL));

        try{
            NavigationUtils.waitForElement(driver, builder.toString(), timeout);
            return true;
        }
        catch(TimeoutException te){
            return false;
        }
    }

    private String getRowColPart(int row, int col){
        String nextRowCol = LOC_TR_TD_SUFIX.
                replaceAll("@ROW", new Integer(row).toString()).
                replaceAll("@COL", new Integer(col).toString());

        return nextRowCol;
    }

    private String extractFoundNameFromRow(String tablePrefix, int rowNumber, WebDriver driver){
        StringBuilder builder = new StringBuilder();
        builder.append(tablePrefix).
                append(getRowColPart(rowNumber, FOUND_NAME_COL)).
                append(LOC_TXT_FOUND_NAME);

        WebElement foundNameElement = NavigationUtils.waitForElement(driver, builder.toString(), timeout);
        return foundNameElement.getText();
    }

    private String extractInfoFromRowCol(String tablePrefix, int row, int col, WebDriver driver){
        StringBuilder builder = new StringBuilder();
        builder.append(tablePrefix).
                append(getRowColPart(row, col));

        WebElement infoElement = NavigationUtils.waitForElement(driver, builder.toString(), timeout);
        return infoElement.getText();
    }
}
