/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matias.conceptos;

import matias.conceptos.excepciones.ExcepcionFondosInsuficientes;
import matias.conceptos.excepciones.ExcepcionLimiteExtraccion;

/**
 * Representa una cuenta que se puede operar para agregar y quitar dinero.
 * @author Matías
 */
public class Cuenta {
    private float capital;
    private float limiteExtraccion;
    private float limiteDeposito;
    private float limiteGiroDescubierto;
    private Currency.Type moneda;

    public Cuenta(Currency.Type moneda){
        this.capital = 0;
        this.limiteExtraccion = 0;
        this.limiteDeposito = 0;
        this.limiteGiroDescubierto = 0;
        this.moneda = moneda;
    }

    public Monto getLimiteExtraccion() {
        Monto montoLimiteExtraccion = new Monto(getMoneda(), this.limiteExtraccion);
        return montoLimiteExtraccion;
    }

    public void setLimiteExtraccion(float limiteExtraccion) {
        this.limiteExtraccion = limiteExtraccion;
    }

    public Monto getLimiteDeposito() {
        Monto montoLimiteDeposito = new Monto(getMoneda(), this.limiteDeposito);
        return montoLimiteDeposito;
    }

    public void setLimiteDeposito(float limiteDeposito) {
        this.limiteDeposito = limiteDeposito;
    }

    public Monto getLimiteGiroDescubierto() {
        Monto montoLimiteGiroDescubierto = new Monto(getMoneda(), this.limiteGiroDescubierto);
        return montoLimiteGiroDescubierto;
    }

    public void setLimiteGiroDescubierto(float limiteGiroDescubierto) {
        this.limiteGiroDescubierto = limiteGiroDescubierto;
    }

    public Monto getCapital() {
        return new Monto(moneda, capital);
    }

    public void setCapital(float capital) {
        this.capital = capital;
    }

    public Currency.Type getMoneda() {
        return moneda;
    }
    
    public void depositar(float montoDeposito) {
        this.capital += montoDeposito;
    }
    
    public void extraer(float montoExtraccion) throws
            ExcepcionLimiteExtraccion, ExcepcionFondosInsuficientes {

        validarExtraccion(montoExtraccion);
                
        this.capital -= montoExtraccion;
    }

    public void validarExtraccion(float montoExtraer) throws ExcepcionFondosInsuficientes, ExcepcionLimiteExtraccion {
        validarFondosSuficientesExtraccion(montoExtraer);
        validarLimiteExtraccion(montoExtraer);
    }

    private void validarFondosSuficientesExtraccion(float montoExtraer) throws ExcepcionFondosInsuficientes {
        float cantidadMaximaQuePuedeExtraer = getCapital().getCantidad() + limiteGiroDescubierto;

        if (montoExtraer > cantidadMaximaQuePuedeExtraer){
            throw new ExcepcionFondosInsuficientes();
        }
    }

    private void validarLimiteExtraccion(float montoExtraer) throws ExcepcionLimiteExtraccion {
        if(montoExtraer > this.limiteExtraccion) {
            throw new ExcepcionLimiteExtraccion();
        }
    }
}
