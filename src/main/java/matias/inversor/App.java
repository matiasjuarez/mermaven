package matias.inversor;

import IO.LectorArchivoHistoricoMerval;
import IO.VariacionFondoDAO;
import evolutionAnalysis.AnalizadorBasico;
import evolutionAnalysis.MervalPosition;
import conceptos.fondos.VariacionFondo;
import simulacion.simuladores.ideasViejas.AnalizadorResultados;
import simulacion.simuladores.ideasViejas.PresentadorResultados;
import simulacion.simuladores.ideasViejas.ResultadoSimulacion;
import simulacion.simuladores.ideasViejas.SimuladorSuscripcionesBasadoEnEvolucionHistorica;

import java.util.ArrayList;

/**
 * Hello world!
 *
 */
public class App 
{
    private static PresentadorResultados presentador = new PresentadorResultados();

    public static void main(String[] args) {

        try {
          leerArchivoHistoricoMerval();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void leerArchivoHistoricoMerval() throws Exception {
        String url = "M:\\Matias\\Documentos\\Finanzas\\Inversiones\\Merval\\Merval1998.ods";

        LectorArchivoHistoricoMerval lector = new LectorArchivoHistoricoMerval();

        ArrayList<MervalPosition> posicionesMerval = lector.leerArchivoHistoricoMerval(url);

        AnalizadorBasico analizadorBasico = new AnalizadorBasico(posicionesMerval);

        System.out.println("Cantidad de entradas: " + posicionesMerval.size());
        System.out.println("Mayor positiva: " + analizadorBasico.getMayorVariacionPositiva());
        System.out.println("Mayor negativa: " + analizadorBasico.getMayorVariacionNegativa());
    }

    private static void simularSuscripcionPorcentualConstanteSegunVariacionHistorica(){
        String url = "M:\\Matias\\Documentos\\Inversiones\\Software\\FondosComunes\\src\\simulacion.simuladores.Datos\\Merval2011.txt";

        ArrayList<VariacionFondo> variaciones = VariacionFondoDAO.leerValoresHistoricosVariacion(url);

        SimuladorSuscripcionesBasadoEnEvolucionHistorica simulador =
                new SimuladorSuscripcionesBasadoEnEvolucionHistorica(variaciones, 130000, 1000);


        ArrayList<ResultadoSimulacion> resultados = simulador.simularConPorcentajeDeSuscripcionConstante(1, 100, 1);

        AnalizadorResultados analizador = new AnalizadorResultados(resultados);
        presentador.setAnalizadorResultados(analizador);

        //presentador.mostrarTodosLosResultadosCompletos();
        //presentador.mostrarLosNmejores(20);
        presentador.mostrarMejorYPeor();
    }
}
