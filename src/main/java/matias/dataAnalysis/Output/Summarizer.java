package matias.dataAnalysis.Output;

import matias.dataAnalysis.analysis.Analysts.BasicAnalyst;
import matias.dataAnalysis.IndicatorData;

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
        Float averageVariation = BasicAnalyst.getAverageVariation(indicatorDataList);
        IndicatorData bestVariation = BasicAnalyst.getBestVariation(indicatorDataList);
        IndicatorData worstVariation = BasicAnalyst.getWorstVariation(indicatorDataList);

        Section section = new Section("Basic analysis");
        section.addNewParagraph("Average variation: " + averageVariation.toString());
        section.addNewParagraph("Best variation: " + bestVariation.toString());
        section.addNewParagraph("Worst variation: " + worstVariation.toString());

        summary.addSection(section);
    }

    private void appendBestAndWorstVariationsSections(Summary summary){
        Section bestVariations = buildBestWorsVariationsSection("BEST VARIATIONS", BasicAnalyst.getBestNVariations(indicatorDataList, 10));
        Section worstVariations = buildBestWorsVariationsSection("WORST VARIATIONS", BasicAnalyst.getWorstNVariations(indicatorDataList, 10));

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
