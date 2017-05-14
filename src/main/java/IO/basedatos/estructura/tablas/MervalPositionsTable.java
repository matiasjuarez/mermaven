package IO.basedatos.estructura.tablas;

import java.util.ArrayList;

/**
 * Created by Matías on 01/05/2017.
 */
public class MervalPositionsTable extends Table {

    public MervalPositionsTable(){
        super("merval_position");
    }

    @Override
    protected ArrayList<Field> generateTableFields() {
        ArrayList<Field> fields = new ArrayList<>();
        fields.add(new Field("fecha", Field.Type.DATE));
        fields.add(new Field("apertura", Field.Type.FLOAT));
        fields.add(new Field("cierre", Field.Type.FLOAT));
        fields.add(new Field("maximo", Field.Type.FLOAT));
        fields.add(new Field("minimo", Field.Type.FLOAT));
        fields.add(new Field("variacion", Field.Type.FLOAT));

        return fields;
    }
}
