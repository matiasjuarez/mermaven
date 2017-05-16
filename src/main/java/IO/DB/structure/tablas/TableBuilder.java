package IO.DB.structure.tablas;

/**
 * Created by matias on 14/05/17.
 */
public class TableBuilder {

    public static Table buildMervalPositionTable(){
        String tableName = "merval_position";
        Table table = new Table(tableName);

        table.addField(new Field("fecha", Field.Type.DATE));
        table.addField(new Field("apertura", Field.Type.FLOAT));
        table.addField(new Field("cierre", Field.Type.FLOAT));
        table.addField(new Field("maximo", Field.Type.FLOAT));
        table.addField(new Field("minimo", Field.Type.FLOAT));
        table.addField(new Field("variacion", Field.Type.FLOAT));

        return table;
    }
}
