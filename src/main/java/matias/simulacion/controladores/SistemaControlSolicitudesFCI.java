/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matias.simulacion.controladores;

import matias.conceptos.excepciones.ExcepcionMonedaIncompatible;
import matias.conceptos.excepciones.ExcepcionFondosInsuficientes;

/**
 * Se encarga de validar que se posean los fondos necesarios para create la solicitud de rescate o suscripcion y almacena
 * la solicitud en el almacen de solicitudes.
 * @author Matías
 */
public class SistemaControlSolicitudesFCI {

    private static SistemaControlSolicitudesFCI sistemaControlSolicitudesFCI;

    private SistemaControlSolicitudesFCI(){}

    public static SistemaControlSolicitudesFCI getInstance(){
        if(sistemaControlSolicitudesFCI == null){
            sistemaControlSolicitudesFCI = new SistemaControlSolicitudesFCI();
        }

        return sistemaControlSolicitudesFCI;
    }

    /**
     * Crea una solicitud de rescate o suscripcion.
     * @param cajaDeAhorro - La caja de ahorro desde la cual extraeremos los fondos para suscribir o en la cual depositaremos los fondos del rescate
     * @param participacionFondo - La participacion en la cual deseamos invertir o de la cual deseamos rescatar
     * @param cuotaPartes - La cantidad de cuota partes con que se desea operar
     * @param tipoSolicitud - Suscripcion o rescate
     * @return una solicitud de rescate o suscripcion
     * @throws ExcepcionFondosInsuficientes
     * @throws ExcepcionMonedaIncompatible
     */
    /*public Request crearSolicitudSegunCuotaPartes
    (CajaDeAhorro cajaDeAhorro, MutualFundAccountAdministrativeData participacionFondo, float cuotaPartes, Request.Type tipoSolicitud) throws ExcepcionFondosInsuficientes, ExcepcionMonedaIncompatible {

        validarNuevaSolicitud(cajaDeAhorro, participacionFondo, cuotaPartes, tipoSolicitud);

        Request solicitud =
                Request.crearSolicitud(new Date(), cuotaPartes, participacionFondo.getFund(), tipoSolicitud, "");

        AlmacenSolicitudes.getInstance().almacenarSolicitud(solicitud);

        return solicitud;
    }*/

    /*private void validarNuevaSolicitud(CajaDeAhorro cajaDeAhorro,
                                       MutualFundAccountAdministrativeData participacionFondo,
                                       float cuotaPartes, Request.Type tipoSolicitud) throws ExcepcionFondosInsuficientes, ExcepcionMonedaIncompatible {

        if(cajaDeAhorro.getCuenta().getMoneda() != participacionFondo.getMonedaDelFondo()){
            throw new ExcepcionMonedaIncompatible("La cuenta con la que desea operar no maneja la misma moneda que el FCI con el que esta tratando");
        }

        if(tipoSolicitud == Request.Type.RESCUE){
            validarNuevoRescate(participacionFondo, cuotaPartes);
        }
        else if(tipoSolicitud == Request.Type.SUBSCRIPTION){
            validarNuevaSuscripcion(participacionFondo, cuotaPartes, cajaDeAhorro);
        }
    }*/

    /*private void validarNuevoRescate(MutualFundAccountAdministrativeData participacionFondo, float cuotaPartesSolicitadas) throws ExcepcionFondosInsuficientes {

        float cuotaPartesYaSolicitadas = 0;
        ArrayList<Request> solicitudesNoProcesadas = AlmacenSolicitudes.getInstance().getSolicitudesSegunEstado(Request.Status.CREATED);

        for(Request solicitud : solicitudesNoProcesadas){
            if(solicitud.getFund().getName().equalsIgnoreCase(participacionFondo.getFund().getName())){
                cuotaPartesYaSolicitadas += solicitud.getAmount().getQuantity();
            }
        }

        if(participacionFondo.getCuenta().getCapital().getQuantity() - cuotaPartesYaSolicitadas < cuotaPartesSolicitadas){
            throw new ExcepcionFondosInsuficientes("La cantidad de cuota partes que desea rescatar es superior a la cantidad que usted posee");
        }
    }

    private void validarNuevaSuscripcion(MutualFundAccountAdministrativeData participacionFondo, float cuotaPartes, CajaDeAhorro cajaDeAhorro) throws ExcepcionFondosInsuficientes {
        float valorMonetarioCuotaPartes = participacionFondo.getFund().getValorCuotaParte().getQuantity() * cuotaPartes;

        if(cajaDeAhorro.getCuenta().getCapital().getQuantity() < valorMonetarioCuotaPartes){
            throw new ExcepcionFondosInsuficientes("No posee dinero suficiente en su caja de ahorro para efectuar la suscripcion al FCI");
        }
    }*/


    /**
     * Crea una solicitud de rescate o suscripcion calculando previamente cuantas cuota partes corresponden
     * a la operacion segun el monto de dinero pasado por parametro.
     * @param cajaDeAhorro - La caja de ahorro desde la cual extraeremos los fondos para suscribir o en la cual depositaremos los fondos del rescate
     * @param participacionFondo - La participacion en la cual deseamos invertir o de la cual deseamos rescatar
     * @param monto - El dinero que afecta a esta operacion
     * @param tipoSolicitud - Rescate o suscripcion
     * @return Una solicitud de suscripcion o rescate
     * @throws ExcepcionMonedaIncompatible
     * @throws ExcepcionFondosInsuficientes
     */
    /*public Request crearSolicitudSegunDinero(CajaDeAhorro cajaDeAhorro, MutualFundAccountAdministrativeData participacionFondo,
                                               Amount monto, Request.Type tipoSolicitud) throws ExcepcionMonedaIncompatible, ExcepcionFondosInsuficientes {

        if(monto.getMoneda() != participacionFondo.getMonedaDelFondo()){
            throw new ExcepcionMonedaIncompatible("La cantidad que de dinero con la que desea operar esta expresada en una moneda diferente a la moneda en la que opera el FCI");
        }

        float cuotaPartes = monto.getQuantity() / participacionFondo.getFund().getValorCuotaParte().getQuantity();

        return crearSolicitudSegunCuotaPartes(cajaDeAhorro, participacionFondo, cuotaPartes, tipoSolicitud);
    }*/
}
