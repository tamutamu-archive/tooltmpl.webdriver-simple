package com.example.tooltmpl.webdriver;

import java.io.File;
import java.net.URISyntaxException;
import java.util.concurrent.TimeUnit;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("singleton")
public class WebDriverProvider {

    private WebDriver driver;

    @PostConstruct
    public void init() throws URISyntaxException {
        File chromePath;
        chromePath = new File(
                Thread.currentThread().getContextClassLoader().getResource("lib/chromedriver.exe").toURI());

        System.setProperty("webdriver.chrome.driver", chromePath.getAbsolutePath());
        this.driver = new ChromeDriver();
        this.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        this.driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
    }

    public WebDriver get() {
        return this.driver;
    }

    @PreDestroy
    public void destroy() {

        if (this.driver != null)
            this.driver.close();

    }

}
