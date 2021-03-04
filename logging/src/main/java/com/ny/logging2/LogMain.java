package com.ny.logging2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogMain {
    private static Logger logger = LoggerFactory.getLogger(LogMain.class);

    public static void info() {
        logger.info("LogMain.info");
    }
}
