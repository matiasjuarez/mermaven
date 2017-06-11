package dataAnalysis.Output;

import dataAnalysis.Analists.BasicAnalyst;
import dataAnalysis.IndicatorData;

import java.util.ArrayList;

/**
 * Created by matias on 10/06/17.
 */
public class Summarizer {
    private ArrayList<IndicatorData> indicatorDataList;

    public Summarizer(ArrayList<IndicatorData> indicatorDataList){
        this.indicatorDataList = indicatorDataList;
    }

    public Summary buildSummary(String title){
        Summary summary = new Summary(title);
        appendBasicAnalysisSection(summary);
        appendBestAndWorstVariationsSections(summary);

        return summary;
    }

    private void appendBasicAnalysisSection(Summary summary){
        BasicAnalyst basicAnalyst = new BasicAnalyst(indicatorDataList);

        Float averageVariation = basicAnalyst.getAverageVariation();
        IndicatorData bestVariation = basicAnalyst.getBestVariation();
        IndicatorData worstVariation = basicAnalyst.getWorstVariation();

        Section section = new Section("Basic analysis");
        section.addNewParagraph("Average variation: " + averageVariation.toString());
        section.addNewParagraph("Best variation: " + bestVariation.toString());
        section.addNewParagraph("Worst variation: " + worstVariation.toString());

        summary.addSection(section);
    }

    private void appendBestAndWorstVariationsSections(Summary summary){
        BasicAnalyst basicAnalyst = new BasicAnalyst(indicatorDataList);

        Section bestVariations = buildBestWorsVariationsSection("BEST VARIATIONS", basicAnalyst.getBestNVariations(10));
        Section worstVariations = buildBestWorsVariationsSection("WORST VARIATIONS", basicAnalyst.getWorstNVariations(10));

        summary.addSection(bestVariations);
        summary.addSection(worstVariations);
    }

    private Section buildBestWorsVariationsSection(String title, ArrayList<IndicatorData> variations){
        Section section = new Section(title);

        for(IndicatorData indicatorData : variations){
            section.addNewParagraph(indicatorData.toString());
        }

        return section;
    }
}
