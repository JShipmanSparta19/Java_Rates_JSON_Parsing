package com.sparta.jas;

import org.json.simple.JSONObject;

public class RatesParser {
    private JSONObject ratesFullFile;

    public RatesParser(String filePath){
        RatesFileReader ratesFileReader = new RatesFileReader(filePath);
        ratesFullFile = ratesFileReader.getFullJSONFile();
    }

    //getters
    private Object getJSONValue(String key){
        return ratesFullFile.get(key);
    }

    public String getJSONSuccess(){
        return getJSONValue("success").toString();
    }

    public long getTimestamp(){
        return (Long) getJSONValue("timestamp");
    }

    public String getBaseCurrency(){
        return getJSONValue("base").toString();
    }

    public String getDate(){
        return getJSONValue("date").toString();
    }

    public JSONObject getRates() {
        return (JSONObject) getJSONValue("rates");
    }

    public JSONObject getRatesFullFile() {
        return ratesFullFile;
    }
}
