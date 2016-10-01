package ties456.servlet;
import ties456.webservice.client.countryinfo.*;
import ties456.webservice.client.currencyrate.CurrencyRateServiceImpl;
import ties456.webservice.client.currencyrate.CurrencyRateServiceImplServiceLocator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Henri on 21.9.2016.
 */
public class GetCurrencyRate extends HttpServlet {

    /**
     * 1. gets country ISO codes parameters
     * 2. invokes webservice to get corresponding currencies for those countries
     * 3. invokes another webservice to get exchange rate for acquired currency codes
     * 4. prints currency codes and exchange rate as response
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // get params
        String fromCountry = req.getParameter("fromCountry");
        String toCountry = req.getParameter("toCountry");

        String fromCurrency = "", toCurrency = "", rate = "";
        try {
            // get currency codes based on country ISO code
            CountryInfoServiceLocator serviceLocator = new CountryInfoServiceLocator();
            CountryInfoServiceSoapType countryInfoServiceSoapType = serviceLocator.getCountryInfoServiceSoap();

            TCurrency tCurrencyFrom = countryInfoServiceSoapType.countryCurrency(fromCountry);
            fromCurrency = tCurrencyFrom.getSISOCode();

            TCurrency tCurrencyTo = countryInfoServiceSoapType.countryCurrency(toCountry);
            toCurrency = tCurrencyTo.getSISOCode();

            // get exchange rate of the currencies
            CurrencyRateServiceImplServiceLocator rateServiceImplServiceLocator = new CurrencyRateServiceImplServiceLocator();
            CurrencyRateServiceImpl currencyRateService = rateServiceImplServiceLocator.getCurrencyRateServiceImplPort();
            rate = currencyRateService.getExchangeRate(fromCurrency, toCurrency);

        } catch (Exception e) {
            e.printStackTrace();
        }

        // write response
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.println("From currency: " + fromCurrency);
        out.println("To currency: " + toCurrency);
        out.println("Exchange rate is: " + rate);
    }
}
