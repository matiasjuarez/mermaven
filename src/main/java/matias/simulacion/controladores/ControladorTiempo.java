package matias.simulacion.controladores;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created by Matías on 22/04/2017.
 */
public class ControladorTiempo {
    private static ControladorTiempo controladorTiempo;

    private ControladorTiempo(){}

    public static ControladorTiempo getInstance(){
        if(controladorTiempo == null){
            controladorTiempo = new ControladorTiempo();
        }

        return controladorTiempo;
    }

    private Date fechaActual;

    public Date getFechaActual(){
        return this.fechaActual;
    }

    public void setFechaActual(Date fecha){
        this.fechaActual = fecha;
    }

    public Date avanzarUnDia(){
        GregorianCalendar gc = new GregorianCalendar();
        gc.setTime(this.fechaActual);

        gc.add(Calendar.DATE, 1);

        fechaActual = gc.getTime();

        return fechaActual;
    }

    public boolean esDiaHabil(){
        GregorianCalendar gc = new GregorianCalendar();
        gc.setTime(this.fechaActual);

        if(gc.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY ||
                gc.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY){
            return false;
        }

        return true;
    }
}
