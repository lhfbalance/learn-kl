package learnslf4j;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class IMyLogger {

    private static final Logger logger = LoggerFactory.getLogger(IMyLogger.class);

    protected abstract void debugLevelTest();

    protected abstract void infoLevelTest();

    protected abstract void warnLevelTest();

    protected abstract void errorLevelTest();


    public void testDebug() {
        logger.debug("start test debug");
        debugLevelTest();
    }

    public void testInfo() {
        logger.info("start test info");
        infoLevelTest();
    }
    public void testWarn() {
        logger.warn("start test warn");
        warnLevelTest();
    }
    public void testError() {
        logger.error("start test error");
        errorLevelTest();
    }
}
