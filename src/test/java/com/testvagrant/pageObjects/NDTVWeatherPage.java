package com.testvagrant.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.testvagrant.utils.GenericFunctions;
import com.testvagrant.web.BaseUI;

public class NDTVWeatherPage extends BaseUI {

	WebDriver driver;
	WebDriverWait wait;
	GenericFunctions generic;

	public NDTVWeatherPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		this.wait = new WebDriverWait(driver, 10);
		this.generic = new GenericFunctions(driver);
	}

	public static String cityMapLabel = "//div[@class = 'cityText' and text()='%s']";
	public static String pinYourCityTxtBox = "//input[@id='searchBox']";
	public static String cityLabelChkBox = "//div[@id='messages']//label[@for='%s']/input";
	public static String selectCityLabelMapTxt = "//div[@id='map_canvas']//div[@title='%s']//div[@class='cityText']";
	public static String cityLeaflet = "//div[@class='leaflet-popup-content']";
	public static String cityLeafletSubHeadingTxt = "//div[@class='leaflet-popup-content']//span[@class='heading']/b[contains(text(),'%s')]";

	public boolean checkCityAlreadyDisplayed(String city) {
		generic.waitForCompletePageLoad();
		int count = getElements(String.format(cityMapLabel, city)).size();
		return count > 0 ? true : false;
	}

	public void searchCityFromPinYourCityPanel(String cityName) {
		generic.waitForCompletePageLoad();
		clickElementUsingExplicitWait(pinYourCityTxtBox);
		fillText(pinYourCityTxtBox, cityName);
	}

	public void selectUnselectCityFromPinYourCityPanel(String cityName) {
		clickElementUsingExplicitWait(String.format(cityLabelChkBox, cityName));
	}

	public boolean selectCityFromPinYourCityIfNotAlreadyAvailable(String cityName) {
		if (checkCityAlreadyDisplayed(cityName)) {
			return true;
		}
		searchCityFromPinYourCityPanel(cityName);
		selectUnselectCityFromPinYourCityPanel(cityName);
		if (checkCityAlreadyDisplayed(cityName)) {
			return true;
		}
		return false;
	}
	
	public void openDetailsLeafletForCity(String cityName) {
		clickElementUsingExplicitWait(String.format(selectCityLabelMapTxt, cityName));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(cityLeaflet)));
	}

	public String getTemperatureInDegreeCelsius(String cityName) {
		String temp = null;
		temp = getTextofElement(String.format(cityLeafletSubHeadingTxt, "Degrees"));
		return temp.split("Degrees: ")[1].trim();
	}

	public String getTemperatureInFahrenheit(String cityName) {
		String temp = null;
		temp = getTextofElement(String.format(cityLeafletSubHeadingTxt, "Fahrenheit"));
		return temp.split("Fahrenheit: ")[1].trim();
	}

	public String getHumidity(String cityName) {
		String humidity = null;
		humidity = getTextofElement(String.format(cityLeafletSubHeadingTxt, "Humidity"));
		return humidity.substring(humidity.indexOf(":")+1, humidity.lastIndexOf("%")).trim();
	}
}
