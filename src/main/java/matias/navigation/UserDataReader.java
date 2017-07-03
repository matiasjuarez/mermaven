package matias.navigation;

import matias.IO.FileRead.PlainTextFileReader;

import java.util.ArrayList;

/**
 * Created by matias on 22/05/17.
 */
public class UserDataReader {

    private static final PlainTextFileReader fileReader = new PlainTextFileReader();
    private ArrayList<String> data;
    private String dataFileURL;

    public UserDataReader(String URL){
        dataFileURL = URL;
    }

    public String getDni(){
        return getValueOfKey("dni", getData());
    }

    public String getUser(){
        return getValueOfKey("user", getData());
    }

    public String getPass(){
        return getValueOfKey("pass", getData());
    }

    private ArrayList<String> getData(){
        if(data == null){
            data = fileReader.getLinesAsSeparatedStrings(dataFileURL);
        }

        return data;
    }

    private String getValueOfKey(String key, ArrayList<String> data){
        for(String datum : data){
            String[] separated = datum.split("=");
            if(separated[0].equals(key)){
                return separated[1];
            }
        }

        return null;
    }
}
