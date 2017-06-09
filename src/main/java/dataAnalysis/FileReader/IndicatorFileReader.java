package dataAnalysis.FileReader;

import org.odftoolkit.simple.SpreadsheetDocument;
import org.odftoolkit.simple.table.Cell;
import org.odftoolkit.simple.table.Row;
import org.odftoolkit.simple.table.Table;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Matías on 27/04/2017.
 */
public class IndicatorFileReader {

    private String tableName;
    private Integer firstRowToRead;
    private Integer dateColumn;
    private Integer closingColumn;
    private Integer openingColumn;
    private Integer variationColumn;
    private Integer maximumColumn;
    private Integer minimumColumn;

    public ArrayList<RawIndicatorData> readIndicatorFile(String url) throws Exception {
        ArrayList<RawIndicatorData> rawIndicatorData = new ArrayList<>();

        SpreadsheetDocument file = SpreadsheetDocument.loadDocument(url);
        Table table = file.getTableByName(tableName);
        List<Row> rows = table.getRowList();

        for(int i = firstRowToRead; i < rows.size(); i++){
            Row row = rows.get(i);
            RawIndicatorData data = createIndicatorDataFromRow(row);
            rawIndicatorData.add(data);
        }

        return rawIndicatorData;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public void setFirstRowToRead(Integer firstRowToRead) {
        this.firstRowToRead = firstRowToRead;
    }

    public void setDateColumn(Integer dateColumn) {
        this.dateColumn = dateColumn;
    }

    public void setClosingColumn(Integer closingColumn) {
        this.closingColumn = closingColumn;
    }

    public void setOpeningColumn(Integer openingColumn) {
        this.openingColumn = openingColumn;
    }

    public void setVariationColumn(Integer variationColumn) {
        this.variationColumn = variationColumn;
    }

    public void setMaximumColumn(Integer maximumColumn) {
        this.maximumColumn = maximumColumn;
    }

    public void setMinimumColumn(Integer minimumColumn) {
        this.minimumColumn = minimumColumn;
    }

    private RawIndicatorData createIndicatorDataFromRow(Row row){
        RawIndicatorData rawIndicatorData = new RawIndicatorData();

        rawIndicatorData.setDate(getCellValue(row, dateColumn));
        rawIndicatorData.setClosing(getCellValue(row, closingColumn));
        rawIndicatorData.setOpening(getCellValue(row, openingColumn));
        rawIndicatorData.setMinimum(getCellValue(row, minimumColumn));
        rawIndicatorData.setMaximum(getCellValue(row, maximumColumn));
        rawIndicatorData.setVariation(getCellValue(row, variationColumn));

        return rawIndicatorData;
    }

    private String getCellValue(Row row, Integer position){
        if(row == null || position == null){
            return null;
        }

        Cell cell = row.getCellByIndex(position);
        return cell.getStringValue();
    }
}
