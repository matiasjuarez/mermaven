package dataAnalysis;

import java.util.ArrayList;

/**
 * Created by Matías on 28/04/2017.
 */
public class AnalizadorBasico
{
    private ArrayList<Indicator> posicionesMerval;

    public AnalizadorBasico(ArrayList<Indicator> posicionesMerval){
        this.posicionesMerval = posicionesMerval;
        corregirDatosDeEntrada();
    }

    private void corregirDatosDeEntrada(){
        ArrayList<Indicator> posicionesPurgadas = new ArrayList<>();

        for(Indicator indicator : posicionesMerval){
            if(poseeValoresConsistentes(indicator)){
                corregirVariaciones(indicator);
                posicionesPurgadas.add(indicator);
            }
        }

        this.posicionesMerval = posicionesPurgadas;
    }

    private boolean poseeValoresConsistentes(Indicator indicator){
        float apertura = indicator.getOpening();
        float cierre = indicator.getClosing();
        float minimo = indicator.getMinimum();
        float maximo = indicator.getMaximum();

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

    private void corregirVariaciones(Indicator indicator){
        float diferenciaCierreApertura = indicator.getClosing() - indicator.getOpening();
        float variacionPorcentual = diferenciaCierreApertura * 100 / indicator.getOpening();
        indicator.setVariation(variacionPorcentual);
    }

    public Indicator getMayorVariacionPositiva(){

        Indicator mayorVariacion = posicionesMerval.get(0);

        for(Indicator indicator : posicionesMerval){
            if(indicator.getVariation() > mayorVariacion.getVariation()){
                mayorVariacion = indicator;
            }
        }

        return mayorVariacion;
    }

    public Indicator getMayorVariacionNegativa(){
        Indicator mayorVariacion = posicionesMerval.get(0);

        for(Indicator indicator : posicionesMerval){
            if(indicator.getVariation() < mayorVariacion.getVariation()){
                mayorVariacion = indicator;
            }
        }

        return mayorVariacion;
    }
}
