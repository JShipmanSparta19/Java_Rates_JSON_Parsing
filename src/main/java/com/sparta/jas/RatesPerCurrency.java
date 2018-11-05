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

    public String getConversionRate(String key){
        return rates.get(key).toString();
    }
}
