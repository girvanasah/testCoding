package com.testvagrant.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.testvagrant.utils.GenericFunctions;
import com.testvagrant.web.BaseUI;

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
	
	
	
	public void deleteDoc(String title) {
		String moreIcone = "//div[text()='%s']/ancestor::tr[contains(@class,'ant-table-row-level-0')]//td[contains(@class,'ant-table-cell-fix-right')]//div[contains(@class,'ant-dropdown-trigger')]";
		String deleteDoc = "//li[@role='menuitem' and text()='Delete document']";
		String okBtn = "//button[@type='button']//span[text()='OK']";
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement moreIcon = driver.findElement(By.xpath(String.format(okBtn, title)));
		
		wait.until(ExpectedConditions.elementToBeClickable(moreIcon));
		moreIcon.click();
		
		WebElement deleteDocument = driver.findElement(By.xpath(deleteDoc));
		wait.until(ExpectedConditions.elementToBeClickable(deleteDocument));
		deleteDocument.click();

		WebElement okButton = driver.findElement(By.xpath(okBtn));
		wait.until(ExpectedConditions.elementToBeClickable(okButton));
		okButton.click();
		
		System.out.println("Document deleted with title: " +title );
	}
	
	
}
