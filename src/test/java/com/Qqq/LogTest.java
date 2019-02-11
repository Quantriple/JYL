package com.Qqq;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



/**
 * Created by Administrator on 2019/1/20.
 */
public class LogTest {

    private  static Logger logger= LoggerFactory.getLogger(LogTest.class);



    public static void Test(){
        logger.error("this is log error");
        logger.warn("this is log warn");
        logger.info("this is log info");
        logger.debug("this is log debug");
        logger.trace("this is log trace");



    }

    public static void main(String[] args) {
        LogTest.Test();
    }
}
