package conceptos.cuentas;

import conceptos.Moneda;
import utilidades.ManejadorCadenas;

/**
 *
 * @author Matías
 */
public class CuentaBancaria extends CuentaAdministrativa{

    private CajaDeAhorro cajaDeAhorroPesos;
    private CajaDeAhorro cajaDeAhorroDolares;

    private String sufijoDolares = "DOLARES";
    private String sufijoPesos = "PESOS";
    private String separador = "-";
    
    public CuentaBancaria(String idCuentaBancaria){
        super(idCuentaBancaria);
        this.cajaDeAhorroPesos = crearCajaAhorro(Moneda.Tipo.PESO);
        this.cajaDeAhorroDolares = crearCajaAhorro(Moneda.Tipo.DOLAR);
    }

    public CajaDeAhorro getCajaDeAhorroPesos() {
        return cajaDeAhorroPesos;
    }
    public CajaDeAhorro getCajaDeAhorroDolares() {
        return cajaDeAhorroDolares;
    }

    private CajaDeAhorro crearCajaAhorro(Moneda.Tipo moneda){
        String sufijoMoneda;

        if(moneda == Moneda.Tipo.PESO){
            sufijoMoneda = sufijoPesos;
        }
        else{
            sufijoMoneda = sufijoDolares;
        }

        String idCuenta = ManejadorCadenas.combinarCadenas(getIdCuenta(), sufijoMoneda, separador);

        CajaDeAhorro cajaDeAhorro = new CajaDeAhorro(idCuenta, moneda);

        return cajaDeAhorro;
    }

}
