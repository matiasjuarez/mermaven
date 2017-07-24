package matias.IO.SheetDataLoad;

import org.odftoolkit.simple.SpreadsheetDocument;
import org.odftoolkit.simple.table.Cell;
import org.odftoolkit.simple.table.Row;
import org.odftoolkit.simple.table.Table;

import java.util.ArrayList;

/**
 * Created by matias on 09/07/17.
 */
public class SheetDataFileReader {
    private SpreadsheetDocument document;
    private Table workingTable;
    private final String COTIZACION = "Cotizacion";
    private final String CUOTAPARTES = "Cuotapartes";
    private final String TABLE_NAME = "Tenencias";
    private final int DATE_COL_INDEX = 0;
    private final int FUND_NAME_ROW_INDEX = 0;
    private final int COL_NAME_ROW_INDEX = 1;
    private final int FIRST_ROW_WITH_DATA = 2;

    public SheetDataFileReader(String url) throws Exception {
        this.document = SpreadsheetDocument.loadDocument(url);
        this.workingTable = document.getTableByName(TABLE_NAME);
    }

    public ArrayList<SheetData> readOldDataFile(){
        ArrayList<SheetData> holdingData = new ArrayList<>();
        ArrayList<Cell> cells = findCellsInRowWithValue(CUOTAPARTES, COL_NAME_ROW_INDEX);

        for(int rowIndex = FIRST_ROW_WITH_DATA; rowIndex < workingTable.getRowCount(); rowIndex++){
            holdingData.addAll(extractHoldingDataFromRow(rowIndex, cells));
        }

        return holdingData;
    }

    private ArrayList<SheetData> extractHoldingDataFromRow(int rowIndex, ArrayList<Cell> baseCells){
        ArrayList<SheetData> sheetDataList = new ArrayList<>();
        String date = getStringValueFromCell(DATE_COL_INDEX, rowIndex);

        for(Cell cell : baseCells){
            int colIndex = cell.getColumnIndex();

            SheetData sheetData = new SheetData();
            String[] fundNameAndCurrency = getStringValueFromCell(colIndex, FUND_NAME_ROW_INDEX).split("\\|");
            String fundName = fundNameAndCurrency[0];
            String fundCurrency = fundNameAndCurrency[1];

            sheetData.setFundName(fundName.trim());
            sheetData.setFundCurrencySymbol(fundCurrency.trim());
            sheetData.setShares(getStringValueFromCell(colIndex, rowIndex));
            sheetData.setQuotation(getStringValueFromCell(colIndex + 1, rowIndex));
            sheetData.setDate(date);

            sheetDataList.add(sheetData);
        }

        return sheetDataList;
    }

    private ArrayList<Cell> findCellsInRowWithValue(String value, int rowIndex){
        ArrayList<Cell> cells = new ArrayList<>();
        Row row = workingTable.getRowByIndex(rowIndex);
        int cellCount = row.getCellCount();

        for(int i = 0; i < cellCount; i++){
            Cell cell = row.getCellByIndex(i);
            if(cell.getStringValue().equalsIgnoreCase(value)){
                cells.add(cell);
            }

        }

        return cells;
    }

    private String getStringValueFromCell(int col, int row){
        return workingTable.getCellByPosition(col, row).getStringValue();
    }
}
