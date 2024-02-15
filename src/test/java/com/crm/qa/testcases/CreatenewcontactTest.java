package com.crm.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
//import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.Createnewcontact_page;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
//import com.crm.qa.pages.PipeLinePage;
import com.crm.qa.util.TestUtil;

public class CreatenewcontactTest extends TestBase {
	LoginPage Loginpageobj;
	HomePage Homepageobj;
	TestUtil testutilobj;
	Createnewcontact_page newcontactobj;
	String sheetname="contacts";
	public CreatenewcontactTest() {
		super();
	}
	@BeforeMethod
	public void setup() {
		initialization();
		testutilobj=new TestUtil();
		//System.out.println("Before");
		//System.out.println( testutilobj.getName() );
		//System.out.println("After");
		Loginpageobj=new LoginPage();
		Homepageobj=new HomePage();
		newcontactobj=new Createnewcontact_page();
		Homepageobj=Loginpageobj.login_action(prop.getProperty("username"), prop.getProperty("password"));
		testutilobj.switchto_frame();
		newcontactobj=Homepageobj.clickon_newcontactslink();
	
}
	
	@Test(priority=1)
	public void createcontact() {
		Homepageobj.clickon_newcontactslink();
		newcontactobj.create_newcontact("Mr.", "alan", "ganesh");
	}
	@DataProvider
	public Object[][] getCRMTestData(){
		Object data[][] = TestUtil.getTestData(sheetname);
		return data;
	}
	@Test(priority=2, dataProvider="getCRMTestData")
	public void validateCreateNewContact(String title, String firstName, String lastName){
		Homepageobj.clickon_newcontactslink();
		//contactsPage.createNewContact("Mr.", "Tom", "Peter", "Google");
		newcontactobj.create_newcontact(title, firstName, lastName);
		
	}
	
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
		

}
