package com.testvagrant.utils;

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

}
