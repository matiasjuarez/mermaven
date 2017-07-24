package matias.dataAnalysis.IndicatorParser;

import matias.IO.Logger;
import matias.dataAnalysis.IndicatorData;
import matias.dataAnalysis.FileReader.RawIndicatorData;
import matias.utilidades.DateHandler;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by matias on 09/06/17.
 */
public class GoogleFinanceIndicatorParser {
    private static final String DATE_FORMAT = "d-MMM-yy";

    public static IndicatorData parseRawIndicator(RawIndicatorData rawIndicatorData){
        IndicatorData indicatorData = new IndicatorData();
        indicatorData.setDate(extractDate(rawIndicatorData));
        indicatorData.setClosing(parseNumber(rawIndicatorData.getClosing()));
        indicatorData.setOpening(parseNumber(rawIndicatorData.getOpening()));
        indicatorData.setMaximum(parseNumber(rawIndicatorData.getMaximum()));
        indicatorData.setMinimum(parseNumber(rawIndicatorData.getMinimum()));

        return indicatorData;
    }

    public static ArrayList<IndicatorData> parseRawIndicatorList(ArrayList<RawIndicatorData> rawIndicatorDataList){
        ArrayList<IndicatorData> indicatorDataList = new ArrayList<>();

        for(RawIndicatorData rawIndicatorData : rawIndicatorDataList){
            indicatorDataList.add(parseRawIndicator(rawIndicatorData));
        }

        return indicatorDataList;
    }

    private static Date extractDate(RawIndicatorData rawIndicatorData){
        String rawDate = rawIndicatorData.getDate();
        try {
            Date date = DateHandler.parseDate(DATE_FORMAT, rawDate);
            return date;
        } catch (ParseException e) {
            e.printStackTrace();
            Logger.getInstance().info("There was a problem while trying to parse this date: " + rawDate);
            return null;
        }
    }

    private static Float parseNumber(String number){
        try{
            return Float.parseFloat(number);
        }
        catch(Exception e){
            //e.printStackTrace();
            Logger.getInstance().info("A problem happened while trying to parse this number: " + number);
            return null;
        }
    }
}
