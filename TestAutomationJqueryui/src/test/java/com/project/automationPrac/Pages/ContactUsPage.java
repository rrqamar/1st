package com.project.automationPrac.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.selenium.library.BasePage;


public class ContactUsPage extends BasePage{
	public ContactUsPage verifyTitle()
	{
		String pageTitle = driver.getTitle();
		System.out.println("Website Title: " + pageTitle);
		Assert.assertEquals(pageTitle, "Contact us - My Store");
		return this;
	}
	/***
	 * This will get css valve as input string, for wait verify page load
	 * @param cssString
	 * @return
	 */
	public ContactUsPage waitUntilPageLoad(String cssString)
	{
		WebElement elemnt =myLib.fluentWait(By.cssSelector(cssString));
		Assert.assertNotNull(elemnt);
		return this;
	}
	/***
	 * this select Subject Heading
	 * @param type cust=customer service, web=Webmaster
	 * @return
	 */
	public ContactUsPage subjectHeading(String type)
	{
		//select subject heading
		WebElement subject=driver.findElement(By.id("id_contact"));
		subject.click();
		myLib.customeWate(1);
		if(type=="cust" || type=="Cust" || type=="CUST")
		{
		subject.findElement(By.cssSelector("option[value='2']")).click();
		}else if(type=="web" || type=="Web" || type=="WEB")
		{
			subject.findElement(By.cssSelector("option[value='1']")).click();
		}
	return this;	
	}
		/***
		 * This method to enter email
		 * @param email
		 * @return
		 */
		public ContactUsPage enterEmail(String email)
		{
		WebElement emailFld=driver.findElement(By.cssSelector("#email"));
		emailFld.click();
		emailFld.clear();
		emailFld.sendKeys(email);
		return this;
		}
		
		public ContactUsPage enterOrderRef(String orderReff)
		{
		WebElement orderReffFld=driver.findElement(By.cssSelector("#id_order"));
		orderReffFld.click();
		orderReffFld.clear();
		orderReffFld.sendKeys(orderReff);
		return this;
		}
		
		public ContactUsPage enterMessage(String message)
		{
		WebElement messageBox=driver.findElement(By.cssSelector("#message"));
		messageBox.click();
		messageBox.clear();
		messageBox.sendKeys(message);
		return this;
		}
		
		public ContactUsPage sendBtn()
		{
			WebElement sendBtn=driver.findElement(By.cssSelector("#submitMessage"));
			sendBtn.click();
			return this;
		}
		
		public ContactUsPage sentVerification()
		{
			WebElement mesg=driver.findElement(By.cssSelector(".alert.alert-success"));
			String textMesg=mesg.getText();
			Assert.assertEquals(textMesg, "Your message has been successfully sent to our team.");
			
			return this;
		}
		

	

}
