package com.testvagrant.test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.testvagrant.api.APIFunctions;
import com.testvagrant.pageObjects.NDTVHomePage;
import com.testvagrant.pageObjects.NDTVWeatherPage;
import com.testvagrant.utils.GenericFunctions;

public class Assignment extends BaseTest {

	GenericFunctions generic;
	NDTVHomePage homePage;
	NDTVWeatherPage weatherPage;
	APIFunctions apiFunctions;
	String url = "https://www.ndtv.com/";
	String cityName, jsonWeatherDetails, browserType, chromeOrGeckoDriverPath;
	String jsonWeatherDetailsInDegree, jsonWeatherDetailsInFahrenheit;
	double webTempInDegree, webTempInFahrenheit, webHumidity;
	double apiTempInDegree, apiTempInFahrenheit, apiHumidity;
	double varianceFahrenheit, varianceDegree, varianceHumidity;

	@BeforeClass
	public void beforeClass() {
		try {
			input = new FileInputStream("Config.properties");
			prop.load(input);
		} catch (IOException e) {
			e.printStackTrace();
		}
		browserType = prop.getProperty("browserType");
		chromeOrGeckoDriverPath = prop.getProperty("chromeOrGeckoDriverPath");
		apiFunctions = new APIFunctions();
		cityName = prop.getProperty("cityName");
		varianceFahrenheit = Double.parseDouble(prop.getProperty("varianceFahrenheit"));
		varianceDegree = Double.parseDouble(prop.getProperty("varianceDegree"));
		varianceHumidity = Double.parseDouble(prop.getProperty("varianceHumidity"));
	}

	@Test
	public void openWebsiteAndNavigateToWeatherPage() {
		driver = handleDriver.startDriver(browserType, chromeOrGeckoDriverPath);
		driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
		generic = new GenericFunctions(driver);
		homePage = new NDTVHomePage(driver);
		weatherPage = new NDTVWeatherPage(driver);
		driver.get(url);
		generic.waitForCompletePageLoad();
		homePage.openTopNavMoreOptions();
		homePage.clickOnOptionFromTopNavBar("WEATHER");
		generic.waitForCompletePageLoad();
	}

	@Test(dependsOnMethods = "openWebsiteAndNavigateToWeatherPage")
	public void searchAndSelectCity() {
		Assert.assertTrue(weatherPage.selectCityFromPinYourCityIfNotAlreadyAvailable(cityName),
				"City could not be selected");
	}

	@Test(dependsOnMethods = "searchAndSelectCity", groups = { "finalDetails" })
	public void openLeafletAndSaveDetailsFromWebSite() {
		weatherPage.openDetailsLeafletForCity(cityName);
		webTempInDegree = Double.parseDouble(weatherPage.getTemperatureInDegreeCelsius(cityName));
		webTempInFahrenheit = Double.parseDouble(weatherPage.getTemperatureInFahrenheit(cityName));
		webHumidity = Double.parseDouble(weatherPage.getHumidity(cityName));
		handleDriver.quitDriver(driver);
	}

	@Test
	public void getWeatherDetailsOfIndianCity() {
		jsonWeatherDetailsInDegree = GenericFunctions
				.getWeatherObjectOFFirstIndianCity(apiFunctions.getWeatherDetailsOfCityInDegree(cityName));
		jsonWeatherDetailsInFahrenheit = GenericFunctions
				.getWeatherObjectOFFirstIndianCity(apiFunctions.getWeatherDetailsOfCityInFahrenheit(cityName));
		Assert.assertFalse(jsonWeatherDetailsInDegree.equals(""),
				"Weather Details Not Available For City Or City Not In India");
		Assert.assertFalse(jsonWeatherDetailsInFahrenheit.equals(""),
				"Weather Details Not Available For City Or City Not In India");
	}

	@Test(dependsOnMethods = "getWeatherDetailsOfIndianCity", groups = { "finalDetails" })
	public void getDetailsFromAPIData() {
		apiTempInDegree = GenericFunctions.getTemperatureFromJSON(jsonWeatherDetailsInDegree);
		apiTempInFahrenheit = GenericFunctions.getTemperatureFromJSON(jsonWeatherDetailsInFahrenheit);
		apiHumidity = GenericFunctions.getHumidityFromJSON(jsonWeatherDetailsInDegree);
	}

	@Test(dependsOnGroups = "finalDetails")
	public void verifyAPIAndWebDataWithVariance() {
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(
				GenericFunctions.compareDatawithVariance(apiTempInFahrenheit, webTempInFahrenheit, varianceFahrenheit),
				"Fahrenheit Tempearature exceeds Variance, APITemp: " +apiTempInFahrenheit+ " WebTemp: " +webTempInFahrenheit);
		softAssert.assertTrue(
				GenericFunctions.compareDatawithVariance(apiTempInDegree, webTempInDegree, varianceDegree),
				"Degree Celsius Tempearature exceeds Variance, APITemp: " +apiTempInDegree+ " WebTemp: " +webTempInDegree);
		softAssert.assertTrue(GenericFunctions.compareDatawithVariance(apiHumidity, webHumidity, varianceHumidity),
				"Humidity exceeds Variance, APIHumidity: " + apiHumidity + " WebHumidity: " + webHumidity);
		softAssert.assertAll();
	}
}
