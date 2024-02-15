package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase {
	@FindBy(xpath="//td[contains(text(),'User: Hema p')]")
	@CacheLookup // will create a cachee memory for the web element and store details. so nxt time whill 
	//callin the the element driver will refer this cache. it can speedup the process of testing.
	WebElement username;
	@FindBy(xpath="//a[text()='Contacts']") WebElement contactslink;
	@FindBy(xpath="//a[text()='New Contact']") WebElement newcontactslink;
	@FindBy(xpath="//a[text()='Deals']") WebElement dealslink;
	//initialize pagefactory
		public HomePage() {
			PageFactory.initElements(driver, this); 
			//all above mentioned objects in this class has been initialized with this driver
		}
		public String verifyhomepagetile() {
			return driver.getTitle();
		}
		public boolean verify_username() {
			return username.isDisplayed();
		}
		public ContactsPage click_contactslink() {
			contactslink.click();
			return new ContactsPage();
		}
		public Createnewcontact_page clickon_newcontactslink() {
			//to hover over a field use Actions class
			Actions act=new Actions(driver);
			act.moveToElement(contactslink).build().perform();
			newcontactslink.click();
			return new Createnewcontact_page();
		}
		public DealsPage click_dealslink() {
			dealslink.click();
			return new DealsPage();
		}


}
