package analisisEvolucion;

import java.util.ArrayList;

/**
 * Created by Matías on 28/04/2017.
 */
public class AnalizadorBasico
{
    private ArrayList<PosicionMerval> posicionesMerval;

    public AnalizadorBasico(ArrayList<PosicionMerval> posicionesMerval){
        this.posicionesMerval = posicionesMerval;
        corregirDatosDeEntrada();
    }

    private void corregirDatosDeEntrada(){
        ArrayList<PosicionMerval> posicionesPurgadas = new ArrayList<>();

        for(PosicionMerval posicionMerval : posicionesMerval){
            if(poseeValoresConsistentes(posicionMerval)){
                corregirVariaciones(posicionMerval);
                posicionesPurgadas.add(posicionMerval);
            }
        }

        this.posicionesMerval = posicionesPurgadas;
    }

    private boolean poseeValoresConsistentes(PosicionMerval posicionMerval){
        float apertura = posicionMerval.getApertura();
        float cierre = posicionMerval.getCierre();
        float minimo = posicionMerval.getMinimo();
        float maximo = posicionMerval.getMaximo();

        if(apertura <= 0 || cierre <= 0 || maximo <= 0 || minimo <= 0){
            return false;
        }

        if(maximo < minimo || minimo > maximo){
            return false;
        }

        if(valorSuperaMinimoMaximo(cierre, minimo, maximo)){
            return false;
        }

        if(valorSuperaMinimoMaximo(apertura, minimo, maximo)){
            return false;
        }

        return true;
    }

    private boolean valorSuperaMinimoMaximo(float valor, float minimo, float maximo){
        if(valor < minimo || valor > maximo){
            return true;
        }

        return false;
    }

    private void corregirVariaciones(PosicionMerval posicionMerval){
        float diferenciaCierreApertura = posicionMerval.getCierre() - posicionMerval.getApertura();
        float variacionPorcentual = diferenciaCierreApertura * 100 / posicionMerval.getApertura();
        posicionMerval.setVariacionPorcentual(variacionPorcentual);
    }

    public PosicionMerval getMayorVariacionPositiva(){

        PosicionMerval mayorVariacion = posicionesMerval.get(0);

        for(PosicionMerval posicionMerval : posicionesMerval){
            if(posicionMerval.getVariacionPorcentual() > mayorVariacion.getVariacionPorcentual()){
                mayorVariacion = posicionMerval;
            }
        }

        return mayorVariacion;
    }

    public PosicionMerval getMayorVariacionNegativa(){
        PosicionMerval mayorVariacion = posicionesMerval.get(0);

        for(PosicionMerval posicionMerval : posicionesMerval){
            if(posicionMerval.getVariacionPorcentual() < mayorVariacion.getVariacionPorcentual()){
                mayorVariacion = posicionMerval;
            }
        }

        return mayorVariacion;
    }
}
