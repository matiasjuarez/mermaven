package matias.navigation.santander.InformationExtraction;


import matias.navigation.santander.InformationExtraction.processing.HoldingInformationExtraction;
import matias.navigation.santander.InformationExtraction.processing.QuotationInformationExtraction;
import matias.navigation.santander.SantanderNavigation;

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

    public ArrayList<HoldingInformationExtraction> extractTenenciaInformation(){
        navigator.goToTenencias();
        return tenenciaInformationExtractor.extractTenenciaInformation(navigator.getWebDriver());
    }

    public ArrayList<QuotationInformationExtraction> extractCotizacionInformation(){
        navigator.goToCotizaciones();
        return cotizacionInformationExtractor.extractCotizacionInformation(navigator.getWebDriver());
    }
}
