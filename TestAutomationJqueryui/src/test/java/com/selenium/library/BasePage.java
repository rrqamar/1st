package com.selenium.library;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BasePage {

	public static WebDriver driver;
	public static GlobalSeleniumLibrary myLib;
	
	@BeforeMethod
	public void setup()
	{
		myLib= new GlobalSeleniumLibrary(driver);
		driver=myLib.startChromeBrowser();	
	}
	
	@AfterMethod
	public void teardown() throws Exception {
		Thread.sleep(3*1000);
			driver.close();
			driver.quit();
			
		}
}
