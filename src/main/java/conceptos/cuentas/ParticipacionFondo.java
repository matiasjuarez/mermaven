package conceptos.cuentas;

import conceptos.Cuenta;
import conceptos.Moneda;
import conceptos.Monto;
import conceptos.excepciones.ExcepcionFondosInsuficientes;
import conceptos.excepciones.ExcepcionLimiteExtraccion;
import conceptos.fondos.Fondo;

/**
 * Representa una participacion en un FCI de una CuentaFondos.
 * @author Matías
 */
public class ParticipacionFondo extends CuentaAdministrativa{

    // El fondo en el que se participa
    private final Fondo fondo;
    // Una cuenta cuyos valores estan expresados en cuota partes
    private final Cuenta cuenta;

    // Lleva un seguimiento del dinero que el usuario invirtio independientemente de como varie el fondo
    private float dineroInvertido;
    
    public ParticipacionFondo(String idCuenta, Fondo fondo){
        super(idCuenta);
        this.fondo = fondo;
        this.cuenta = new Cuenta(Moneda.Tipo.CUOTA_PARTE);
        this.dineroInvertido = 0;
    }

    public Fondo getFondo() {
        return fondo;
    }

    public Moneda.Tipo getMonedaDelFondo(){
        return fondo.getMoneda();
    }

    public void depositarCuotaPartes(float cuotaPartes){
        float dinero = convertirCuotaPartesEnDinero(cuotaPartes);
        realizarOperacionDeposito(cuotaPartes, dinero);
    }

    public void depositarDinero(float dinero){
        float cuotaPartes = convertirDineroEnCuotaPartes(dinero);
        realizarOperacionDeposito(cuotaPartes, dinero);
    }

    private void realizarOperacionDeposito(float cuotaPartes, float dinero){
        cuenta.depositar(cuotaPartes);
        dineroInvertido += dinero;
    }

    public void extraerCuotaPartes(float cuotaPartes) throws ExcepcionFondosInsuficientes, ExcepcionLimiteExtraccion {
        float dinero = convertirCuotaPartesEnDinero(cuotaPartes);
        realizarOperacionExtraccion(cuotaPartes, dinero);
    }

    public void extraerDinero(float dinero) throws ExcepcionFondosInsuficientes, ExcepcionLimiteExtraccion {
        float cuotaPartes = convertirDineroEnCuotaPartes(dinero);
        realizarOperacionExtraccion(cuotaPartes, dinero);
    }

    private void realizarOperacionExtraccion(float cuotaPartes, float dinero) throws ExcepcionFondosInsuficientes, ExcepcionLimiteExtraccion {
        this.cuenta.validarExtraccion(cuotaPartes);

        float cuotaPartesPoseidas = this.cuenta.getCapital().getCantidad();
        float proporcionExtraida = cuotaPartes / cuotaPartesPoseidas;

        float dineroInvertidoPostExtraccion = this.dineroInvertido - this.dineroInvertido / proporcionExtraida;
        this.dineroInvertido = dineroInvertidoPostExtraccion;

        this.cuenta.extraer(cuotaPartes);
    }

    private float convertirDineroEnCuotaPartes(float dinero){
        float valorCuotaParte = this.fondo.getValorCuotaParte();
        float cuotaPartes = dinero / valorCuotaParte;
        return cuotaPartes;
    }

    private float convertirCuotaPartesEnDinero(float cuotaPartes){
        float valorCuotaParte = this.fondo.getValorCuotaParte();
        float dinero = valorCuotaParte * cuotaPartes;
        return dinero;
    }

    /**
     * Devuelve cuanto se ha invertido en el fondo hasta el momento sin prestar atencion a como ha
     * variado el valor de la cuota parte.
     * @return un objeto Monto que contiene el valor de la inversion y la moneda en que esta expresada la misma
     */
    public Monto getInversionRealizada(){
        return new Monto(getMonedaDelFondo(), this.dineroInvertido);
    }

    /**
     * Devuelve cuanto vale la inversion realizada actualmente. Esto se calcula multiplicando la cantidad de cuota partes
     * que el cliente posee y el valor actual de la cuota parte del fondo.
     * @return un objeto Monto que contiene el valor actual de la inversion y la moneda en que esta expresada la misma
     */
    public Monto getValorActualInversion(){
        float cuotaPartes = cuenta.getCapital().getCantidad();
        float valorInversion = convertirCuotaPartesEnDinero(cuotaPartes);

        return new Monto(getMonedaDelFondo(), valorInversion);
    }
}
