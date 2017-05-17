package IO.DB.DAO;

import IO.DB.structure.tablas.Table_MervalPosition;
import evolutionAnalysis.MervalPosition;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by Matías on 29/04/2017.
 */
public class DAOMervalPosition {

    private static Table_MervalPosition table = Table_MervalPosition.getInstance();

    public static void doInsert(MervalPosition mervalPosition, Connection connection) throws SQLException {
        String insertionStatement = getInsertionQuery(mervalPosition);

        PreparedStatement preparedStatement = connection.prepareStatement(insertionStatement);
        preparedStatement.execute();
    }

    public static void doInsert(ArrayList<MervalPosition> mervalPositions, Connection connection) throws SQLException {
        for(MervalPosition mervalPosition : mervalPositions){
            doInsert(mervalPosition, connection);
        }
    }

    private static String getInsertionQuery(MervalPosition mervalPosition){
        ArrayList<QueryField> fields = new ArrayList<>();

        fields.add(new QueryField(table.getDate(), mervalPosition.getDate()));
        fields.add(new QueryField(table.getOpening(), mervalPosition.getOpening()));
        fields.add(new QueryField(table.getClosing(), mervalPosition.getClosing()));
        fields.add(new QueryField(table.getMaximum(), mervalPosition.getMaximum()));
        fields.add(new QueryField(table.getMinimum(), mervalPosition.getMinimum()));
        fields.add(new QueryField(table.getVariation(), mervalPosition.getVariation()));

        return DAOHelper.getInsertionQuery(fields, table.getTableName());
    }
}
