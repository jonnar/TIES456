package ties456.webservice.currencyrate;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Henri on 21.9.2016.
 */
@WebService
public class CurrencyRateServiceImpl implements CurrencyRateService {

    private static Map<String, Map<String, Double>> currencyRates = new HashMap<>();

    /**
     * init currency rates
     */
    private void init() {
        Map<String, Double> euroRates = new HashMap<>();
        euroRates.put("EUR", 1.00);
        euroRates.put("USD", 1.12);
        euroRates.put("AED", 4.09);
        euroRates.put("GBP", 0.86);
        euroRates.put("SEK", 9.58);
        currencyRates.put("EUR", euroRates);

        Map<String, Double> poundRates = new HashMap<>();
        poundRates.put("EUR", 1.17);
        poundRates.put("USD", 1.3);
        poundRates.put("AED", 4.76);
        poundRates.put("GBP", 1.00);
        poundRates.put("SEK", 11.18);
        currencyRates.put("GBP", poundRates);

        Map<String, Double> dollarRates = new HashMap<>();
        dollarRates.put("EUR", 0.9);
        dollarRates.put("USD", 1.00);
        dollarRates.put("AED", 3.67);
        dollarRates.put("GBP", 0.77);
        dollarRates.put("SEK", 8.59);
        currencyRates.put("USD", dollarRates);

        Map<String, Double> kronaRates = new HashMap<>();
        kronaRates.put("EUR", 0.1);
        kronaRates.put("USD", 0.12);
        kronaRates.put("AED", 0.43);
        kronaRates.put("GBP", 0.09);
        kronaRates.put("SEK", 1.00);
        currencyRates.put("SEK", kronaRates);

        Map<String, Double> dirhamRates = new HashMap<>();
        dirhamRates.put("EUR", 0.24);
        dirhamRates.put("USD", 0.27);
        dirhamRates.put("AED", 1.00);
        dirhamRates.put("GBP", 0.21);
        dirhamRates.put("SEK", 2.34);
        currencyRates.put("AED", dirhamRates);
    }

    @WebMethod
    @Override
    public String getExchangeRate(String fromCurrency, String toCurrency) {
        init();
        return currencyRates.get(fromCurrency).get(toCurrency).toString();
    }
}
