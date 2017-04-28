package conceptos;

import conceptos.excepciones.ExcepcionMonedaIncompatible;

/**
 * Representa una cantidad junto con sus unidades.
 * @author Matías
 */
public class Monto {
    private float cantidad;
    private final Moneda.Tipo moneda;
    
    public Monto(Moneda.Tipo moneda){
        this(moneda, 0);
    }
    
    public Monto(Moneda.Tipo moneda, float cantidad){
        this.moneda = moneda;
        this.cantidad = cantidad;
    }
    
    public float getCantidad() {
        return cantidad;
    }

    public void setCantidad(float cantidad) {
        this.cantidad = cantidad;
    }
        
    public void agregar(float cantidad) {
        this.cantidad += Math.abs(cantidad);
    }
        
    public void quitar(float cantidad) {
        this.cantidad -= Math.abs(cantidad);
    }

    public Monto sumar(Monto otroMonto) throws ExcepcionMonedaIncompatible {
        validarTipoMonedacompatible(otroMonto);

        float valorNumerico = this.getCantidad() + otroMonto.getCantidad();

        Monto nuevoMonto = new Monto(this.getMoneda(), valorNumerico);

        return nuevoMonto;
    }

    public Monto restar(Monto otroMonto) throws ExcepcionMonedaIncompatible {
        validarTipoMonedacompatible(otroMonto);

        float valorNumerico = this.getCantidad() - otroMonto.getCantidad();

        Monto nuevoMonto = new Monto(this.getMoneda(), valorNumerico);

        return nuevoMonto;
    }

    public Moneda.Tipo getMoneda() {
        return moneda;
    }
    
    public boolean esMenor(Monto otroMonto) throws ExcepcionMonedaIncompatible {
        validarTipoMonedacompatible(otroMonto);
        
        return this.getCantidad() < otroMonto.getCantidad();
    }
    
    public boolean esMayor(Monto otroMonto) throws ExcepcionMonedaIncompatible {
        validarTipoMonedacompatible(otroMonto);
        
        return this.getCantidad() > otroMonto.getCantidad();
    }
    
    public boolean esIgual(Monto otroMonto) throws ExcepcionMonedaIncompatible {
        validarTipoMonedacompatible(otroMonto);
        
        return this.getCantidad() == otroMonto.getCantidad();
    }

    public Monto crearCopia(){
        Monto copia = new Monto(this.getMoneda(), this.getCantidad());
        return copia;
    }
    
    public void validarTipoMonedacompatible(Monto otroMonto) throws ExcepcionMonedaIncompatible {
        if(this.moneda != otroMonto.getMoneda()){
            throw new ExcepcionMonedaIncompatible();
        }
    }
}
