package IO.DB.structure.tablas;

/**
 * Created by matias on 28/05/17.
 */
public class Table_Cotizaciones {
    private static Table_Cotizaciones table;

    public Table_Cotizaciones getInstance(){
        if(table == null){
            table = new Table_Cotizaciones();
        }

        return table;
    }

    private Table_Cotizaciones(){}
}
