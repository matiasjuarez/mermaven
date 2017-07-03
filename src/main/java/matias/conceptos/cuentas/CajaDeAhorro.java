package matias.conceptos.cuentas;

import matias.conceptos.Cuenta;
import matias.conceptos.Currency;
import matias.conceptos.excepciones.ExcepcionFondosInsuficientes;
import matias.conceptos.excepciones.ExcepcionLimiteExtraccion;

/**
 * Created by Matías on 13/04/2017.
 */
public class CajaDeAhorro extends CuentaAdministrativa {
    private Cuenta cuenta;

    public CajaDeAhorro(String idCuenta, Currency.Type typeMoneda){
        super(idCuenta);

        cuenta = new Cuenta(typeMoneda);
        cuenta.setLimiteGiroDescubierto(0);
    }

    public boolean esCajaDeAhorroPesos(){
        return cuenta.getMoneda() == Currency.Type.PESO;
    }

    public boolean esCajaDeAhorroDolares(){
        return cuenta.getMoneda() == Currency.Type.DOLAR;
    }

    public void depositar(float cantidad){
        this.cuenta.depositar(cantidad);
    }

    public void extraer(float cantidad) throws ExcepcionFondosInsuficientes, ExcepcionLimiteExtraccion {
        this.cuenta.extraer(cantidad);
    }
}
