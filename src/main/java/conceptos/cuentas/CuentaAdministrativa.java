/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conceptos.cuentas;

import java.util.Date;

/**
 * Contiene informacion basica relacionada a una cuenta.
 * @author Matías
 */
public abstract class CuentaAdministrativa {
    
    private final String idCuenta;
    private boolean activa;
    private Date fechaCreacion;
    
    public CuentaAdministrativa(String idCuenta){
        this(idCuenta, new Date());
    }

    public CuentaAdministrativa(String idCuenta, Date fechaCreacion){
        this(idCuenta, fechaCreacion, false);
    }

    public CuentaAdministrativa(String idCuenta, Date fechaCreacion, boolean activa){
        this.idCuenta = idCuenta;
        this.fechaCreacion = fechaCreacion;
        this.activa = activa;
    }
    
    public String getIdCuenta(){
        return idCuenta;
    }

    public boolean isActiva() {
        return activa;
    }

    public void setActiva(boolean activa) {
        this.activa = activa;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }
}
