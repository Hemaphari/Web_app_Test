package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.TestBase;

public class Createnewcontact_page extends TestBase{
	@FindBy(xpath="//select[@name='title']") WebElement title;
	@FindBy(xpath="//input[@id='first_name']") WebElement firstname;
	@FindBy(xpath="//input[@id='surname']") WebElement lastname;
	@FindBy(xpath="//*[@id=\"contactForm\"]/table/tbody/tr[1]/td/input[2]") WebElement save; 
	public Createnewcontact_page() {
		PageFactory.initElements(driver, this);
	}
	public void create_newcontact(String tle, String fname,String Lname) {
		Select select=new Select(title);
		select.selectByVisibleText(tle);
		firstname.sendKeys(fname);
		lastname.sendKeys(Lname);
		save.click();
		
	}

}
