package simulacion.simuladores;

import IO.Logger;
import conceptos.Cliente;
import conceptos.cuentas.ParticipacionFondo;
import conceptos.excepciones.ExcepcionFondosInsuficientes;
import conceptos.excepciones.ExcepcionLimiteExtraccion;
import conceptos.fondos.Fondo;
import conceptos.fondos.VariacionFondo;

import java.util.ArrayList;

/**
 * Este simulador parte de un importe inicial y va agregando capital por dia segun la proporcion configurada.
 * Por ejemplo si el primer dia tenemos una inversion de 1000 y la proporcion es de 0.10, al segundo dia tendriamos que ingresar una cantidad
 * de 100 por lo que la inversion ascenderia a 1100.
 * Created by Matías on 22/04/2017.
 */
public class SimuladorConIngresosProporcionalesAInversionExistente extends Simulador{

    private Logger logger = Logger.getInstance();
    private float importeInicialInvertir;
    private float proporcionAgregar;
    private ParticipacionFondo participacion;
    private ArrayList<VariacionFondo> variaciones;

    public SimuladorConIngresosProporcionalesAInversionExistente(
            Fondo fondo, Cliente cliente, float importeInicialInvertir, float proporcionAgregar){

        super(fondo, cliente);
        this.importeInicialInvertir = importeInicialInvertir;
        this.proporcionAgregar = proporcionAgregar;
    }

    @Override
    public void simular() {
        try {
            crearEstadoInicial();
        } catch (Exception e){
            logger.log("No se pudo create estado inicial: " + e.getMessage());
            return;
        }

        for(int i = 0; i < variaciones.size(); i++){

        }
    }

    private void hacerProximoMovimiento(){
        float valorQueDeberiaInvertir = participacion.getValorActualInversion().getCantidad() * this.proporcionAgregar;
        if(valorQueDeberiaInvertir < fondo.getInversionMinima()){
            valorQueDeberiaInvertir = fondo.getInversionMinima();
        }
    }

    private void crearEstadoInicial() throws ExcepcionFondosInsuficientes, ExcepcionLimiteExtraccion {
        /*this.participacion = cliente.getCuentaCliente().getCuentaFondos().crearParticipacionParaFondo(fondo);
        cliente.getCajaAhorroPesos().extraer(importeInicialInvertir);

        float cuotaPartesIniciales = importeInicialInvertir / participacion.getFund().getValorCuotaParte().getCantidad();
        this.participacion.depositarCuotaPartes(cuotaPartesIniciales);

        this.variaciones = fondo.getEvolucion().getVariacionesOrdenasPorFecha();
        this.controladorTiempo.setFechaActual(variaciones.get(0).getFecha());*/
    }
}
