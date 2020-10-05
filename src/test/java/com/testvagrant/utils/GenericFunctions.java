package com.testvagrant.utils;

import org.json.JSONArray;
import org.json.JSONObject;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

public class GenericFunctions {

	WebDriver driver;

	public GenericFunctions(WebDriver driver) {
		this.driver = driver;
	}

	public static void logMessage(String messageToBeLogged) {
		Reporter.setEscapeHtml(false);
		Reporter.log(messageToBeLogged, true);
	}

	public static void hardWait(int timeInMilliSecond) {
		try {
			Thread.sleep(timeInMilliSecond);
		} catch (Exception ex) {
			logMessage("In exception block of hardWait");
			ex.printStackTrace();
		}
	}

	public void waitForCompletePageLoad() {
		int i = 10;

		while (i > 0) {
			if (!((JavascriptExecutor) driver).executeScript("return window.performance.timing.loadEventEnd").toString()
					.equals("0"))
				break;

			GenericFunctions.hardWait(1000);
			i--;
		}
	}

	public static String getWeatherObjectOFFirstIndianCity(String jsonString) {
		JSONObject completeDetails = new JSONObject(jsonString);
		JSONArray allCityWeatherDetails = completeDetails.optJSONArray("list");
		int index = -1;
		for (int i = 0; i < allCityWeatherDetails.length(); i++) {
			JSONObject tempDetails = allCityWeatherDetails.optJSONObject(i);
			if (tempDetails.optJSONObject("sys").opt("country").equals("IN")) {
				index = i;
				break;
			}
		}
		return allCityWeatherDetails.optJSONObject(index) == null ? ""
				: allCityWeatherDetails.optJSONObject(index).toString();
	}
	
	public static double getTemperatureFromJSON(String jsonCityWeatherDetails) {
		try {
		return Double.parseDouble(new JSONObject(jsonCityWeatherDetails).optJSONObject("main").optString("temp", "9999"));
		}
		catch (Exception e) {
			try {
				throw new Exception("Cannot convert temperature From API");
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
		return 9999;
	}
	
	public static double getHumidityFromJSON(String jsonCityWeatherDetails) {
		
		try {
			return Double.parseDouble(new JSONObject(jsonCityWeatherDetails).optJSONObject("main").optString("humidity", "9999"));
			}
			catch (Exception e) {
				try {
					throw new Exception("Cannot convert humidity From API");
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
			return 9999;
	}
	
	public static boolean compareDatawithVariance(double data1, double data2, double variance) {
		double difference = Double.compare(data1, data2) < 1 ? data2-data1 : data1-data2;
		return Double.compare(difference, variance) < 1 ? true : false;
	}

}
