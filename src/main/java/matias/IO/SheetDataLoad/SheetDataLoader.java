package matias.IO.SheetDataLoad;

import matias.IO.DB.Repositories.*;
import matias.IO.Logger;
import matias.conceptos.Bank;
import matias.conceptos.fondos.Holding;
import matias.conceptos.fondos.MutualFund;
import matias.conceptos.fondos.ShareQuotation;
import matias.utilidades.DateHandler;
import matias.utilidades.ExceptionsHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;

/**
 * Created by matias on 17/07/17.
 */
@Component
public class SheetDataLoader {
    private static final String dateFormat = "dd/MM/yyyy";
    private SheetDataFileReader sheetDataFileReader;

    @Autowired
    private RepositoryHolder holder;
    private String sheetURL;
    private Bank bank;

    public SheetDataLoader(){

    }

    public String getSheetURL() {
        return sheetURL;
    }

    public void setSheetURL(String sheetURL) {
        this.sheetURL = sheetURL;
    }

    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    public void loadDataIntoDatabase(){
        try {
            sheetDataFileReader = new SheetDataFileReader(getSheetURL());
        } catch (Exception e) {
            throw ExceptionsHandler.convertToRuntimeException(e);
        }

        ArrayList<SheetData> sheetDataList = sheetDataFileReader.readOldDataFile();

        createMutualFundsToDB(sheetDataList);

        // After creating the mutual funds in the DB we get
        // all of them from the database
        Iterable<MutualFund> mutualFunds = holder.getMutualFundRepository().findAll();

        ArrayList<Holding> holdings = new ArrayList();
        ArrayList<ShareQuotation> shareQuotations = new ArrayList<>();

        for(SheetData sheetData : sheetDataList){
            MutualFund mutualFund = null;
            for(MutualFund aMutualFund : mutualFunds){
                if(aMutualFund.getName().equalsIgnoreCase(sheetData.getFundName())){
                    mutualFund = aMutualFund;
                    break;
                }
            }

            Holding holding = createHoldingFromSheetData(sheetData, mutualFund);
            ShareQuotation shareQuotation = createShareQuotationFromSheetData(sheetData, mutualFund);

            if(holding != null){
                holdings.add(holding);
            }

            if(shareQuotation != null){
                shareQuotations.add(shareQuotation);
            }
        }

        holder.getHoldingRepository().save(holdings);
        holder.getShareQuotationRepository().save(shareQuotations);
    }

    private Holding createHoldingFromSheetData(SheetData sheetData, MutualFund mutualFund){
        Date date = extractDateFromSheetData(sheetData);
        if(date == null){
            return null;
        }

        Holding holding = new Holding();
        holding.setDate(date);
        float shares;
        try{
            shares = Float.parseFloat(sheetData.getShares());
            if(shares == 0){
                return null;
            }
            holding.setShares(shares);
        } catch(NumberFormatException nfe){
            return null;
        }
        holding.setMutualFund(mutualFund);

        return holding;
    }

    private ShareQuotation createShareQuotationFromSheetData(SheetData sheetData, MutualFund mutualFund){
        Date date = extractDateFromSheetData(sheetData);
        if(date == null){
            return null;
        }

        ShareQuotation shareQuotation = new ShareQuotation();
        shareQuotation.setDate(date);
        float quotation;
        try{
            quotation = Float.parseFloat(sheetData.getQuotation());
            if(quotation == 0){
                return null;
            }
            shareQuotation.setQuotation(quotation);
        } catch(NumberFormatException nfe){
            return null;
        }
        shareQuotation.setMutualFund(mutualFund);

        return shareQuotation;
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

    private void createMutualFundsToDB(ArrayList<SheetData> sheetDataList){
        // First we extract the name of the mutual funds and create them in the DB
        HashSet<String> mutualFundNames = new HashSet<>();

        for(SheetData sheetData : sheetDataList){
            if(!mutualFundNames.contains(sheetData.getFundName())){
                mutualFundNames.add(sheetData.getFundName());

                MutualFund mutualFund = new MutualFund();
                mutualFund.setName(sheetData.getFundName());
                mutualFund.setBank(getBank());
                String fundCurrencySymbol = sheetData.getFundCurrencySymbol();
                mutualFund.setCurrency(holder.getCurrencyRepository().findBySymbol(fundCurrencySymbol));

                holder.getMutualFundRepository().save(mutualFund);
            }
        }
    }
}
