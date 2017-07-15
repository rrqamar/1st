package com.project.parkingCalc;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.internal.WrapsDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.selenium.library.BasePage;

public class ParkingCalculator extends BasePage{
	//private WebDriver driver;

//	@BeforeMethod
//	public void setup() {
//		System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
//		// System.setProperty("", value)
//		driver = new ChromeDriver();
//		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//		// driver.manage().window().fullscreen();
//		driver.manage().window().maximize();
//		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
//	}

	@Test
	public void parkingCalac() {

		driver.get("http://adam.goucher.ca/parkcalc/");
		customWait(2);

		/// Test case#1 Short-Term Parking AM rate calculating
		selectTerm("Short-Term Parking");
		inTimeDate("10:00", "am", "5/19/2017");
		outTimeDate("11:00", "am", "5/19/2017");
		calcBtn();
		customWait(1);
		System.out.println(result());
		Assert.assertEquals("$ 2.00", result());
		
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("alert('hello');" );
		
		
		
		/// Test case#2 Short-Term Parking PM rate calculating
		selectTerm("Short-Term Parking");
		inTimeDate("02:00", "pm", "5/19/2017");
		outTimeDate("11:00", "pm", "5/19/2017");
		calcBtn();
		customWait(1);
		System.out.println(result());
		Assert.assertEquals("$ 18.00", result());
		
		/// Test case#3 Economy Parking AM rate calculating
		selectTerm("Economy Parking");
		inTimeDate("08:00", "am", "5/19/2017");
		outTimeDate("10:30", "am", "5/19/2017");
		calcBtn();
		/// Test case#4 Economy Parking PM rate calculating
		selectTerm("Economy Parking");
		inTimeDate("06:00", "pm", "5/19/2017");
		outTimeDate("11:30", "pm", "5/19/2017");
		calcBtn();
		
		/// Test case#5 Long-Term Surface Parking AM rate calculating
		selectTerm("Long-Term Surface Parking");
		inTimeDate("10:00", "am", "5/19/2017");
		outTimeDate("11:00", "am", "5/19/2017");
		calcBtn();
		/// Test case#6 Long-Term Surface Parking PM rate calculating
		selectTerm("Long-Term Surface Parking");
		inTimeDate("02:00", "pm", "5/19/2017");
		outTimeDate("11:00", "pm", "5/19/2017");
		calcBtn();
		
		/// Test case#7 Long-Term Garage Parking AM rate calculating
		selectTerm("Long-Term Garage Parking");
		inTimeDate("08:00", "am", "5/19/2017");
		outTimeDate("10:30", "am", "5/19/2017");
		calcBtn();
		/// Test case#8 Long-Term Garage Parking PM rate calculating
		selectTerm("Long-Term Garage Parking");
		inTimeDate("06:00", "pm", "5/19/2017");
		outTimeDate("11:30", "pm", "5/19/2017");
		calcBtn();
		
		/// Test case#9 Valet Parking AM rate calculating
		selectTerm("Valet Parking");
		inTimeDate("10:00", "am", "5/19/2017");
		outTimeDate("11:00", "am", "5/19/2017");
		calcBtn();
		/// Test case#10 Valet Parking PM rate calculating
		selectTerm("Valet Parking");
		inTimeDate("02:00", "pm", "5/19/2017");
		outTimeDate("11:00", "pm", "5/19/2017");
		calcBtn();
		
		

	}

//	@AfterMethod
//	public void teardown() throws Exception {
//		Thread.sleep(3 * 1000);
//		driver.close();
//		driver.quit();
//
//	}

	/////////////////////////////// Helper///////////////////
	/***
	 * This method will select parking Term
	 * @param parkingTerm
	 */
	public void selectTerm(String parkingTerm)
	{
		WebElement shortTermAM = driver.findElement(By.id("Lot"));
		shortTermAM.click();
		customWait(1);
		Select selectTerm = new Select(shortTermAM);
		selectTerm.selectByVisibleText(parkingTerm);
		customWait(1);
	}
	
	
	/***
	 * this method enter Enter time
	 * @param time
	 * @param amPm
	 * @param date
	 */
	public void inTimeDate(String time,String amPm, String date)
		{
		WebElement inTime=driver.findElement(By.id("EntryTime"));
		inTime.clear();
		inTime.sendKeys(time);
		if(amPm=="am" || amPm== "AM")
		{
		WebElement amPmBtn=driver.findElement(By.cssSelector("input[value='AM']"));
		amPmBtn.click();
		}else
		{
		WebElement amPmBtn=driver.findElement(By.cssSelector("input[value='PM']"));
		amPmBtn.click();
		}
		WebElement inDate=driver.findElement(By.id("EntryDate"));
		inDate.clear();
		inDate.click();
		inDate.sendKeys(date);
		
	}
	/***
	 * This method enter Exit time and date
	 * @param time
	 * @param amPM
	 * @param date
	 */
	public void outTimeDate(String time,String amPM,String date)
	{
		WebElement outTime = driver.findElement(By.id("ExitTime"));
		outTime.clear();
		outTime.sendKeys(time);
		if(amPM=="am" || amPM=="AM"){
		WebElement ampmBtn = driver.findElement(By.xpath("html/body/form/table/tbody/tr[3]/td[2]/font/input[2]"));
		ampmBtn.click();
		}else{
			WebElement ampmBtn = driver.findElement(By.xpath("html/body/form/table/tbody/tr[3]/td[2]/font/input[3]"));
			ampmBtn.click();
		}
		WebElement outDate = driver.findElement(By.id("ExitDate"));
		outDate.clear();
		outDate.click();
		outDate.sendKeys(date);	
		
	}
	/***
	 * click calculate button and highlight result
	 */
	public void calcBtn()
	{
		WebElement calcBtn = driver.findElement(By.cssSelector("input[value='Calculate']"));
		calcBtn.click();
		WebElement result=driver.findElement(By.xpath("html/body/form/table/tbody/tr[4]/td[2]"));
		highlightElement(result);
	}

	public void highlightElement(WebElement element) {
		try {
			for (int i = 0; i < 4; i++) {
				WrapsDriver wrappedElement = (WrapsDriver) element;
				JavascriptExecutor js = (JavascriptExecutor) wrappedElement.getWrappedDriver();
				Thread.sleep(500);
				js.executeScript("arguments[0].setAttribute('style', arguments[1]);", element,
						"color: red; border: 2px solid yellow;");
				Thread.sleep(500);
				js.executeScript("arguments[0].setAttribute('style', arguments[1]);", element, "");
			}
		} catch (Exception e) {

		}
	}
	
	public String result()
	{
		WebElement resultElm=driver.findElement(By.cssSelector(".SubHead>font>b"));
		String result=resultElm.getText();
		return result;
	}

	public void customWait(int n) {
		try {
			Thread.sleep(n * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}


}
