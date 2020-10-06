package com.testvagrant.web;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.testvagrant.utils.GenericFunctions;

public class HandleDriver {

	public WebDriver driver;

	public WebDriver startDriver(String browserType, String chromeOrGeckoDriverPath) {
		if (browserType.equalsIgnoreCase("FF") || browserType.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", chromeOrGeckoDriverPath + "\\geckodriver.exe");
			FirefoxOptions options = new FirefoxOptions();
			options.addArguments("--window-size=1366,768");
			DesiredCapabilities capabilities = DesiredCapabilities.firefox();

			capabilities.setCapability("marionette", true);
			capabilities.setCapability("moz:firefoxOptions", options);
			options.merge(capabilities);
			driver = new FirefoxDriver(capabilities);
		} else if (browserType.equalsIgnoreCase("Chrome")) {
			System.setProperty("webdriver.chrome.driver", chromeOrGeckoDriverPath + "\\chromedriver.exe");
			DesiredCapabilities capabilities = DesiredCapabilities.chrome();

			ChromeOptions options = new ChromeOptions();
			options.setExperimentalOption("useAutomationExtension", false);
			options.addArguments("--window-size=1366,768");
			capabilities.setCapability(ChromeOptions.CAPABILITY, options);
			driver = new ChromeDriver(capabilities);
		}

		else
			System.out.println("Error!!! Please enter valid browserType");

		return driver;

	}
	
	public void quitDriver(WebDriver driver) {
		driver.quit();
		GenericFunctions.logMessage("Browser Closed!!!");
	}

}
