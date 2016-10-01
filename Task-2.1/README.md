#Task 2.1

- CurrencyRateService: simple web service that let's one to get exchange rate based on currencies code (e.g EUR or US). Currently supports only couple of currencies.
- CurrencyRateServlet: Servlet that retrvies currency exchange rate based on country ISO codes. Servlet is wrapped to Jetty server.

#Running locally

1. Run "Exporter.java" under CurrencyRateService project as java application
2. Run "RunServlets.java" under CurrencyRateServlet project as java application
3. E.g. url http://localhost:8080/getRate?fromCountry=AE&toCountry=US should response with AED and USD currency codes, and exchange rate

NOTE: To get CurrencyRateServlet working, one needs to add jars under /lib to buildpath.