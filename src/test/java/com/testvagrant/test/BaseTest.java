package com.testvagrant.test;

import org.testng.annotations.Test;

import com.testvagrant.utils.StartDriver;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeClass;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;

public class BaseTest {
	
	StartDriver startDriver = new StartDriver();
	WebDriver driver;
	Properties prop = new Properties();
	InputStream input;

  @BeforeMethod
  public void beforeMethod() {
	  
  }

  @BeforeClass
  public void beforeClass() {
	  try {
			input = new FileInputStream("Config.properties");
			prop.load(input);
		} catch (IOException e) {
			e.printStackTrace();
		}
	  String browserType = prop.getProperty("browserType");
	  String chromeOrGeckoDriverPath = prop.getProperty("chromeOrGeckoDriverPath");
	  driver = startDriver.startDriver(browserType, chromeOrGeckoDriverPath);
  }

  @AfterClass
  public void afterClass() {
	  driver.quit();
  }

}