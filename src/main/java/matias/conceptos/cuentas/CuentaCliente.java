package matias.conceptos.cuentas;

import matias.utilidades.StringHelper;

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
                StringHelper.mixStrings(separador, getIdCuenta(), sufijoCuentaBancaria);

        this.cuentaBancaria = new CuentaBancaria(idCuentaBancaria);
    }

    private void crearCuentaFondos(){
        String idCuentaFondos =
                StringHelper.mixStrings(separador, getIdCuenta(), sufijoCuentaFondos);

        this.cuentaFondos = new CuentaFondos(idCuentaFondos);
    }

    public CuentaBancaria getCuentaBancaria() {
        return cuentaBancaria;
    }

    public CuentaFondos getCuentaFondos() {
        return cuentaFondos;
    }
}
