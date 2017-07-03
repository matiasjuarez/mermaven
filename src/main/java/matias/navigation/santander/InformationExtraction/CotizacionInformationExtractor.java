package matias.navigation.santander.InformationExtraction;

import matias.navigation.santander.InformationExtraction.processing.QuotationInformationExtraction;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import matias.navigation.NavigationUtils;

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

    public ArrayList<QuotationInformationExtraction> extractCotizacionInformation(WebDriver driver){
        ArrayList<QuotationInformationExtraction> cotizaciones = new ArrayList<>();

        cotizaciones.addAll(extractCotizacionInformationFromTable(LOC_TBL_PESOS, driver));
        cotizaciones.addAll(extractCotizacionInformationFromTable(LOC_TBL_DOLARES, driver));

        return cotizaciones;
    }

    private ArrayList<QuotationInformationExtraction> extractCotizacionInformationFromTable(String tablePrefix, WebDriver driver){
        ArrayList<QuotationInformationExtraction> cotizaciones = new ArrayList<>();
        int currentRow = STARTING_ROW_INFO;

        while(rowExists(tablePrefix, currentRow, driver)){
            QuotationInformationExtraction newQuotationInformationExtraction = new QuotationInformationExtraction();
            newQuotationInformationExtraction.setFund(extractFoundNameFromRow(tablePrefix, currentRow, driver));
            newQuotationInformationExtraction.setValue(extractInfoFromRowCol(tablePrefix, currentRow, VALOR_FECHA, driver));
            newQuotationInformationExtraction.setVariationDaily(extractInfoFromRowCol(tablePrefix, currentRow, VARIACION_DIARIA, driver));
            newQuotationInformationExtraction.setVariation30(extractInfoFromRowCol(tablePrefix, currentRow, VARIACION_ULTIMOS_30, driver));
            newQuotationInformationExtraction.setVariation90(extractInfoFromRowCol(tablePrefix, currentRow, VARIACION_ULTIMOS_90, driver));
            newQuotationInformationExtraction.setVariation365(extractInfoFromRowCol(tablePrefix, currentRow, VARIACION_ANUAL, driver));

            cotizaciones.add(newQuotationInformationExtraction);

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
