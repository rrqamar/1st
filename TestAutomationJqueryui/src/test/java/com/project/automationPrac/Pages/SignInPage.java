package com.project.automationPrac.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.selenium.library.BasePage;

public class SignInPage extends BasePage{
	public SignInPage verifyTitle()
	{
		String pageTitle = driver.getTitle();
		System.out.println("Website Title: " + pageTitle);
		Assert.assertEquals(pageTitle, "Login - My Store");
		return this;
	}
	public SignInPage waitUntilPageLoad()
	{
		WebElement elemnt =myLib.fluentWait(By.cssSelector("#create-account_form"));
		Assert.assertNotNull(elemnt);
		return this;
	}
	
	public SignInPage newUserEmail()
	{
		WebElement email=driver.findElement(By.cssSelector("#email_create"));
		email.sendKeys("raja_ga@gmail.com");
		WebElement creatAcBtn=driver.findElement(By.cssSelector("#SubmitCreate"));
		myLib.customeWate(1);
		creatAcBtn.click();
		
		return this;
	}

}
