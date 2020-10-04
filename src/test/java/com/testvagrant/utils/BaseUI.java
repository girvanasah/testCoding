package com.testvagrant.utils;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseUI {

	WebDriver driver;
	WebDriverWait wait;

	public BaseUI(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, 10);
	}

	public WebElement getElement(By loactor) {
		WebElement ele = driver.findElement(loactor);
		return ele;
	}

	public WebElement getElement(String xpath) {
		WebElement ele = driver.findElement(By.xpath(xpath));
		return ele;
	}
	
	public List<WebElement> getElements(By loactor) {
		List<WebElement> ele = driver.findElements(loactor);
		return ele;
	}

	public List<WebElement> getElements(String xpath) {
		List<WebElement> ele = driver.findElements(By.xpath(xpath));
		return ele;
	}

	public void clickElementUsingExplicitWait(String xpath) {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
		driver.findElement(By.xpath(xpath)).click();
		GenericFunctions.logMessage("Clicked on element");
	}

	public void clickElementUsingExplicitWait(By locator) {
		wait.until(ExpectedConditions.elementToBeClickable(locator));
		driver.findElement(locator).click();
		GenericFunctions.logMessage("Clicked on element");
	}
	
	public void fillText(String xpath, String text) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
		driver.findElement(By.xpath(xpath)).sendKeys(text);
		GenericFunctions.logMessage("Filled Text: "+ text);
	}
	
	public void fillText(By locator, String text) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		driver.findElement(locator).sendKeys(text);
		GenericFunctions.logMessage("Filled Text: "+ text);
	}


}
