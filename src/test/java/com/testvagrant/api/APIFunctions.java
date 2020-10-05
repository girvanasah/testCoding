package com.testvagrant.api;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class APIFunctions {
	
	String apiKey = "7fe67bf08c80ded756e598d6f8fedaea";
	
	
	/**
	 * unit can be imperial, metric and standard
	 * 
	 * For temperature in Fahrenheit use units=imperial
	 * For temperature in Celsius use units=metric
	 * For temperature in Kelvin use units=standard
	 * @param cityName
	 * @param unit
	 * @return
	 */
	
	public String getWeatherDetailsOfCity(String cityName, String unit) {
		RestAssured.baseURI ="http://api.openweathermap.org/data/2.5/";
		RequestSpecification request = RestAssured.given();
		
		return request.queryParam("q",cityName)
                .queryParam("appid", apiKey)
                .queryParam("units", unit)
	   .get("/find").asString();
	}
	
	public String getWeatherDetailsOfCityInDegree(String cityName) {
		return getWeatherDetailsOfCity(cityName, "metric");
	}
	
	public String getWeatherDetailsOfCityInFahrenheit(String cityName) {
		return getWeatherDetailsOfCity(cityName, "imperial");
	}

}
