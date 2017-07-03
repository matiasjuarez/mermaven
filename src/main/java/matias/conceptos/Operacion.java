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
    private final Amount amount;
    private boolean acreditado;
    private String descripcion;

    public Operacion(Date fechaCreacion, Amount amount){
        this(fechaCreacion, fechaCreacion, amount);
    }

    public Operacion(Date fechaCreacion, Amount amount, String descripcion){
        this(fechaCreacion, fechaCreacion, amount, descripcion);
    }

    public Operacion(Date fechaCreacion, Date fechaAcreditacion, Amount amount){
        this(fechaCreacion, fechaAcreditacion, amount, "");
    }

    public Operacion(Date fechaCreacion, Date fechaAcreditacion, Amount amount, String descripcion){
        this.fechaCreacion = fechaCreacion;
        this.fechaAcreditacion = fechaAcreditacion;
        this.amount = amount;
        this.descripcion = descripcion;
        this.acreditado = false;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public Amount getAmount() {
        return amount;
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