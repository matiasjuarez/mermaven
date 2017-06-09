package dataAnalysis.Analists;

import dataAnalysis.IndicatorData;
import dataAnalysis.IndicatorDataValidator;

import java.util.ArrayList;

/**
 * Created by matias on 09/06/17.
 */
public abstract class Analist {
    protected ArrayList<IndicatorData> indicatorDataList;

    public Analist(ArrayList<IndicatorData> indicatorDataList){
        if(indicatorDataList == null || indicatorDataList.isEmpty()){
            throw new IllegalArgumentException("The indicator data list is null or empty");
        }

        this.indicatorDataList = IndicatorDataValidator.removeInconsistentIndicatorData(indicatorDataList);

        if(this.indicatorDataList.size() == 0){
            throw new IllegalArgumentException("There are no valid indicatorData objects after removing those with inconsistent data");
        }
    }


}
