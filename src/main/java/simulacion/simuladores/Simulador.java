package simulacion.simuladores;

import conceptos.Cliente;
import conceptos.cuentas.CajaDeAhorro;
import conceptos.cuentas.CuentaBancaria;
import conceptos.fondos.Fondo;
import simulacion.controladores.ControladorTiempo;
import simulacion.controladores.SistemaControlSolicitudesFCI;
import conceptos.cuentas.ParticipacionFondo;

/**
 *
 * @author Matías
 */
public abstract class Simulador {
    protected Cliente cliente;
    protected Fondo fondo;
    protected ControladorTiempo controladorTiempo;
    protected SistemaControlSolicitudesFCI controladorSolicitudes;

    public Simulador(Fondo fondo, Cliente cliente){
        this.fondo = fondo;
        this.cliente = cliente;
        this.controladorTiempo = ControladorTiempo.getInstance();
        this.controladorSolicitudes = SistemaControlSolicitudesFCI.getInstance();
    }
    
   /* public void setearCapitalInicialDelUsuario(float pesos, float dolares){
        CuentaBancaria cuentaBancaria = cliente.getCuentaCliente().getCuentaBancaria();

        CajaDeAhorro cajaPesos = cuentaBancaria.getCajaDeAhorroPesos();
        CajaDeAhorro cajaDolares = cuentaBancaria.getCajaDeAhorroDolares();

        cajaPesos.getCuenta().setCapital(pesos);
        cajaDolares.getCuenta().setCapital(dolares);
    }
    
    public Cliente getUsuario(){
        return this.cliente;
    }
    
    public void mostrarConfiguracionSimulacion(){
        String str = "La simulacion se correra con los siguientes valores: \n";
        str += "Cliente: " + this.cliente.getNombre() + "\n";
        str += "Caja de ahorro pesos: $" + this.cliente.getCuentaCliente().getCuentaBancaria().getCajaDeAhorroPesos().getCuenta().getCapital() + "\n";
        str += "Caja de ahorro dolares: US$" + this.cliente.getCuentaCliente().getCuentaBancaria().getCajaDeAhorroDolares().getCuenta().getCapital() + "\n";
        str += "Fondos en los que participa: \n";
        
        for(ParticipacionFondo participacion : cliente.getCuentaCliente().getCuentaFondos().getParticipaciones()){
            str += participacion.getFondo() + "\n";
        }
        
        System.out.println(str);
    }*/
    
    public abstract void simular();
}
