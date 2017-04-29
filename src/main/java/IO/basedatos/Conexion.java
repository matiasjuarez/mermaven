package IO.basedatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by Matías on 29/04/2017.
 */
public class Conexion {
    private final String baseDatos;
    private final String driver = "org.apache.derby.jdbc.EmbeddedDriver";
    private final String prefijoUrl = "jdbc:derby:";

    private Connection connection;

    public Conexion(String baseDatos){
        this.baseDatos = baseDatos;
    }

    public Connection conectar(){
        if(connection == null){
            try {
                String urlConexion = prefijoUrl + baseDatos + ";create=true";
                connection = DriverManager.getConnection(urlConexion);
            } catch (SQLException e) {
                e.printStackTrace();
                System.exit(0);
            }
        }

        return connection;
    }

    public boolean desconectar(){
        String urlDesconexion = prefijoUrl + baseDatos + ";shutdown=true";

        try {
            DriverManager.getConnection(urlDesconexion);
        } catch (SQLException e) {
            if ( e.getSQLState().equals("XJ015") ) {
                return true;
            }
        }

        return false;
    }
}
