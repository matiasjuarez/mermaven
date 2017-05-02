package IO.basedatos;

import configuracion.Configuracion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by Matías on 29/04/2017.
 */
public class Conexion {
    private final String baseDatos;
    private final String prefijoUrl = "jdbc:derby:";

    private Connection connection;

    public Conexion(String baseDatos){
        this.baseDatos = baseDatos;
    }

    /**
     * Desconecta la conexion si existe una y crea una nueva.
     * @param autocommit - Indica si la conexion va tener autocommit o no
     * @return un objeto Connection listo para usarse
     * @throws SQLException
     */
    public Connection conectar(boolean autocommit) throws SQLException {
        if(connection != null){
            desconectar();
        }

        String urlConexion = prefijoUrl + baseDatos + ";create=true";
        connection = DriverManager.getConnection(urlConexion);
        connection.setAutoCommit(autocommit);

        return connection;
    }

    public boolean desconectar(){
        if(connection != null){
            try {
                connection.close();
                connection = null;
                return true;
            } catch (SQLException e) {
                e.printStackTrace();
                return false;
            }
        }

        return true;
    }

    public static boolean desconectar(Connection connection){
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

    public Connection getConnection(){
        return this.connection;
    }
}
