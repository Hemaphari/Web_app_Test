package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class HomepageTest extends TestBase{
	LoginPage LoginPageObj;
	HomePage Homepageobj;
	TestUtil Testutilobj;
	ContactsPage contactspageobj;
	public HomepageTest() {
		super();//this will call super class ie baseclass constructor
	}
	//testcase must be independent, so launch browser before each test, then close it after each test
	@BeforeMethod
	public void setup() {
		initialization();
		LoginPageObj=new LoginPage();
		Testutilobj=new TestUtil();
		contactspageobj=new ContactsPage();
		Homepageobj=LoginPageObj.login_action(prop.getProperty("username"), prop.getProperty("password"));
	}
	@Test(priority=1)
	public void verifypage_titletest(){
		String Home_title=Homepageobj.verifyhomepagetile();
		Assert.assertEquals(Home_title, "CRMPRO","Home page title not matched");
		
	}
	@Test(priority=2)
	public void verify_usernameTest() {
		
		Testutilobj.switchto_frame();// user name has written in a frame. so need to switch to frame. 
		//written common function in TetUtil class to switch to a frame
		Assert.assertTrue(Homepageobj.verify_username());
	}
	@Test(priority=3)
	public void clickon_contactslink() {
		Testutilobj.switchto_frame();
		contactspageobj=Homepageobj.click_contactslink();
		
	}
	
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
}
