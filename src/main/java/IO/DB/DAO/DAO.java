package IO.DB.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by matias on 17/05/17.
 */
public class DAO {
    protected static void doInsert(String statement, Connection connection) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(statement);
        preparedStatement.execute();
    }

    protected static ResultSet doSelect(String statement, Connection connection) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(statement);
        return preparedStatement.executeQuery();
    }
}
