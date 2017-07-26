package matias.utilidades;

import matias.IO.Logger;

/**
 * Created by matias on 23/07/17.
 */
public class ExceptionsHandler {
    public static RuntimeException convertToRuntimeException(Exception e){
        Logger.getInstance().error(e.getMessage());
        e.printStackTrace();
        throw new RuntimeException(e.getMessage());
    }

    public static void logException(Exception e, boolean printStackTrace){
        Logger.getInstance().error(e.getMessage());
        if(printStackTrace){
            e.printStackTrace();
        }
    }

    public static void logException(Exception e){
        logException(e, false);
    }
}
