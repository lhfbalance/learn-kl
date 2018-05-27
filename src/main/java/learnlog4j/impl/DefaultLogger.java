package learnlog4j.impl;

import learnlog4j.Ilogger;
import org.apache.log4j.Logger;

public class DefaultLogger extends Ilogger {

    private static final Logger logger = Logger.getLogger(DefaultLogger.class);


    @Override
    protected void debugLevelTest() {
        logger.debug("debug level test");
    }

    @Override
    protected void infoLevelTest() {

        logger.info("info level test");
    }

    @Override
    protected void warnLevelTest() {
        logger.warn("warn level test");
    }

    @Override
    protected void errorLevelTest() {
        logger.error("error level test");
    }

    @Override
    protected void fatalLevelTest() {
        logger.fatal("fatal level test");
    }
}
