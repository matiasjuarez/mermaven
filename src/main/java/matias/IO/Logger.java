package matias.IO;

/**
 * Created by Matías on 25/04/2017.
 */
public class Logger {

    private static Logger logger;

    private Logger(){}

    public static Logger getInstance(){
        if(logger == null){
            logger = new Logger();
        }

        return logger;
    }

    public void info(String mensaje){
        System.out.println(mensaje);
    }

    public void error(String message){
        System.err.println(message);
    }
}
