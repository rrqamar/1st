package com.project.automationPrc.Test;

import org.testng.annotations.Test;

import com.project.automationPrac.Pages.ContactUsPage;
import com.project.automationPrac.Pages.CreateNewUser;
import com.project.automationPrac.Pages.IndexPage;
import com.project.automationPrac.Pages.SignInPage;
import com.project.automationPrac.Pages.WomenPage;
import com.selenium.library.BasePage;


public class AutomationPracMainTest extends BasePage{
	IndexPage myIndexPage = new IndexPage();
	ContactUsPage myContactPage= new ContactUsPage();
	WomenPage myWomenPage=new WomenPage();
	SignInPage mySignInPage=new SignInPage();
	CreateNewUser myNewUser=new CreateNewUser();
	
	
	@Test (priority =1, enabled=false)
	public void contacUs()
	{
		myIndexPage.goto_Website();
		myIndexPage.waitUntilPageLoad();
		myIndexPage.ContactUs();
		myContactPage.waitUntilPageLoad("#submitMessage");
		myContactPage.subjectHeading("cust");
		myContactPage.enterEmail("g@gmail.com");
		myContactPage.enterOrderRef("Test101");
		myContactPage.enterMessage("testing message for contact us page");
		myLib.customeWate(1);
		myContactPage.sendBtn();
		myContactPage.waitUntilPageLoad(".alert.alert-success");
		myContactPage.sentVerification();
		
	}
	@Test (priority =1, enabled=true)
	public void signIn_newuser()
			{
//		myIndexPage.women();
//		myWomenPage.waitUntilPageLoad("#ul_layered_id_attribute_group_1");
//		myWomenPage.selectSize("l");
//		myWomenPage.dressColor("Pi");
		myIndexPage.goto_Website();
		myIndexPage.signIn();
		mySignInPage.waitUntilPageLoad();
		mySignInPage.newUserEmail();
		myNewUser.waitUntilPageLoad();
		myNewUser.fillForm();
		
		
		
	}

}
