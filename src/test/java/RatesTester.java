import com.sparta.jas.RatesParser;
import com.sparta.jas.RatesPerCurrency;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class RatesTester {

    private RatesParser ratesParser;
    private RatesPerCurrency ratesPerCurrency;

    @Before
    public void setup(){
        ratesParser = new RatesParser("resources\\rates.json");
        ratesPerCurrency = new RatesPerCurrency(ratesParser);
    }

    @Test
    public void parserTests(){
        Assert.assertEquals("true", ratesParser.getJSONSuccess());
        Assert.assertEquals("2018-10-10", ratesParser.getDate());
        Assert.assertEquals("EUR", ratesParser.getBaseCurrency());
        Assert.assertEquals("1539182646", ratesParser.getTimestamp());
    }
}
