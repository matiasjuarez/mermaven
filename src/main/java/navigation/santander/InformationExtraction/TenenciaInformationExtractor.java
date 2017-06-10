package navigation.santander.InformationExtraction;

import navigation.santander.InformationExtraction.processing.HoldingInformationExtraction;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import navigation.NavigationUtils;

import java.util.ArrayList;

/**
 * Created by matias on 25/05/17.
 */
public class TenenciaInformationExtractor {
    private final String LOC_TBL_PESOS = "//*[@id=\"cont\"]/div/div/table[2]";
    private final String LOC_TBL_DOLARS = "//*[@id=\"cont\"]/div/div/table[4]";

    private final String LOC_TR_SUFIX = "/tbody/tr[@ROW]/td[@COL]";
    private final String LOC_TXT_FOUND_NAME = "/table/tbody/tr/td[1]";

    private final int FOUND_NAME_COL = 2;
    private final int COUTA_PARTES_COL = 3;
    private final int ULTIMA_COTIZACION_COL = 4;
    private final int PESOS_COL = 5;
    private final int DOLARES_COL = 6;

    private final int STARTING_ROW_TABLE_INFO = 2;

    private final int timeout = 10;

    public ArrayList<HoldingInformationExtraction> extractTenenciaInformation(WebDriver driver){
        ArrayList<HoldingInformationExtraction> holdingInformationExtractions = new ArrayList<>();

        holdingInformationExtractions.addAll(extractTenenciaInformationFromTable(LOC_TBL_PESOS, driver));
        holdingInformationExtractions.addAll(extractTenenciaInformationFromTable(LOC_TBL_DOLARS, driver));

        return holdingInformationExtractions;
    }

    private ArrayList<HoldingInformationExtraction> extractTenenciaInformationFromTable(String tablePrefix, WebDriver driver){
        ArrayList<HoldingInformationExtraction> holdingInformationExtractions = new ArrayList<>();
        int currentRow = STARTING_ROW_TABLE_INFO;

        while(rowExists(tablePrefix, currentRow, driver)){
            HoldingInformationExtraction newHoldingInformationExtraction = new HoldingInformationExtraction();
            newHoldingInformationExtraction.setFund(extractFoundNameFromRow(tablePrefix, currentRow, driver));
            newHoldingInformationExtraction.setShareParts(extractInfoFromRowCol(tablePrefix, currentRow, COUTA_PARTES_COL, driver));
            newHoldingInformationExtraction.setLastQuotation(extractInfoFromRowCol(tablePrefix, currentRow, ULTIMA_COTIZACION_COL, driver));
            newHoldingInformationExtraction.setPesos(extractInfoFromRowCol(tablePrefix, currentRow, PESOS_COL, driver));
            newHoldingInformationExtraction.setDolars(extractInfoFromRowCol(tablePrefix, currentRow, DOLARES_COL, driver));

            holdingInformationExtractions.add(newHoldingInformationExtraction);

            currentRow++;
        }

        return holdingInformationExtractions;
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
        String nextRowCol = LOC_TR_SUFIX.
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
