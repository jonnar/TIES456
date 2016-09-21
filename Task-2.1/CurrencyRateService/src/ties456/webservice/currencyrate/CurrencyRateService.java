package ties456.webservice.currencyrate;

/**
 * Created by Henri on 21.9.2016.
 */
public interface CurrencyRateService {
    public String getExchangeRate(String fromCurrency, String toCurrency);
}
