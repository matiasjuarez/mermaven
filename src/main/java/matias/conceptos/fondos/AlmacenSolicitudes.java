package matias.conceptos.fondos;

import java.util.ArrayList;

/**
 * Created by Matías on 22/04/2017.
 */
public class AlmacenSolicitudes {
    private ArrayList<Request> solicitudes;
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

    public void almacenarSolicitud(Request request){
        this.solicitudes.add(request);
    }

    public ArrayList<Request> getSolicitudes(){
        return this.solicitudes;
    }

    public ArrayList<Request> getSolicitudesSegunEstado(Request.Status statusRequerido){

        ArrayList<Request> solicitudesDevolver = new ArrayList<>();

        for(Request request : solicitudes) {
            if(request.getStatus() == statusRequerido) {
                solicitudesDevolver.add(request);
            }
        }

        return solicitudesDevolver;
    }

    public boolean quitarSolicitud(Request request){
        return solicitudes.remove(request);
    }

    public void quitarSolicitudes(ArrayList<Request> solicitudesQuitar){
        for(Request requestQuitar : solicitudesQuitar){
            quitarSolicitud(requestQuitar);
        }
    }
}
