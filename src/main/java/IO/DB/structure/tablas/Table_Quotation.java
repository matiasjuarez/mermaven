package IO.DB.structure.tablas;

import java.util.ArrayList;

/**
 * Created by matias on 28/05/17.
 */
public class Table_Quotation {
    private static Table_Quotation table;

    public static Table_Quotation getInstance(){
        if(table == null){
            table = new Table_Quotation();
        }

        return table;
    }

    private String tableName;
    private Field date;
    private Field found;
    private Field value;
    private Field variation;

    private Table_Quotation(){
        this.tableName = "found_quotation";
        date = new Field("date", Field.Type.DATE);
        found = new Field("fund", Field.Type.INT);
        value = new Field("value", Field.Type.FLOAT);
        variation = new Field("variation", Field.Type.FLOAT);
    }

    public String getTableName() {
        return tableName;
    }

    public Field getDate() {
        return date;
    }

    public Field getFound() {
        return found;
    }

    public Field getValue() {
        return value;
    }

    public Field getVariation() {
        return variation;
    }

    public ArrayList<Field> getFields(){
        ArrayList<Field> fields = new ArrayList<>();
        fields.add(date);
        fields.add(found);
        fields.add(value);
        fields.add(variation);
        return fields;
    }

    public Table buildTable(){
        Table table = new Table(this.tableName);

        for(Field field : getFields()){
            table.addField(field);
        }

        return table;
    }
}
