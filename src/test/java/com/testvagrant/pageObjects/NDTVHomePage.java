package com.testvagrant.pageObjects;

import org.openqa.selenium.WebDriver;

import com.testvagrant.utils.BaseUI;
import com.testvagrant.utils.GenericFunctions;

public class NDTVHomePage extends BaseUI {
	
	WebDriver driver;
	GenericFunctions generic;
	
	public NDTVHomePage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		this.generic = new GenericFunctions(driver);
		
	}
	
	
	public static String topNavMoreLnk = "//a[@id='h_sub_menu']";
	public static String menuOptionLnk = "//a[text()='%s']";
	
	
	
	public void openTopNavMoreOptions() {
		generic.waitForCompletePageLoad();
		clickElementUsingExplicitWait(topNavMoreLnk);
		generic.waitForCompletePageLoad();
	}
	
	public void clickOnOptionFromTopNavBar(String option) {
		generic.waitForCompletePageLoad();
		clickElementUsingExplicitWait(String.format(menuOptionLnk, option));
		generic.waitForCompletePageLoad();
	}
	
}
