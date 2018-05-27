package learnlog4j;

import org.apache.log4j.Logger;

public abstract class Ilogger {

    private static final Logger logger = Logger.getLogger(Ilogger.class);

    protected abstract void debugLevelTest();

    protected abstract void infoLevelTest();

    protected abstract void warnLevelTest();

    protected abstract void errorLevelTest();

    protected abstract void fatalLevelTest();

    void testDebug() {
        logger.debug("start test debug");
        debugLevelTest();
    }

    void testInfo() {
        logger.info("start test info");
        infoLevelTest();
    }
    void testWarn() {
        logger.warn("start test warn");
        warnLevelTest();
    }
    void testError() {
        logger.error("start test error");
        errorLevelTest();
    }
    void testFatal() {
        logger.fatal("start test fatal");
        fatalLevelTest();
    }

}
