package com.sparta.jas;

public class Starter {
    public static void main(String[] args) {
        RatesParser ratesParser = new RatesParser("resources\\rates.json");

        System.out.println(ratesParser.getJSONSuccess());
    }
}
