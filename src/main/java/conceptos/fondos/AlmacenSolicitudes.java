package conceptos.fondos;

import java.util.ArrayList;

/**
 * Created by Matías on 22/04/2017.
 */
public class AlmacenSolicitudes {
    private ArrayList<Solicitud> solicitudes;
    private static AlmacenSolicitudes almacenSolicitudes;

    private AlmacenSolicitudes(){
        solicitudes = new ArrayList<>();
    }

    public static AlmacenSolicitudes getInstance(){
        if(almacenSolicitudes == null){
            almacenSolicitudes = new AlmacenSolicitudes();
        }

        return almacenSolicitudes;
    }

    public void almacenarSolicitud(Solicitud solicitud){
        this.solicitudes.add(solicitud);
    }

    public ArrayList<Solicitud> getSolicitudes(){
        return this.solicitudes;
    }

    public ArrayList<Solicitud> getSolicitudesSegunEstado(Solicitud.Estado estadoRequerido){

        ArrayList<Solicitud> solicitudesDevolver = new ArrayList<>();

        for(Solicitud solicitud : solicitudes) {
            if(solicitud.getEstadoSolicitud() == estadoRequerido) {
                solicitudesDevolver.add(solicitud);
            }
        }

        return solicitudesDevolver;
    }

    public boolean quitarSolicitud(Solicitud solicitud){
        return solicitudes.remove(solicitud);
    }

    public void quitarSolicitudes(ArrayList<Solicitud> solicitudesQuitar){
        for(Solicitud solicitudQuitar : solicitudesQuitar){
            quitarSolicitud(solicitudQuitar);
        }
    }
}
