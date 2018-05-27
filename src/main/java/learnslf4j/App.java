package learnslf4j;

import learnslf4j.implementation.DefaultLogger;
import org.apache.log4j.PropertyConfigurator;

public class App {

    public static void main(String[] args) {
        PropertyConfigurator.configure("log4j.properties");


        IMyLogger mylogger = new DefaultLogger();
        mylogger.testDebug();
        mylogger.testInfo();
        mylogger.testWarn();
        mylogger.testError();

        mylogger = new MyLogger();
        mylogger.testDebug();
        mylogger.testInfo();
        mylogger.testWarn();
        mylogger.testError();
    }

}
