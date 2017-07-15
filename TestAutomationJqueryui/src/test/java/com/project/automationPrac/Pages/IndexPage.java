package com.project.automationPrac.Pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.selenium.library.BasePage;


public class IndexPage extends BasePage{
	
	private String indexPageURL = "http://automationpractice.com/index.php";
	
	public IndexPage goto_Website() {
		driver.get(indexPageURL);
		String pageTitle = driver.getTitle();
		System.out.println("Website Title: " + pageTitle);
		Assert.assertEquals(pageTitle, "My Store");
		return this;
	}
	
	public IndexPage waitUntilPageLoad()
	{
		WebElement elemnt =myLib.fluentWait(By.cssSelector(".logo.img-responsive"));
		Assert.assertNotNull(elemnt);
		return this;
	}
	
	public IndexPage ContactUs()
	{
		WebElement contactUsBtn=driver.findElement(By.cssSelector("#contact-link>a"));
		contactUsBtn.click();
		return this;
	}
	
	public IndexPage women()
	{
		WebElement selctCat=driver.
				findElement(By.xpath(".//*[@id='block_top_menu']/ul/li[1]/a"));
		selctCat.click();
		
		
		return this;
	}
	
	public IndexPage signIn()
	{
		WebElement signIn=driver.findElement(By.cssSelector(".login"));
		signIn.click();
		return this;
	}
	
	


}
