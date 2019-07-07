package com.code.log;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
//ALL < DEBUG < INFO < WARN < ERROR < FATAL < OFF
public class LogTest {

    protected static final Log logger = LogFactory.getLog(LogTest.class);

    public static void main(String[] args) {

        //log4j.logger.com.code.log=INFO 设置指定级别
        logger.debug("LogTest-debug");
        logger.info("LogTest-info");
        logger.warn("LogTest-warn");
        logger.error("LogTest-error");

    }
}
