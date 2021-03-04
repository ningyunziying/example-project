package com.ny.logging;

import com.ny.logging2.LogMain;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HelloWorld {
    private static Logger logger = LoggerFactory.getLogger(HelloWorld.class);

    public static void main(String[] args) {
        logger.info("Hello World");
        logger.debug("Hello World-logging");
        LogMain.info();
    }
}
