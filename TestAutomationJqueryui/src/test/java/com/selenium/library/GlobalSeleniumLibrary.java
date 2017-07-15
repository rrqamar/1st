package com.selenium.library;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.internal.WrapsDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;

import com.google.common.base.Function;

public class GlobalSeleniumLibrary {
	private WebDriver driver;

	/***
	 * This is the Constructor(no return,same name as class)
	 * 
	 * @param _driver
	 */
	public GlobalSeleniumLibrary(WebDriver _driver) {
		driver = _driver;
	}

	/**
	 * This method will launch Chrome Browser
	 * 
	 * @return Driver
	 */
	public WebDriver startChromeBrowser() {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
		// System.setProperty("", value)
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		// driver.manage().window().fullscreen();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		return driver;
	}

	/***
	 * This method will delay next step,by seconds,
	 * 
	 * @param n
	 */
	public void customeWate(int n) {
		try {
			Thread.sleep(n * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	/***
	 * This method enters text to the text field
	 * @param by
	 * @param textValve
	 */
	public void enterText(By by, String textValve){
		WebElement textField=driver.findElement(by);
		textField.clear();
		textField.sendKeys(textValve);
	}
	/***
	 * This will select drop-down element for given drop-down value
	 * @param by
	 * @param optionValve
	 */
	public void selectDropDown(By by,String optionValve)
	{
		WebElement dropDownElm=driver.findElement(by);
		Select dropDown=new Select(dropDownElm);
		dropDown.selectByVisibleText(optionValve);
	}
	
	public void customWait(int n) {
		try {
			Thread.sleep(n * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

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
	/***
	 * This is a dynamic wait. User can use it when switch browser windows. When
	 * web-page synchronization happens.
	 * 
	 * @param by
	 * @return
	 */
	public WebElement fluentWait(final By by) {
		WebElement targetElem = null;
		try {
			Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(60, TimeUnit.SECONDS)
					.pollingEvery(3, TimeUnit.SECONDS).ignoring(NoSuchElementException.class);

			targetElem = wait.until(new Function<WebDriver, WebElement>() {
				public WebElement apply(WebDriver driver) {

					return driver.findElement(by);
				}
			});
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		//highlightElement(targetElem);
		return targetElem;
	}
	
	/***
	 * This is a dynamic wait. User can use it when switch browser windows. When
	 * web-page synchronization happens.
	 * 
	 * @param by
	 * @return
	 */
	public WebElement fluentWait(final WebElement element){
		WebElement targetElem = null;
		try {
			Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(60, TimeUnit.SECONDS)
					.pollingEvery(3, TimeUnit.SECONDS).ignoring(NoSuchElementException.class);

			targetElem = wait.until(new Function<WebDriver, WebElement>() {
				public WebElement apply(WebDriver driver) {

					return element;
				}
			});
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		highlightElement(targetElem);
		return targetElem;
	}
	
	
	

}
