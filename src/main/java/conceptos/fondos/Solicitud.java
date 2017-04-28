package conceptos.fondos;

import conceptos.Moneda;
import conceptos.Monto;
import conceptos.Operacion;
import utilidades.ManejadorFechas;

import java.util.Date;

/**
 * Representa una operacion que se desea realizar sobre un FCI.
 * @author Matías
 */
public class Solicitud extends Operacion {
    
    public enum Tipo{
        RESCATE,
        SUSCRIPCION
    };

    public enum Estado{
        CREADA,
        PROCESADA,
        ACREDITADA
    }

    // El fondo sobre el que se realiza la operacion
    private final Fondo fondo;
    // El tipo de solicitud(rescate, suscripcion)
    private final Tipo tipo;
    // El estado actual de la solicitud que ira cambiando a medida que se procese
    private Estado estadoSolicitud;
    // Cual es el valor de la cuotaParte que se utiliza para esta operacion
    private Monto valorCuotaParteQueAplica;
    private float costoProporcionalDeRescateQueAplica;
    private float costoProporcionalDeSuscripcionQueAplica;
    
    /**
     * Crea una solicitud con la fecha en que se ejecuto dicha operacion, el monto y el FCI sobre 
     * el que dicha operacion se realizara.
     * @param fechaCreacion - Fecha de la operacion
     * @param cuotaPartes - La cantidad de cuota partes que intervienen en la operacion
     * @param descripcion - Una descripcion sobre la solicitud
     * @param tipo - Suscripcion o Rescate
     * @param fondo - El FCI sobre el que se aplica la operacion
     */
    
    public static Solicitud crearSolicitud
        (Date fechaCreacion, float cuotaPartes, Fondo fondo, Tipo tipo, String descripcion) {

        Date fechaAcreditacion = null;

        if(tipo == Tipo.RESCATE) {
            fechaAcreditacion = ManejadorFechas.sumarDiasFecha(fechaCreacion, fondo.getDiasParaAcreditarRescate());
        } else{
            fechaAcreditacion = ManejadorFechas.sumarDiasFecha(fechaCreacion, fondo.getDiasParaAcreditarSuscripcion());
        }

        Monto montoCuotaPartes = new Monto(Moneda.Tipo.CUOTA_PARTE, cuotaPartes);
        Solicitud solicitud =
                new Solicitud(fechaCreacion, fechaAcreditacion, montoCuotaPartes, fondo, tipo, descripcion);
        
        return solicitud;
    }
    
    private Solicitud(Date fechaCreacion, Date fechaAcreditacion, Monto monto, Fondo fondo, Tipo tipo, String descripcion){
        super(fechaCreacion, fechaAcreditacion, monto, descripcion);
        this.fondo = fondo;
        this.tipo = tipo;
        this.valorCuotaParteQueAplica = new Monto(fondo.getMoneda(), fondo.getValorCuotaParte());
        this.costoProporcionalDeRescateQueAplica = fondo.getCostoProporcionRescate();
        this.costoProporcionalDeSuscripcionQueAplica = fondo.getCostoProporcionSuscripcion();
        this.estadoSolicitud = Estado.CREADA;
    }

    /**
     * Calcula el valor monetario de la operacion basandose en la cantidad de cuota partes y el valor
     * de cuota parte que se esta utilizando para esta operacion.
     * @return un Monto expresado en la moneda del FCI
     */
    public Monto getMontoExpresadoEnDinero() {
        Monto cuotaPartes = super.getMonto();

        float resultado = valorCuotaParteQueAplica.getCantidad() * cuotaPartes.getCantidad();

        Monto montoResultado = new Monto(valorCuotaParteQueAplica.getMoneda(), resultado);

        return montoResultado;
    }
    
    public Fondo getFondo() {
        return fondo;
    }

    public Tipo getTipoSolicitud() {
        return tipo;
    }

    public Monto getValorCuotaParteQueAplica() {
        return valorCuotaParteQueAplica;
    }

    public void setValorCuotaParteQueAplica(Monto valorCuotaParteQueAplica) {
        this.valorCuotaParteQueAplica = valorCuotaParteQueAplica;
    }

    public float getCostoProporcionalDeRescateQueAplica() {
        return costoProporcionalDeRescateQueAplica;
    }

    public void setCostoProporcionalDeRescateQueAplica(float costoProporcionalDeRescateQueAplica) {
        this.costoProporcionalDeRescateQueAplica = costoProporcionalDeRescateQueAplica;
    }

    public float getCostoProporcionalDeSuscripcionQueAplica() {
        return costoProporcionalDeSuscripcionQueAplica;
    }

    public void setCostoProporcionalDeSuscripcionQueAplica(float costoProporcionalDeSuscripcionQueAplica) {
        this.costoProporcionalDeSuscripcionQueAplica = costoProporcionalDeSuscripcionQueAplica;
    }

    public Estado getEstadoSolicitud() {
        return estadoSolicitud;
    }

    public void setEstadoSolicitud(Estado estadoSolicitud) {
        this.estadoSolicitud = estadoSolicitud;
    }

    /**
     * Calcula el costo de la operacion segun los costos de operacion que rigen en el FCI.
     * @return un Monto que indica el costo de la operacion y esta expresado en cuota partes
     */
    public Monto getCostoOperacionExpresadoEnCuotaPartes(){
        float cuotaPartes = this.getMonto().getCantidad();
        float costoOperacion = 0;
        Monto montoCostoOperacion;

        if(this.tipo == Tipo.RESCATE){
            costoOperacion = cuotaPartes * this.costoProporcionalDeRescateQueAplica;
        }
        else if(this.tipo == Tipo.SUSCRIPCION){
            costoOperacion = cuotaPartes * this.costoProporcionalDeSuscripcionQueAplica;
        }

        montoCostoOperacion = new Monto(Moneda.Tipo.CUOTA_PARTE, costoOperacion);

        return montoCostoOperacion;
    }

    /**
     * Calcula el costo de la operacion segun los costos de operacion que rigen en el FCI.
     * @return un Monto que indica el costo de la operacion y esta expresado en la moneda del FCI
     */
    public Monto getCostoOperacionExpresadoEnDinero(){
        Monto costoEnCuotaPartes = getCostoOperacionExpresadoEnCuotaPartes();

        float resultado = costoEnCuotaPartes.getCantidad() * this.valorCuotaParteQueAplica.getCantidad();
        Monto montoResultado = new Monto(valorCuotaParteQueAplica.getMoneda(), resultado);

        return montoResultado;
    }
}
