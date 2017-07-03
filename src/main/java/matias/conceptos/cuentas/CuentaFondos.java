package matias.conceptos.cuentas;

import matias.conceptos.fondos.MutualFund;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

/**
 * Agrupa las participaciones en fondos comunes.
 * @author Matías
 */
public class CuentaFondos extends CuentaAdministrativa{
    
    private HashMap<String, ParticipacionFondo> participacionesFondo;
    
    public CuentaFondos(String idCuenta){
        super(idCuenta);
        this.participacionesFondo = new HashMap<>();
    }
    
    public CuentaAdministrativa obtenerParticipacionPorIdCuenta(String idCuenta){
        for(CuentaAdministrativa cuenta : getParticipaciones()) {
            if(cuenta.getIdCuenta().equals(idCuenta)){
                return cuenta;
            }
        }

        return null;
    }

    public CuentaAdministrativa obtenerParticipacionPorNombreFondo(String nombreFondo){
            for(CuentaAdministrativa cuenta : getParticipaciones()) {
                ParticipacionFondo participacion = (ParticipacionFondo) cuenta;

                if(participacion.getFondo().getName().equalsIgnoreCase(nombreFondo)){
                    return cuenta;
                }
            }

            return null;
    }

    public ArrayList<ParticipacionFondo> getParticipaciones(){
        Collection<ParticipacionFondo> collectionParticipaciones = participacionesFondo.values();
        
        return new ArrayList<>(collectionParticipaciones);
    }

    public ParticipacionFondo crearParticipacionParaFondo(MutualFund fondo){
        ParticipacionFondo participacionFondo = new ParticipacionFondo(getIdCuenta(), fondo);

        if(agregarParticipacion(participacionFondo)){
            return participacionFondo;
        }

        return null;
    }
    
    public boolean agregarParticipacion(ParticipacionFondo participacion){
        if(!participacionesFondo.containsKey(participacion.getFondo().getName())){
            participacionesFondo.put(participacion.getFondo().getName(), participacion);
            return true;
        }

        return false;
    }

    public boolean agregarParticipacion(CuentaAdministrativa participacion){
        ParticipacionFondo participacionCasteado = (ParticipacionFondo) participacion;
        return agregarParticipacion(participacionCasteado);
    }

    public boolean quitarParticipacion(String nombreFondo){
        CuentaAdministrativa participacion = participacionesFondo.remove(nombreFondo);

        return participacion != null;
    }
}
