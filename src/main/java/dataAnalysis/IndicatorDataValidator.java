package dataAnalysis;

import java.util.ArrayList;

/**
 * Created by matias on 09/06/17.
 */
public class IndicatorDataValidator {

    public static boolean hasConsistentValues(IndicatorData indicatorData){
        Float opening = indicatorData.getOpening();
        Float closing = indicatorData.getClosing();
        Float minimum = indicatorData.getMinimum();
        Float maximum = indicatorData.getMaximum();

        // We validate for null values
        if(opening == null || closing == null || minimum == null || maximum == null){
            return false;
        }

        // We validate that everything is positive
        if(opening <= 0 || closing <= 0 || maximum <= 0 || minimum <= 0){
            return false;
        }

        // We validate that minimum and maximum are not inverted
        if(maximum < minimum){
            return false;
        }

        // We validate that the opening value is between minimum and maximum
        if(opening > maximum || opening < minimum){
            return false;
        }

        // We validate that the closing value is between minimum and maximum
        if(closing > maximum || closing < minimum){
            return false;
        }

        return true;
    }

    public static ArrayList<IndicatorData> removeInconsistentIndicatorData(ArrayList<IndicatorData> indicatorDataList){
        ArrayList<IndicatorData> cleanIndicatorDataList = new ArrayList<>();

        for(IndicatorData indicatorData : indicatorDataList){
            if(hasConsistentValues(indicatorData)){
                cleanIndicatorDataList.add(indicatorData);
            }
        }

        return cleanIndicatorDataList;
    }
}
