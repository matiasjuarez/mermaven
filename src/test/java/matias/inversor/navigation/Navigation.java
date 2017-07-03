package matias.inversor.navigation;

import matias.navigation.santander.InformationExtraction.processing.HoldingInformationExtraction;
import matias.navigation.santander.InformationExtraction.processing.QuotationInformationExtraction;
import matias.navigation.macro.MacroNavigation;
import matias.navigation.santander.InformationExtraction.InformationExtractor;
import matias.navigation.santander.SantanderNavigation;
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
        ArrayList<HoldingInformationExtraction> holdingInformationExtractions = informationExtractor.extractTenenciaInformation();
        System.out.println("holdingInformationExtractions: " + holdingInformationExtractions.size());

        ArrayList<QuotationInformationExtraction> cotizaciones = informationExtractor.extractCotizacionInformation();
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
