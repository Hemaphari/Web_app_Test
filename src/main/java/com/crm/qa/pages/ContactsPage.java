package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase {
	@FindBy(xpath="//title[text()='CRMPRO']") WebElement Cotactspage_title;
	@FindBy(xpath="//a[text()='Pipeline']") WebElement Pipelink_link;
	public ContactsPage() {
		PageFactory.initElements(driver, this);
	}
	public String verify_pagetitle() {
		String contactspagetitle=driver.getTitle();
		return contactspagetitle;
	}
	public PipeLinePage click_pipelinelink() {
		Pipelink_link.click();
		return new PipeLinePage();
	}

}
