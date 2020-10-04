package com.testvagrant.test;


import com.testvagrant.utils.StartDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeClass;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;

public class BaseTest {
	
	StartDriver startDriver = new StartDriver();
	WebDriver driver;
	Properties prop = new Properties();
	InputStream input;

  @AfterClass
  public void afterClass() {
	  driver.quit();
  }

}
