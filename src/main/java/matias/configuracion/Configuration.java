package matias.configuracion;

/**
 * Created by Matías on 01/05/2017.
 */
public class Configuration {
    private static Configuration configuration;

    private String pathToDatabases = "./src/main/Datos/DB/";
    private String userDataSan = "/home/matias/Documents/bdata";
    private String userDataMac = "/home/matias/Documents/bdatam";

    private Configuration(){}

    public static Configuration getInstance(){
        if(configuration == null){
            configuration = new Configuration();
        }

        return configuration;
    }

    public String getPathToDatabases(){
        return pathToDatabases;
    }

    public String getPathToUserDataSan(){
        return userDataSan;
    }

    public String getPathToUserDataMac(){
        return userDataMac;
    }
}
