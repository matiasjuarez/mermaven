package dataAnalysis.Output;

import java.util.ArrayList;

/**
 * Created by matias on 10/06/17.
 */
public class Section {
    private String title;
    private ArrayList<String> paragraphs;

    public Section(String title){
        this.title = title;
        this.paragraphs = new ArrayList<>();
    }

    public void addNewParagraph(String paragraph){
        paragraphs.add(paragraph);
    }

    public String getTitle() {
        return title;
    }

    public ArrayList<String> getParagraphs() {
        return paragraphs;
    }
}
