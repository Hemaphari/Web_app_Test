package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase{
//create pagefactory or object repository
	@FindBy(name="username") WebElement username;
	@FindBy(name="password") WebElement password;
	@FindBy(xpath="//input[@type='submit']") WebElement login_button;
	@FindBy(xpath="//a[text()='Sign Up']") WebElement signup_button;
	
	//initialize pagefactory
	public LoginPage() {
		PageFactory.initElements(driver, this); 
		//all above mentioned objects in this class has been initialized with this driver
	}
	
	//Actions:
	public String verify_pagetitle() {
		return driver.getTitle();
		
	}
	public HomePage login_action(String uname, String pword) {
		username.sendKeys(uname);
		password.sendKeys(pword);
		login_button.click();
		return new HomePage(); 
		// while clicking login button it moves to home page. it returns homepage object.
		
	}
}
