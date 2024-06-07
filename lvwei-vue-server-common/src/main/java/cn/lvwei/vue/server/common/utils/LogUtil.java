package cn.lvwei.vue.server.common.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class LogUtil {
    private static final Logger logger = LoggerFactory.getLogger(LogUtil.class);

    public static void info(String message) {
        logger.info(message);
    }

    public static void info(String message, Object... arguments) {
        logger.info(message, arguments);
    }

    public static void debug(String message) {
        logger.debug(message);
    }

    public static void error(String message, Throwable t) {
        logger.error(message, t);
    }

}
