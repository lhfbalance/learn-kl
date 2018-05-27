package learnlog4j;

import learnlog4j.impl.DefaultLogger;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class App {

    public static void main(String[] args) {
        PropertyConfigurator.configure("log4j.properties");
        Logger logger = Logger.getLogger(App.class);
        logger.debug("here is debug");
        logger.info("here is info");
        logger.warn("here is warn");
        logger.error("here is error");
        logger.fatal("here is fatal");

        Ilogger mylogger = new DefaultLogger();
        mylogger.testDebug();
        mylogger.testInfo();
        mylogger.testWarn();
        mylogger.testError();
        mylogger.testFatal();
    }

}
