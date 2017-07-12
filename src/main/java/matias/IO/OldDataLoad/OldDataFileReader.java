package matias.IO.OldDataLoad;

import org.odftoolkit.simple.SpreadsheetDocument;
import org.odftoolkit.simple.table.Cell;
import org.odftoolkit.simple.table.Row;
import org.odftoolkit.simple.table.Table;

import java.util.ArrayList;

/**
 * Created by matias on 09/07/17.
 */
public class OldDataFileReader {
    private SpreadsheetDocument document;
    private Table workingTable;
    private final String COTIZACION = "Cotizacion";
    private final String CUOTAPARTES = "Cuotapartes";
    private final String TABLE_NAME = "Tenencias";
    private final int DATE_COL_INDEX = 0;
    private final int FUND_NAME_ROW_INDEX = 0;
    private final int COL_NAME_ROW_INDEX = 1;
    private final int FIRST_ROW_WITH_DATA = 2;

    public OldDataFileReader(String url) throws Exception {
        this.document = SpreadsheetDocument.loadDocument(url);
        this.workingTable = document.getTableByName(TABLE_NAME);
    }

    public ArrayList<HoldingDataRaw> readOldDataFile(){
        ArrayList<HoldingDataRaw> holdingData = new ArrayList<>();
        ArrayList<Cell> cells = findCellsInRowWithValue(CUOTAPARTES, COL_NAME_ROW_INDEX);

        for(int rowIndex = FIRST_ROW_WITH_DATA; rowIndex < workingTable.getRowCount(); rowIndex++){
            holdingData.addAll(extractHoldingDataFromRow(rowIndex, cells));
        }

        return holdingData;
    }

    private ArrayList<HoldingDataRaw> extractHoldingDataFromRow(int rowIndex, ArrayList<Cell> baseCells){
        ArrayList<HoldingDataRaw> holdingDataRaws = new ArrayList<>();
        String date = getStringValueFromCell(DATE_COL_INDEX, rowIndex);

        for(Cell cell : baseCells){
            int colIndex = cell.getColumnIndex();

            HoldingDataRaw holdingDataRaw = new HoldingDataRaw();
            holdingDataRaw.setFundName(getStringValueFromCell(colIndex, FUND_NAME_ROW_INDEX));
            holdingDataRaw.setShares(getStringValueFromCell(colIndex, rowIndex));
            holdingDataRaw.setQuotation(getStringValueFromCell(colIndex + 1, rowIndex));
            holdingDataRaw.setDate(date);

            holdingDataRaws.add(holdingDataRaw);
        }

        return holdingDataRaws;
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
