package ties456.exporter;

import ties456.webservice.currencyrate.CurrencyRateServiceImpl;

import javax.xml.ws.Endpoint;

/**
 * Created by Henri on 21.9.2016.
 */
public class Exporter {
    /**
     * main method for publishing web service(s)
     * @param args not used
     */
    public static void main(String[] args) {
        Endpoint.publish("http://localhost:9000/CurrencyRateService", new CurrencyRateServiceImpl());
    }
}
