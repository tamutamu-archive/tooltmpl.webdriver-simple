package com.example.tooltmpl.webdriver.page;

import javax.annotation.PostConstruct;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.tooltmpl.webdriver.AppConst;
import com.example.tooltmpl.webdriver.WebDriverProvider;

@Component
public class Start {

    private WebDriver driver;

    @Autowired
    private WebDriverProvider provider;

    @PostConstruct
    public void init() {
        this.driver = provider.get();
        PageFactory.initElements(driver, this);
    }

    public void doProcess() {
        this.driver.get(AppConst.START_URL);
    }
}
