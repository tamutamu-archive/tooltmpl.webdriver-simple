package com.example.tooltmpl.webdriver;

import java.io.File;
import java.net.URISyntaxException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class App {

	private static Logger logger = LoggerFactory.getLogger(App.class);

	public static void main(String[] args) {

		WebDriver driver = null;

		try {
			driver = getWebDriver();
		} catch (URISyntaxException e) {
			logger.error("chromedriverの場所がおかしい。", e);
		} finally {
			if (driver != null)
				driver.close();
		}

	}

	private static WebDriver getWebDriver() throws URISyntaxException {

		File chromePath = new File(
				Thread.currentThread().getContextClassLoader().getResource("lib/chromedriver.exe").toURI());

		System.setProperty("webdriver.chrome.driver", chromePath.getAbsolutePath());
		return new ChromeDriver();

	}
}
