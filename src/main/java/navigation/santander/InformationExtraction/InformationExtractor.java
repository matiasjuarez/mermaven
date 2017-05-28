package navigation.santander.InformationExtraction;


import navigation.Cotizacion;
import navigation.Tenencia;
import navigation.santander.SantanderNavigation;

import java.util.ArrayList;

/**
 * Created by matias on 28/05/17.
 */
public class InformationExtractor {
    private CotizacionInformationExtractor cotizacionInformationExtractor;
    private TenenciaInformationExtractor tenenciaInformationExtractor;
    private SantanderNavigation navigator;

    public InformationExtractor(){
        cotizacionInformationExtractor = new CotizacionInformationExtractor();
        tenenciaInformationExtractor = new TenenciaInformationExtractor();
        navigator = new SantanderNavigation();
    }

    public ArrayList<Tenencia> extractTenenciaInformation(){
        navigator.goToTenencias();
        return tenenciaInformationExtractor.extractTenenciaInformation(navigator.getWebDriver());
    }

    public ArrayList<Cotizacion> extractCotizacionInformation(){
        navigator.goToCotizaciones();
        return cotizacionInformationExtractor.extractCotizacionInformation(navigator.getWebDriver());
    }
}
