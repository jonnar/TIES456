package ties456.jetty;

import org.eclipse.jetty.plus.servlet.ServletHandler;
import org.eclipse.jetty.server.Server;
import ties456.servlet.GetCurrencyRate;

/**
 * Created by Henri on 21.9.2016.
 */
public class RunServlets {

    /**
     * simple jetty server for handling requests
     * @param args not used
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        ServletHandler servletHandler = new ServletHandler();

        servletHandler.addServletWithMapping(GetCurrencyRate.class, "/getRate");

        Server server = new Server(8080);
        server.setHandler(servletHandler);
        server.start();
    }
}
