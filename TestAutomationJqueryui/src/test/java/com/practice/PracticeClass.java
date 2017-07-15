package com.practice;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PracticeClass {
	public static void main(String[] args)
	{
		System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		driver.get("http://toolsqa.wpengine.com/");
		
		List<WebElement> links=driver.findElements(By.tagName("a"));
		System.out.println("total links on this page:" + links.size());
		for(int i=1;i<=links.size(); i=i+1)
		{
			System.out.println(links.get(i).getText());
		}
		
	driver.quit();	
	}
	

}
