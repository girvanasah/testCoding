package com.testvagrant.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.testvagrant.utils.BaseUI;
import com.testvagrant.utils.GenericFunctions;

public class NDTVHomePage extends BaseUI {
	
	WebDriver driver;
	GenericFunctions generic;
	WebDriverWait wait;
	
	public NDTVHomePage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		this.generic = new GenericFunctions(driver);
		this.wait = new WebDriverWait(driver, 10);
	}
	
	
	public static String topNavMoreLnk = "//a[@id='h_sub_menu']";
	public static String menuOptionLnk = "//a[text()='%s']";
	public static String closeNotifLnk = "//a[@class='notnow']";
	
	public void openNotificationPopUpIfPresent() {
		generic.waitForCompletePageLoad();
		if(getElements(closeNotifLnk).size() > 0)
			clickElementUsingExplicitWait(closeNotifLnk);
	}
	
	public void openTopNavMoreOptions() {
		openNotificationPopUpIfPresent();
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
