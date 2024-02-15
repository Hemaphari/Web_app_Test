package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.PipeLinePage;
import com.crm.qa.util.TestUtil;

public class ContactspageTest extends TestBase {
	LoginPage Loginpageobj;
	HomePage Homepageobj;
	ContactsPage contactspageobj;
	TestUtil testutilobj;
	PipeLinePage pipelinepageobj;
	public ContactspageTest() {
		super();
	}
	@BeforeMethod
	public void setup() {
		initialization();
		Loginpageobj=new LoginPage();
		Homepageobj=new HomePage();
		contactspageobj=new ContactsPage();
		testutilobj=new TestUtil();
		pipelinepageobj=new PipeLinePage();
		Homepageobj=Loginpageobj.login_action(prop.getProperty("username"), prop.getProperty("password"));
		testutilobj.switchto_frame();
		contactspageobj=Homepageobj.click_contactslink();
		}
	@Test(priority=1)
	public void verifycontactspage_title() {
		
		String title=contactspageobj.verify_pagetitle();
		Assert.assertEquals(title, "CRMPRO");
	}
	
	@Test(priority=2)
	public void verify_pipeline_link() {
		pipelinepageobj=contactspageobj.click_pipelinelink();	
			
	}
	
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
		
	}
	


