package matias.dataAnalysis.Output;

import java.util.ArrayList;

/**
 * Created by matias on 10/06/17.
 */
public class Summary {
    private ArrayList<Section> sections;
    private String title;
    private static String newLine = "\n";
    private static String sectionSeparator = newLine + "--------------------------" + newLine;

    public Summary(String title){
        sections = new ArrayList<>();
        this.title = title;
    }

    public void addSection(Section section){
        sections.add(section);
    }

    public String toString(){
        StringBuilder builder = new StringBuilder();
        builder.append(this.title);

        for(Section section : sections){
            builder.append(sectionSeparator)
                    .append(generateSectionOutput(section))
                    .append(sectionSeparator);
        }

        return builder.toString();
    }

    private String generateSectionOutput(Section section){
        StringBuilder builder = new StringBuilder();
        builder.append(section.getTitle())
                .append(newLine);

        for(String paragraph : section.getParagraphs()){
            builder.append(paragraph)
                    .append(newLine);
        }

        return builder.toString();
    }
}
