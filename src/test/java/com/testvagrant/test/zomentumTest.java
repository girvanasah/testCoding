package com.testvagrant.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class zomentumTest {

	WebDriver driver;
	String username = "naveen+june18@zomentum.com";
	String GeckoDriverPath = "C:\\Common_Resources\\jars\\geckodriver.exe";
	String pass = "Test@123";
	WebDriverWait wait;
	
	
	@BeforeTest
	public void startDriver() {
		System.setProperty("webdriver.gecko.driver", GeckoDriverPath);
		driver = new FirefoxDriver();
		driver.manage().window().fullscreen();
		wait = new WebDriverWait(driver, 10);
	}
	
	@Test
	public void addProduct() {
		driver.get("https://dashboard.channelforcestage.com/login");
		WebElement signInButton = driver.findElement(By.xpath("//button[@type = 'submit' and contains(@class,'signin-button')]"));
		wait.until(ExpectedConditions.elementToBeClickable(signInButton));
		signInButton.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username")));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("username")));
		WebElement usernameEle = driver.findElement(By.id("username"));
		usernameEle.click();
		usernameEle.clear();
		usernameEle.sendKeys(username);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password")));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("password")));
		WebElement passwordEle = driver.findElement(By.id("password"));
		passwordEle.click();
		passwordEle.clear();
		passwordEle.sendKeys(pass);
		
		WebElement contButton = driver.findElement(By.xpath("//button[text()='Continue']"));
		wait.until(ExpectedConditions.elementToBeClickable(contButton));
		contButton.click();
		
		String doc = "//li[contains(@class,'ant-menu-item')]//div[contains(@class,'menu-item-container')]//*[contains(@href,'file')]";
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(doc)));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(doc)));
		driver.findElement(By.xpath(doc)).click();		
	}

}
