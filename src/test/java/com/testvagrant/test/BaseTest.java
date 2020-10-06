package com.testvagrant.test;


import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;

import com.testvagrant.web.HandleDriver;

public class BaseTest {
	
	HandleDriver handleDriver = new HandleDriver();
	WebDriver driver;
	Properties prop = new Properties();
	InputStream input;

}
