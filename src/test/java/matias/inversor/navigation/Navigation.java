package matias.inversor.navigation;

import navigation.Cotizacion;
import navigation.Tenencia;
import navigation.macro.MacroNavigation;
import navigation.santander.InformationExtraction.CotizacionInformationExtractor;
import navigation.santander.InformationExtraction.InformationExtractor;
import navigation.santander.InformationExtraction.TenenciaInformationExtractor;
import navigation.santander.SantanderNavigation;
import org.junit.Test;

import java.util.ArrayList;

/**
 * Created by matias on 21/05/17.
 */
public class Navigation {

    @Test
    public void testNavigation(){

        testSantanderInformationExtractor();
    }

    private void testSantanderInformationExtractor(){
        InformationExtractor informationExtractor = new InformationExtractor();
        ArrayList<Tenencia> tenencias = informationExtractor.extractTenenciaInformation();
        System.out.println("tenencias: " + tenencias.size());

        ArrayList<Cotizacion> cotizaciones = informationExtractor.extractCotizacionInformation();
        System.out.println("Cotizaciones: " + cotizaciones.size());
    }

    private void testSantanderNavigation(){
        SantanderNavigation santanderNavigation = new SantanderNavigation();
        santanderNavigation.goToCotizaciones();
        santanderNavigation.goToTenencias();
    }

    private void testMacroNavigation(){
        MacroNavigation macroNavigation = new MacroNavigation();
        macroNavigation.operate();
    }
}
