package com.sparta.jas;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class RatesFileReader {

    private JSONObject fullJSONFile = new JSONObject();

    public RatesFileReader(String filePath){
        try {
            FileReader ratesJSONFile = new FileReader(filePath);
            JSONParser parser = new JSONParser();
            Object ratesObject = parser.parse(ratesJSONFile);
            fullJSONFile = (JSONObject)ratesObject;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public JSONObject getFullJSONFile() {
        return fullJSONFile;
    }
}
