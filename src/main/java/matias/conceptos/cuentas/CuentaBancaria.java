package matias.conceptos.cuentas;

import matias.conceptos.Currency;
import matias.utilidades.StringHelper;

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
        this.cajaDeAhorroPesos = crearCajaAhorro(Currency.Type.PESO);
        this.cajaDeAhorroDolares = crearCajaAhorro(Currency.Type.DOLAR);
    }

    public CajaDeAhorro getCajaDeAhorroPesos() {
        return cajaDeAhorroPesos;
    }
    public CajaDeAhorro getCajaDeAhorroDolares() {
        return cajaDeAhorroDolares;
    }

    private CajaDeAhorro crearCajaAhorro(Currency.Type moneda){
        String sufijoMoneda;

        if(moneda == Currency.Type.PESO){
            sufijoMoneda = sufijoPesos;
        }
        else{
            sufijoMoneda = sufijoDolares;
        }

        String idCuenta = StringHelper.mixStrings(separador, getIdCuenta(), sufijoMoneda);

        CajaDeAhorro cajaDeAhorro = new CajaDeAhorro(idCuenta, moneda);

        return cajaDeAhorro;
    }

}
