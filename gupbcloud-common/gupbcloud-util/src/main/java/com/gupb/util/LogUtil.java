package com.gupb.util;

import org.slf4j.Logger;

import java.util.Objects;
import java.util.function.Supplier;


public final class LogUtil {

    private static final LogUtil LOG_UTIL = new LogUtil();

    private LogUtil() {

    }

    /**
     * Gets instance.
     *
     * @return the instance
     */
    public static LogUtil getInstance() {
        return LOG_UTIL;
    }

    /**
     * Debug.
     *
     * @param logger   the logger
     * @param format   the format
     * @param supplier the supplier
     */
    public static void debug(Logger logger, String format, Supplier<Object> supplier) {
        if (logger.isDebugEnabled()) {
            logger.debug(format, supplier.get());
        }
    }

    /**
     * Debug.
     *
     * @param logger   the logger
     * @param supplier the supplier
     */
    public static void debug(Logger logger, Supplier<Object> supplier) {
        if (logger.isDebugEnabled()) {
            logger.debug(Objects.toString(supplier.get()));
        }
    }

    /**
     * Info.
     *
     * @param logger   the logger
     * @param format   the format
     * @param supplier the supplier
     */
    public static void info(Logger logger, String format, Supplier<Object> supplier) {
        if (logger.isInfoEnabled()) {
            logger.info(format, supplier.get());
        }
    }

    /**
     * Info.
     *
     * @param logger   the logger
     * @param supplier the supplier
     */
    public static void info(Logger logger, Supplier<Object> supplier) {
        if (logger.isInfoEnabled()) {
            logger.info(Objects.toString(supplier.get()));
        }
    }

    /**
     * Error.
     *
     * @param logger   the logger
     * @param format   the format
     * @param supplier the supplier
     */
    public static void error(Logger logger, String format, Supplier<Object> supplier) {
        if (logger.isErrorEnabled()) {
            logger.error(format, supplier.get());
        }
    }

    /**
     * Error.
     *
     * @param logger   the logger
     * @param supplier the supplier
     */
    public static void error(Logger logger, Supplier<Object> supplier) {
        if (logger.isErrorEnabled()) {
            logger.error(Objects.toString(supplier.get()));
        }
    }

    /**
     * Warn.
     *
     * @param logger   the logger
     * @param format   the format
     * @param supplier the supplier
     */
    public static void warn(Logger logger, String format, Supplier<Object> supplier) {
        if (logger.isWarnEnabled()) {
            logger.warn(format, supplier.get());
        }
    }

    /**
     * Warn.
     *
     * @param logger   the logger
     * @param supplier the supplier
     */
    public static void warn(Logger logger, Supplier<Object> supplier) {
        if (logger.isWarnEnabled()) {
            logger.warn(Objects.toString(supplier.get()));
        }
    }


}
