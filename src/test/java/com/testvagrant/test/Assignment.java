package com.testvagrant.test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.testvagrant.pageObjects.NDTVHomePage;
import com.testvagrant.pageObjects.NDTVWeatherPage;
import com.testvagrant.utils.GenericFunctions;

public class Assignment extends BaseTest {
	
	GenericFunctions generic;
	NDTVHomePage homePage;
	NDTVWeatherPage weatherPage;
	String url = "https://www.ndtv.com/";
	
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
		  driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
		  generic = new GenericFunctions(driver);
		  homePage = new NDTVHomePage(driver);
		  weatherPage = new NDTVWeatherPage(driver);
	  }
	
	
	@Test
	public void openWebsiteAndNavigateToWeatherPage() {
		driver.get(url);
		driver.navigate().refresh();
		generic.waitForCompletePageLoad();
		homePage.openTopNavMoreOptions();
		homePage.clickOnOptionFromTopNavBar("WEATHER");
		generic.waitForCompletePageLoad();
	}
  

  
}
