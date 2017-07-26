package matias.IO.SheetDataLoad.secondApproach;

import matias.IO.DB.Repositories.RepositoryHolder;
import matias.IO.Logger;
import matias.IO.SheetDataLoad.SheetData;
import matias.IO.SheetDataLoad.SheetDataFileReader;
import matias.conceptos.fondos.Holding;
import matias.conceptos.investment.InvestmentConcept;
import matias.conceptos.investment.InvestmentConceptOwner;
import matias.conceptos.investment.Quotation;
import matias.utilidades.DateHandler;
import matias.utilidades.ExceptionsHandler;
import matias.utilidades.collections.CollectionFilter;
import matias.utilidades.collections.CollectionFilterUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.*;

/**
 * Created by matias on 25/07/17.
 */
@Component
public class SheetDataLoader {
    private static final String dateFormat = "dd/MM/yyyy";

    @Autowired
    private RepositoryHolder repositoryHolder;
    private String sheetURL;
    private InvestmentConceptOwner investmentConceptOwner;

    public void loadDataIntoDatabase(){
        ArrayList<SheetData> sheetDataList = extractDataFromSheet(getSheetURL());

        extractAndSaveInvestmentConcepts(sheetDataList);

        // After creating the mutual funds in the DB we get
        // all of them from the database
        HashMap<String, InvestmentConcept> investmentConcepts = getInvestmentConceptsFromDB();

        ArrayList<Holding> holdings = extractHoldingsFromSheetData(sheetDataList, investmentConcepts);
        ArrayList<Quotation> quotations = extractQuotationsFromSheetData(sheetDataList, investmentConcepts);

        holdings = cleanHoldings(holdings);
        quotations = cleanQuotations(quotations);

        HashMap<String, ArrayList<Quotation>> quotationsMap = organizeQuotationsPerInvestmentConcept(quotations, investmentConcepts);
        mixQuotations(quotationsMap);

        repositoryHolder.getRepositoriesHolder_investment().getHoldingRepository().save(holdings);
        repositoryHolder.getRepositoriesHolder_investment().getQuotationRepository().save(quotations);
    }

    private ArrayList<Holding> cleanHoldings(ArrayList<Holding> holdings){
        ArrayList<Holding> filteredHoldings = CollectionFilterUtility.getFilteredCollection(
                holdings, new CollectionFilter<Holding>(){
                    @Override
                    public boolean passes(Holding holding) {
                        return holding.getDate() != null;
                    }
                });

        return filteredHoldings;
    }

    private ArrayList<Quotation> cleanQuotations(ArrayList<Quotation> quotations){
        ArrayList<Quotation> filteredQuotations = CollectionFilterUtility.getFilteredCollection(
                quotations, new CollectionFilter<Quotation>() {
                    @Override
                    public boolean passes(Quotation quotation) {
                        return quotation.getDate() != null;
                    }
                }
        );

        return filteredQuotations;
    }

    private HashMap<String, ArrayList<Quotation>> mixQuotations(HashMap<String, ArrayList<Quotation>> quotations){
        sortQuotationByDateDescending(quotations);

        for(String key : quotations.keySet()) {
            ArrayList<Quotation> quotationsList = quotations.get(key);

            for(int i = 0; i < quotationsList.size() - 1; i++){
                Quotation firstQuotation = quotationsList.get(i);
                Quotation secondQuotation = quotationsList.get(i + 1);

                firstQuotation.setOpening(secondQuotation.getClosing());
            }
        }

        return quotations;
    }

    private HashMap<String, ArrayList<Quotation>> sortQuotationByDateDescending(HashMap<String, ArrayList<Quotation>> quotations){
        for(String key : quotations.keySet()){
            ArrayList<Quotation> quotationsList = quotations.get(key);

            Collections.sort(quotationsList, new Comparator<Quotation>() {
                @Override
                public int compare(Quotation t, Quotation t1) {
                    if(t.getDate().after(t1.getDate())){
                        return -1;
                    } else if(t.getDate().before(t1.getDate())){
                        return 1;
                    } else{
                        return 0;
                    }
                }
            });
        }

        return quotations;
    }

    private HashMap<String, ArrayList<Quotation>> organizeQuotationsPerInvestmentConcept(ArrayList<Quotation> quotations, HashMap<String, InvestmentConcept> investmentConcepts){
        HashMap<String, ArrayList<Quotation>> quotationsPerConcept = new HashMap<>();

        // We initialize the map with a different arrayList for each investment concept
        for(String conceptName : investmentConcepts.keySet()){
            quotationsPerConcept.put(conceptName, new ArrayList<>());
        }

        for(Quotation quotation : quotations){
            quotationsPerConcept.get(quotation.getInvestmentConcept().getName()).add(quotation);
        }

        return quotationsPerConcept;
    }

    private Date extractDateFromSheetData(SheetData sheetData){
        try{
            Date date = DateHandler.parseDate(dateFormat, sheetData.getDate());
            return date;
        } catch(ParseException pe){
            Logger.getInstance().error(pe.getMessage());
            return null;
        }
    }

    private ArrayList<Holding> extractHoldingsFromSheetData(ArrayList<SheetData> sheetDataList, HashMap<String, InvestmentConcept> investmentConcepts){
        ArrayList<Holding> holdings = new ArrayList<>();

        for(SheetData sheetData : sheetDataList){
            Holding holding = new Holding();
            holding.setInvestmentConcept(investmentConcepts.get(sheetData.getInvestmentConceptName()));
            holding.setDate(extractDateFromSheetData(sheetData));
            try{
                holding.setAmount(Float.parseFloat(sheetData.getHoldings()));
            } catch(NumberFormatException nfe){
                ExceptionsHandler.logException(nfe);
            }

            holdings.add(holding);
        }

        return holdings;
    }

    private ArrayList<Quotation> extractQuotationsFromSheetData(ArrayList<SheetData> sheetDataList, HashMap<String, InvestmentConcept> investmentConcepts){
        ArrayList<Quotation> quotations = new ArrayList<>();

        for(SheetData sheetData : sheetDataList){
            Quotation quotation = new Quotation();
            quotation.setDate(extractDateFromSheetData(sheetData));
            quotation.setInvestmentConcept(investmentConcepts.get(sheetData.getInvestmentConceptName()));

            try{
                quotation.setClosing(Float.parseFloat(sheetData.getQuotation()));
            } catch(NumberFormatException nfe){
                ExceptionsHandler.logException(nfe);
            }

            quotations.add(quotation);
        }

        return quotations;
    }

    private HashMap<String, InvestmentConcept> getInvestmentConceptsFromDB(){
        Iterable<InvestmentConcept> investmentConcepts =
                repositoryHolder.getRepositoriesHolder_investment().
                        getInvestmentConceptRepository().findAll();

        HashMap<String, InvestmentConcept> map = new HashMap<>();

        for(InvestmentConcept investmentConcept : investmentConcepts){
            map.put(investmentConcept.getName(), investmentConcept);
        }

        return map;
    }

    private ArrayList<SheetData> extractDataFromSheet(String URL){
        try {
            SheetDataFileReader reader = new SheetDataFileReader(URL);
            return reader.readOldDataFile();
        } catch (Exception e) {
            throw ExceptionsHandler.convertToRuntimeException(e);
        }
    }

    private void extractAndSaveInvestmentConcepts(ArrayList<SheetData> sheetDataList){
        // First we extract the name of the mutual funds and create them in the DB
        HashSet<String> investmentConceptNames = new HashSet<>();

        for(SheetData sheetData : sheetDataList){
            if(!investmentConceptNames.contains(sheetData.getInvestmentConceptName())){
                investmentConceptNames.add(sheetData.getInvestmentConceptName());

                InvestmentConcept investmentConcept = new InvestmentConcept();
                investmentConcept.setName(sheetData.getInvestmentConceptName());
                investmentConcept.setInvestmentConceptOwner(getInvestmentConceptOwner());

                String currencySymbol = sheetData.getCurrencySymbol();
                investmentConcept.setCurrency(repositoryHolder.getCurrencyRepository().findBySymbol(currencySymbol));

                repositoryHolder.
                        getRepositoriesHolder_investment().
                        getInvestmentConceptRepository().save(investmentConcept);
            }
        }
    }

    public String getSheetURL() {
        return sheetURL;
    }

    public void setSheetURL(String sheetURL) {
        this.sheetURL = sheetURL;
    }

    public InvestmentConceptOwner getInvestmentConceptOwner() {
        return investmentConceptOwner;
    }

    public void setInvestmentConceptOwner(InvestmentConceptOwner investmentConceptOwner) {
        this.investmentConceptOwner = investmentConceptOwner;
    }
}
