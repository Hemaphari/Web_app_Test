package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class LoginpageTest extends TestBase{
	LoginPage LoginPageObj;
	HomePage HomePageObj;
	public LoginpageTest() {
		super();//this will call super class ie baseclass constructor
	}
	@BeforeMethod
	public void setup() {
		initialization();
		LoginPageObj=new LoginPage();	
	}
	@Test(priority=1)
	public void logipage_titletest() {
		String title=LoginPageObj.verify_pagetitle();
		Assert.assertEquals(title, "Free CRM software for customer relationship management, sales, and support.");
	}
	@Test(priority=2)
	public void loginTest() {
		HomePageObj=LoginPageObj.login_action(prop.getProperty("username"), prop.getProperty("password"));
	}
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
	

}
