package IO.DB.DAO;

import IO.DB.DAO.utils.QueryBuilder;
import IO.DB.DAO.utils.QueryField;
import IO.DB.structure.tablas.Table_MervalPosition;
import dataAnalysis.IndicatorData;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by Matías on 29/04/2017.
 */
public class DAOMervalPosition extends DAO{

    private static Table_MervalPosition table = Table_MervalPosition.getInstance();

    public static ArrayList<IndicatorData> selectAllMervalPositions(){
        return null;
    }

    public static void insert(IndicatorData indicatorData, Connection connection) throws SQLException {
        String insertionStatement = getInsertionQuery(indicatorData);
        doInsert(insertionStatement, connection);
    }

    public static void insert(ArrayList<IndicatorData> indicatorData, Connection connection) throws SQLException {
        for(IndicatorData indicatorDatum : indicatorData){
            insert(indicatorDatum, connection);
        }
    }

    private static String getInsertionQuery(IndicatorData indicatorData){
        ArrayList<QueryField> fields = new ArrayList<>();

        fields.add(new QueryField(table.getDate(), indicatorData.getDate()));
        fields.add(new QueryField(table.getOpening(), indicatorData.getOpening()));
        fields.add(new QueryField(table.getClosing(), indicatorData.getClosing()));
        fields.add(new QueryField(table.getMaximum(), indicatorData.getMaximum()));
        fields.add(new QueryField(table.getMinimum(), indicatorData.getMinimum()));
        fields.add(new QueryField(table.getVariation(), indicatorData.getVariation()));

        return QueryBuilder.getInsertionQuery(fields, table.getTableName());
    }
}
