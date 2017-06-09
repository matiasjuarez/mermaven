package IO.DB.structure.tablas;

import java.util.ArrayList;

/**
 * Created by matias on 16/05/17.
 */
public class Table_MervalPosition {

    private static Table_MervalPosition table;

    public static Table_MervalPosition getInstance(){
        if(table == null){
            table = new Table_MervalPosition();
        }
        return table;
    }

    private String tableName;
    private Field date;
    private Field opening;
    private Field closing;
    private Field maximum;
    private Field minimum;
    private Field variation;

    private Table_MervalPosition(){
        tableName = "merval_position";
        date = new Field("date", Field.Type.DATE);
        opening = new Field("opening", Field.Type.FLOAT);
        closing = new Field("closing", Field.Type.FLOAT);
        maximum = new Field("maximum", Field.Type.FLOAT);
        minimum = new Field("minimum", Field.Type.FLOAT);
        variation = new Field("variation", Field.Type.FLOAT);
    }

    public Field getDate() {
        return date;
    }

    public Field getOpening() {
        return opening;
    }

    public Field getClosing() {
        return closing;
    }

    public Field getMaximum() {
        return maximum;
    }

    public Field getMinimum() {
        return minimum;
    }

    public Field getVariation() {
        return variation;
    }

    public String getTableName() {
        return tableName;
    }

    public ArrayList<Field> getFields(){
        ArrayList<Field> fields = new ArrayList<>();
        fields.add(date);
        fields.add(opening);
        fields.add(closing);
        fields.add(maximum);
        fields.add(minimum);
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
