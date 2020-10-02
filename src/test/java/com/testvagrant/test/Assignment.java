package com.testvagrant.test;

import org.testng.annotations.Test;

public class Assignment extends BaseTest {
	
	@Test
	public void openWebsite() {
		driver.get("https://www.ndtv.com/");
	}
  

  
}
