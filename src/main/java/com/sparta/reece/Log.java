package com.sparta.reece;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @author Reece Louch
 */

public class Log {
    private static final Logger logger = LogManager.getLogger(Starter.class);
    public void logException(Throwable e) {
        logger.error(e.getMessage(), e);
    }
    public void logTrace(String message) {
        logger.trace(message);
    }
    public void logDebug(String message) {
        logger.debug(message);
    }
    public void logInfo(String message) {
        logger.info(message);
    }
    public void logFatal(Error error) {
        logger.fatal(error.getMessage(), error);
    }
}
