package IO.DB.DAO;

import IO.DB.DAO.utils.QueryBuilder;
import IO.DB.DAO.utils.QueryField;
import IO.DB.structure.tablas.Table_MervalPosition;
import dataAnalysis.Indicator;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by Matías on 29/04/2017.
 */
public class DAOMervalPosition extends DAO{

    private static Table_MervalPosition table = Table_MervalPosition.getInstance();

    public static ArrayList<Indicator> selectAllMervalPositions(){
        return null;
    }

    public static void insert(Indicator indicator, Connection connection) throws SQLException {
        String insertionStatement = getInsertionQuery(indicator);
        doInsert(insertionStatement, connection);
    }

    public static void insert(ArrayList<Indicator> indicators, Connection connection) throws SQLException {
        for(Indicator indicator : indicators){
            insert(indicator, connection);
        }
    }

    private static String getInsertionQuery(Indicator indicator){
        ArrayList<QueryField> fields = new ArrayList<>();

        fields.add(new QueryField(table.getDate(), indicator.getDate()));
        fields.add(new QueryField(table.getOpening(), indicator.getOpening()));
        fields.add(new QueryField(table.getClosing(), indicator.getClosing()));
        fields.add(new QueryField(table.getMaximum(), indicator.getMaximum()));
        fields.add(new QueryField(table.getMinimum(), indicator.getMinimum()));
        fields.add(new QueryField(table.getVariation(), indicator.getVariation()));

        return QueryBuilder.getInsertionQuery(fields, table.getTableName());
    }
}
