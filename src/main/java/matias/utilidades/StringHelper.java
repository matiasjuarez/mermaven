package matias.utilidades;

import java.util.ArrayList;

/**
 * Created by Matías on 16/04/2017.
 */
public class StringHelper {

    public enum EncloserElement{
        PARENTHESIS,
        SQUARE_BRACKET,
        SINGLE_QUOTE,
        DOUBLE_QUOTE
    }

    private StringHelper(){}

    public static String mixStrings(String separator, String... strings){
        StringBuilder builder = new StringBuilder();
        for(String string : strings){
            builder.append(string).append(separator);
        }

        String result = builder.toString();

        return result.substring(0, result.length() - separator.length());
    }

    public static String mixStrings(String separator, ArrayList<String> strings){
        return mixStrings(separator, strings.toArray(new String[strings.size()]));
    }

    public static String encloseString(String value, EncloserElement element){
        char firstEnclosingElement = ' ';
        char secondEnclosingElement = ' ';

        if(element == EncloserElement.DOUBLE_QUOTE){
            firstEnclosingElement = secondEnclosingElement = '"';
        } else if(element == EncloserElement.SINGLE_QUOTE){
            firstEnclosingElement = secondEnclosingElement = '\'';
        } else if(element == EncloserElement.PARENTHESIS){
            firstEnclosingElement = '(';
            secondEnclosingElement = ')';
        } else if(element == EncloserElement.SQUARE_BRACKET){
            firstEnclosingElement = '[';
            secondEnclosingElement = ']';
        }

        StringBuilder builder = new StringBuilder();
        builder.append(firstEnclosingElement).
                append(value).
                append(secondEnclosingElement);

        return builder.toString();
    }
}
