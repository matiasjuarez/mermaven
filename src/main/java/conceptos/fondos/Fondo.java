/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conceptos.fondos;

import conceptos.Moneda;

import java.util.ArrayList;

/**
 * Representa un fondo comun de inversion.
 * @author Matías
 */
public class Fondo {
    private HistoricoEvolucionFondo evolucion;
    private float costoProporcionSuscripcion;
    private float costoProporcionRescate;
    private float valorCuotaParte;
    private float limiteExtraccion;
    private float inversionMinima;
    private int diasParaAcreditarRescate;
    private int diasParaAcreditarSuscripcion;
    private Moneda.Tipo moneda;
    private String nombre;
    private ArrayList<Solicitud> suscripcionesPendientes;
    private ArrayList<Solicitud> rescatesPendientes;

    public Fondo(String nombre, Moneda.Tipo moneda){
        this(nombre, moneda, 0, 0);
    }
    
    public Fondo(String nombre, Moneda.Tipo moneda,
            float costoProporcionSuscripcion, float costoProporcionRescate){
        
        this(nombre, moneda, costoProporcionSuscripcion, costoProporcionRescate, 0, 0, 0);
    }
    
    public Fondo(String nombre, Moneda.Tipo moneda, float costoProporcionSuscripcion, float costoProporcionRescate,
                 float limiteExtraccion, int diasParaAcreditarRescate, int diasParaAcreditarSuscripcion){
        this.costoProporcionRescate = costoProporcionRescate;
        this.costoProporcionSuscripcion = costoProporcionSuscripcion;
        this.limiteExtraccion = limiteExtraccion;
        this.nombre = nombre;
        this.diasParaAcreditarRescate = diasParaAcreditarRescate;
        this.diasParaAcreditarSuscripcion = diasParaAcreditarSuscripcion;
        this.moneda = moneda;
        this.evolucion = new HistoricoEvolucionFondo();
        this.suscripcionesPendientes = new ArrayList<>();
        this.rescatesPendientes = new ArrayList<>();
        this.valorCuotaParte = 1;
        this.inversionMinima = 1000;
    }
    
    public HistoricoEvolucionFondo getEvolucion() {
        return evolucion;
    }

    public void setEvolucion(HistoricoEvolucionFondo evolucion) {
        this.evolucion = evolucion;
    }

    public float getCostoProporcionSuscripcion() {
        return costoProporcionSuscripcion;
    }

    public void setCostoProporcionSuscripcion(float costoPorcentualSuscripcion) {
        this.costoProporcionSuscripcion = costoPorcentualSuscripcion;
    }

    public float getCostoProporcionRescate() {
        return costoProporcionRescate;
    }

    public void setCostoProporcionRescate(float costoPorcentualRescate) {
        this.costoProporcionRescate = costoPorcentualRescate;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDiasParaAcreditarRescate() {
        return diasParaAcreditarRescate;
    }

    public void setDiasParaAcreditarRescate(int diasParaAcreditarRescate) {
        this.diasParaAcreditarRescate = diasParaAcreditarRescate;
    }

    public int getDiasParaAcreditarSuscripcion() {
        return diasParaAcreditarSuscripcion;
    }

    public void setDiasParaAcreditarSuscripcion(int diasParaAcreditarSuscripcion) {
        this.diasParaAcreditarSuscripcion = diasParaAcreditarSuscripcion;
    }

    public Moneda.Tipo getMoneda() {
        return moneda;
    }
    
    public void agregarNuevaSolicitudRescate(Solicitud nuevoRescate){
        rescatesPendientes.add(nuevoRescate);
    }
    
    public void agregarNuevaSolicitudSuscripcion(Solicitud nuevaSuscripcion){
        suscripcionesPendientes.add(nuevaSuscripcion);
    }

    public ArrayList<Solicitud> getSuscripcionesPendientes() {
        return suscripcionesPendientes;
    }

    public ArrayList<Solicitud> getRescatesPendientes() {
        return rescatesPendientes;
    }

    public float getLimiteExtraccion() {
        return limiteExtraccion;
    }

    public void setLimiteExtraccion(float limiteExtraccion) {
        this.limiteExtraccion = limiteExtraccion;
    }

    public float getInversionMinima() {
        return inversionMinima;
    }

    public void setInversionMinima(float inversionMinima) {
        this.inversionMinima = inversionMinima;
    }

    public float getValorCuotaParte() {
        return valorCuotaParte;
    }

    public void setValorCuotaParte(float valorCuotaParte) {
        this.valorCuotaParte = valorCuotaParte;
    }
    
    public void recalcularValorCuotaParteSegunVariacionProporcional(float variacionProporcional){
        float valorVariacion = valorCuotaParte * variacionProporcional;
        valorCuotaParte = valorCuotaParte + valorVariacion;
    }
    
    @Override
    public String toString(){
        String str = this.getNombre() + "\n";
        str += "Suscripcion: " + (this.getCostoProporcionSuscripcion() * 100.0) + "%\n";
        str += "Rescate: " + (this.getCostoProporcionRescate() * 100.0) + "%\n";
        str += "Dias para acreditar suscripcion: " + this.getDiasParaAcreditarSuscripcion() + "\n";
        str += "Dias para acreditar rescate: " + this.getDiasParaAcreditarRescate() + "\n";
        return str;
    }
}
