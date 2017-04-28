package conceptos.cuentas;

import conceptos.Cuenta;
import conceptos.Moneda;
import conceptos.excepciones.ExcepcionFondosInsuficientes;
import conceptos.excepciones.ExcepcionLimiteExtraccion;

/**
 * Created by Matías on 13/04/2017.
 */
public class CajaDeAhorro extends CuentaAdministrativa {
    private Cuenta cuenta;

    public CajaDeAhorro(String idCuenta, Moneda.Tipo tipoMoneda){
        super(idCuenta);

        cuenta = new Cuenta(tipoMoneda);
        cuenta.setLimiteGiroDescubierto(0);
    }

    public boolean esCajaDeAhorroPesos(){
        return cuenta.getMoneda() == Moneda.Tipo.PESO;
    }

    public boolean esCajaDeAhorroDolares(){
        return cuenta.getMoneda() == Moneda.Tipo.DOLAR;
    }

    public void depositar(float cantidad){
        this.cuenta.depositar(cantidad);
    }

    public void extraer(float cantidad) throws ExcepcionFondosInsuficientes, ExcepcionLimiteExtraccion {
        this.cuenta.extraer(cantidad);
    }
}
