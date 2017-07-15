package com.project.automationPrac.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.selenium.library.BasePage;

public class CreateNewUser extends BasePage{
	public CreateNewUser waitUntilPageLoad()
	{
		WebElement elemnt =myLib.fluentWait(By.cssSelector("#submitAccount"));
		Assert.assertNotNull(elemnt);
		return this;
	}
	
	public CreateNewUser fillForm()
	{
		WebElement fName=driver.findElement(By.cssSelector("#customer_firstname"));
		fName.sendKeys("Raja");
		WebElement lName=driver.findElement(By.cssSelector("#customer_lastname"));
		lName.sendKeys("Khan");
		WebElement passWrd=driver.findElement(By.cssSelector("#passwd"));
		passWrd.sendKeys("password");
		dropDown("#days", "option[value='2']");
		dropDown("#months", "option[value='2']");
		dropDown("#years", "option[value='1960']");
		WebElement address=driver.findElement(By.cssSelector("#address1"));
		address.sendKeys("PO BOX 123");
		WebElement city=driver.findElement(By.cssSelector("#city"));
		city.sendKeys("Ashburn");
		dropDown("#id_state", "option[value='46']");
		WebElement zip=driver.findElement(By.cssSelector("#postcode"));
		zip.sendKeys("20127");
		WebElement mob=driver.findElement(By.cssSelector("#phone_mobile"));
		mob.sendKeys("1112223344");
		WebElement aliasAdrs=driver.findElement(By.cssSelector("#alias"));
		aliasAdrs.clear();
		aliasAdrs.sendKeys("123 get");
		WebElement regBtn=driver.findElement(By.cssSelector("#submitAccount"));
		//regBtn.click();
		
		return this;
	}
	public CreateNewUser SignOut()
	{
		WebElement signOutBtn=driver.findElement(By.cssSelector(".logout"));
		signOutBtn.click();
		
		return this;
	}


/////////////////////////////////helper

private void dropDown(String by, String by1)
{
	WebElement elm=driver.findElement(By.cssSelector(by));
	elm.findElement(By.cssSelector(by1)).click();	
}
}