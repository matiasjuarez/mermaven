package matias.inversor.IO.baseDatos;

import IO.DB.structure.tablas.Field;
import IO.DB.structure.tablas.Table;

import java.util.ArrayList;

/**
 * Created by matias on 14/05/17.
 */
public class Table_Test extends Table{

    public Table_Test(){
        super("Table_Test");
    }

    @Override
    protected ArrayList<Field> generateTableFields() {
        ArrayList<Field> fields = new ArrayList<>();
        fields.add(new Field("Field_1", Field.Type.FLOAT));
        fields.add(new Field("Field_2", Field.Type.DATE));

        return fields;
    }
}
