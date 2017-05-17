package evolutionAnalysis;

import java.util.ArrayList;

/**
 * Created by Matías on 28/04/2017.
 */
public class AnalizadorBasico
{
    private ArrayList<MervalPosition> posicionesMerval;

    public AnalizadorBasico(ArrayList<MervalPosition> posicionesMerval){
        this.posicionesMerval = posicionesMerval;
        corregirDatosDeEntrada();
    }

    private void corregirDatosDeEntrada(){
        ArrayList<MervalPosition> posicionesPurgadas = new ArrayList<>();

        for(MervalPosition mervalPosition : posicionesMerval){
            if(poseeValoresConsistentes(mervalPosition)){
                corregirVariaciones(mervalPosition);
                posicionesPurgadas.add(mervalPosition);
            }
        }

        this.posicionesMerval = posicionesPurgadas;
    }

    private boolean poseeValoresConsistentes(MervalPosition mervalPosition){
        float apertura = mervalPosition.getOpening();
        float cierre = mervalPosition.getClosing();
        float minimo = mervalPosition.getMinimum();
        float maximo = mervalPosition.getMaximum();

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

    private void corregirVariaciones(MervalPosition mervalPosition){
        float diferenciaCierreApertura = mervalPosition.getClosing() - mervalPosition.getOpening();
        float variacionPorcentual = diferenciaCierreApertura * 100 / mervalPosition.getOpening();
        mervalPosition.setVariation(variacionPorcentual);
    }

    public MervalPosition getMayorVariacionPositiva(){

        MervalPosition mayorVariacion = posicionesMerval.get(0);

        for(MervalPosition mervalPosition : posicionesMerval){
            if(mervalPosition.getVariation() > mayorVariacion.getVariation()){
                mayorVariacion = mervalPosition;
            }
        }

        return mayorVariacion;
    }

    public MervalPosition getMayorVariacionNegativa(){
        MervalPosition mayorVariacion = posicionesMerval.get(0);

        for(MervalPosition mervalPosition : posicionesMerval){
            if(mervalPosition.getVariation() < mayorVariacion.getVariation()){
                mayorVariacion = mervalPosition;
            }
        }

        return mayorVariacion;
    }
}
