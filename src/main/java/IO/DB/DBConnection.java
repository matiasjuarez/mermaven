package IO.DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by Matías on 29/04/2017.
 * Creates connections to databases
 */
public class DBConnection {

    private static final String derbyPrefix = "jdbc:derby:";

    private DBConnection(){}

    /**
     * Creates a new connection to the database sent as parameter and creates it if
     * it doesn't exist.
     * @param databaseURL - The url of the database we want to connect to
     * @return a Connection connected to the database
     * @throws SQLException
     */
    public static Connection createConnection(String databaseURL) throws SQLException {
        String urlConexion = derbyPrefix + databaseURL + ";create=true";
        Connection connection = DriverManager.getConnection(urlConexion);

        return connection;
    }

    /**
     * Disconnects the Connection sent as parameter.
     * @param connection - The connection we want to close
     * @return true if the connection was closed or if it was a null reference
     */
    public static boolean disconnect(Connection connection){
        if(connection != null){
            try {
                connection.close();
                return true;
            } catch (SQLException e) {
                e.printStackTrace();
                return false;
            }
        }

        return true;
    }
}
