import com.sparta.jas.RatesParser;
import com.sparta.jas.RatesPerCurrency;
import org.json.simple.JSONObject;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Random;

public class RatesTester {

    private RatesParser ratesParser;
    private RatesPerCurrency ratesPerCurrency;
    private JSONObject rates;
    private Random random = new Random();

    @Before
    public void setup(){
        ratesParser = new RatesParser("resources\\rates.json");
        ratesPerCurrency = new RatesPerCurrency(ratesParser);
        rates = ratesPerCurrency.getRates();
    }

    @Test
    public void parserTests(){
        Assert.assertEquals("true", ratesParser.getJSONSuccess());
        Assert.assertEquals("2018-10-10", ratesParser.getDate());
        Assert.assertEquals("EUR", ratesParser.getBaseCurrency());
        Assert.assertEquals(1539182646, ratesParser.getTimestamp());
        Assert.assertEquals(5, ratesParser.getRatesFullFile().size());
    }

    @Test
    public void rateTests(){
        Object[] currencyArray = rates.keySet().toArray();
        for (int i = 0; i < 10; i++) {
            int rng = random.nextInt(ratesPerCurrency.getRates().size());
            String randomCurrency = currencyArray[rng].toString();
            Assert.assertEquals(rates.get(randomCurrency), ratesPerCurrency.getConversionRate(randomCurrency));
//            System.out.println(randomCurrency + " " + ratesPerCurrency.getConversionRate(randomCurrency));
        }
        for (Object currency: currencyArray) {
            Assert.assertNotEquals(null, currency);
            Assert.assertNotEquals(null, ratesPerCurrency.getConversionRate(currency.toString()));
        }
    }
}
