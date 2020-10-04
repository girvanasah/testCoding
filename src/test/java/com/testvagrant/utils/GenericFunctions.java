package com.testvagrant.utils;

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
		 }
		 catch (Exception ex) {
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

}
