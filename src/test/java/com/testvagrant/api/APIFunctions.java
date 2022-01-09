package com.testvagrant.api;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class APIFunctions {

	String apiKey = "7fe67bf08c80ded756e598d6f8fedaea";

	public static void main(String aa[]) {
		RestAssured.baseURI = "https://api.myvfirst.com/psms/servlet/psms.Eservice2";
		RequestSpecification req = RestAssured.given();

		String data = "<?xml version=\"1.0\" encoding=\"ISO-8859-1\"?><!DOCTYPE MESSAGE SYSTEM \"http://127.0.0.1/psms/dtd/messagev12.dtd\" ><MESSAGE VER=\"1.2\">"
				+ "<USER USERNAME='infoedgexml1' PASSWORD='info0097' />"
				+ "<SMS UDH=\"0\" CODING=\"1\" TEXT='Naukrigulf site is not responding -  ProjectName :NaukriGulf;  Page:Recruiter;  Exception:RCODE MID:91' PROPERTY=\"0\" ID=\"2\">"
				+ "<ADDRESS FROM='NKGULF' TO='918860568578' SEQ=\"1\" TAG='NKGULF' /></SMS></MESSAGE>";
		Response res = req.queryParam("action", "send").queryParam("data", data).get();
		System.out.println(res.asString());
		System.out.println("lala");
	}

	/**
	 * unit can be imperial, metric and standard
	 * 
	 * For temperature in Fahrenheit use units=imperial For temperature in Celsius
	 * use units=metric For temperature in Kelvin use units=standard
	 * 
	 * @param cityName
	 * @param unit
	 * @return
	 */

	public String getWeatherDetailsOfCity(String cityName, String unit) {
		RestAssured.baseURI = "http://api.openweathermap.org/data/2.5/";
		RequestSpecification request = RestAssured.given();

		return request.queryParam("q", cityName).queryParam("appid", apiKey).queryParam("units", unit).get("/find")
				.asString();
	}

	public String getWeatherDetailsOfCityInDegree(String cityName) {
		return getWeatherDetailsOfCity(cityName, "metric");
	}

	public String getWeatherDetailsOfCityInFahrenheit(String cityName) {
		return getWeatherDetailsOfCity(cityName, "imperial");
	}

}
