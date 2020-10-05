package com.testvagrant.test;


import com.testvagrant.utils.HandleDriver;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;

public class BaseTest {
	
	HandleDriver handleDriver = new HandleDriver();
	WebDriver driver;
	Properties prop = new Properties();
	InputStream input;

}
