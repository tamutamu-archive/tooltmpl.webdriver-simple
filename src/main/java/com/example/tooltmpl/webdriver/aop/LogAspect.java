package com.example.tooltmpl.webdriver.aop;

import java.net.URISyntaxException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class LogAspect {

    private static Logger logger = LoggerFactory.getLogger(LogAspect.class);

    public void catchLog(URISyntaxException ex) {
        logger.error("URISyntaxException::", ex);
    }

}
