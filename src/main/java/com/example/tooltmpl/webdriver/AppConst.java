package com.example.tooltmpl.webdriver;

import java.util.Properties;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.stereotype.Component;

@Component
public class AppConst {

    @Resource
    public Properties appProps;

    @PostConstruct
    public void init() {
        START_URL = appProps.getProperty("start.url");
    }

    public static String START_URL;

}
