package matias.conceptos;

/**
 * Created by Matías on 15/04/2017.
 */

import java.util.Date;

/**
 * Representa una operacion sobre una cuenta.
 * @author Matías
 */
public class Operacion {

    private final Date fechaCreacion;
    private final Date fechaAcreditacion;
    private final Monto monto;
    private boolean acreditado;
    private String descripcion;

    public Operacion(Date fechaCreacion, Monto monto){
        this(fechaCreacion, fechaCreacion, monto);
    }

    public Operacion(Date fechaCreacion, Monto monto, String descripcion){
        this(fechaCreacion, fechaCreacion, monto, descripcion);
    }

    public Operacion(Date fechaCreacion, Date fechaAcreditacion, Monto monto){
        this(fechaCreacion, fechaAcreditacion, monto, "");
    }

    public Operacion(Date fechaCreacion, Date fechaAcreditacion, Monto monto, String descripcion){
        this.fechaCreacion = fechaCreacion;
        this.fechaAcreditacion = fechaAcreditacion;
        this.monto = monto;
        this.descripcion = descripcion;
        this.acreditado = false;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public Monto getMonto() {
        return monto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFechaAcreditacion() {
        return fechaAcreditacion;
    }

    public boolean isAcreditado() {
        return acreditado;
    }

    public void setAcreditado(boolean acreditado) {
        this.acreditado = acreditado;
    }
}