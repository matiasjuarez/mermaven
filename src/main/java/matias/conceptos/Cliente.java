package matias.conceptos;

import matias.conceptos.cuentas.CajaDeAhorro;
import matias.conceptos.cuentas.CuentaCliente;

/**
 * Representa un cliente de un banco
 * @author Matías
 */
public class Cliente {
    private String nombre;
    private CuentaCliente cuenta;
    
    public Cliente(String nombre, String idCuenta){
        this.nombre = nombre;
        this.cuenta = new CuentaCliente(idCuenta);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public CuentaCliente getCuentaCliente() {
        return cuenta;
    }

    public CajaDeAhorro getCajaAhorroPesos(){
        return getCuentaCliente().getCuentaBancaria().getCajaDeAhorroPesos();
    }

    public CajaDeAhorro getCajaAhorroDolares(){
        return getCuentaCliente().getCuentaBancaria().getCajaDeAhorroDolares();
    }
}
