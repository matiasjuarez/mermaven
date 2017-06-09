package dataAnalysis;

import java.util.ArrayList;

/**
 * Created by Matías on 28/04/2017.
 */
public class AnalizadorBasico
{
    private ArrayList<IndicatorData> posicionesMerval;

    public AnalizadorBasico(ArrayList<IndicatorData> posicionesMerval){
        this.posicionesMerval = posicionesMerval;
        corregirDatosDeEntrada();
    }

    private void corregirDatosDeEntrada(){
        ArrayList<IndicatorData> posicionesPurgadas = new ArrayList<>();

        for(IndicatorData indicatorData : posicionesMerval){
            if(poseeValoresConsistentes(indicatorData)){
                corregirVariaciones(indicatorData);
                posicionesPurgadas.add(indicatorData);
            }
        }

        this.posicionesMerval = posicionesPurgadas;
    }

    private boolean poseeValoresConsistentes(IndicatorData indicatorData){
        float apertura = indicatorData.getOpening();
        float cierre = indicatorData.getClosing();
        float minimo = indicatorData.getMinimum();
        float maximo = indicatorData.getMaximum();

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

    private void corregirVariaciones(IndicatorData indicatorData){
        float diferenciaCierreApertura = indicatorData.getClosing() - indicatorData.getOpening();
        float variacionPorcentual = diferenciaCierreApertura * 100 / indicatorData.getOpening();
        indicatorData.setVariation(variacionPorcentual);
    }

    public IndicatorData getMayorVariacionPositiva(){

        IndicatorData mayorVariacion = posicionesMerval.get(0);

        for(IndicatorData indicatorData : posicionesMerval){
            if(indicatorData.getVariation() > mayorVariacion.getVariation()){
                mayorVariacion = indicatorData;
            }
        }

        return mayorVariacion;
    }

    public IndicatorData getMayorVariacionNegativa(){
        IndicatorData mayorVariacion = posicionesMerval.get(0);

        for(IndicatorData indicatorData : posicionesMerval){
            if(indicatorData.getVariation() < mayorVariacion.getVariation()){
                mayorVariacion = indicatorData;
            }
        }

        return mayorVariacion;
    }
}
