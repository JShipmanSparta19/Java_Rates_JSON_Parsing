package com.sparta.jas;

import org.json.simple.JSONObject;

public class RatesPerCurrency {
    private JSONObject rates;

    public RatesPerCurrency(String fileName) {
        RatesParser ratesParser = new RatesParser(fileName);
        rates = ratesParser.getRates();
    }

    public RatesPerCurrency(RatesParser ratesParser){
        rates = ratesParser.getRates();
    }

    public JSONObject getRates() {
        return rates;
    }

    public double getConversionRate(String key){
        if (!rates.get(key).toString().contains(".")){
            long longRate = (Long) rates.get(key);
            double doubleRate = longRate;
            return doubleRate;
        } else {
            return (Double) rates.get(key);
        }
    }
}
