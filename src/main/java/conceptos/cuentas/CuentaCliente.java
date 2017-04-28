package conceptos.cuentas;

import utilidades.ManejadorCadenas;

/**
 * Created by Matías on 14/04/2017.
 */
public class CuentaCliente extends CuentaAdministrativa{

    private CuentaBancaria cuentaBancaria;
    private CuentaFondos cuentaFondos;

    private String sufijoCuentaBancaria = "BANCARIA";
    private String sufijoCuentaFondos = "FONDOS";
    private String separador = "-";

    public CuentaCliente(String idCuenta){

        super(idCuenta);

        crearCuentaBancaria();
        crearCuentaFondos();
    }

    private void crearCuentaBancaria(){
        String idCuentaBancaria =
                ManejadorCadenas.combinarCadenas(getIdCuenta(), sufijoCuentaBancaria, separador);

        this.cuentaBancaria = new CuentaBancaria(idCuentaBancaria);
    }

    private void crearCuentaFondos(){
        String idCuentaFondos =
                ManejadorCadenas.combinarCadenas(getIdCuenta(), sufijoCuentaFondos, separador);

        this.cuentaFondos = new CuentaFondos(idCuentaFondos);
    }

    public CuentaBancaria getCuentaBancaria() {
        return cuentaBancaria;
    }

    public CuentaFondos getCuentaFondos() {
        return cuentaFondos;
    }
}
