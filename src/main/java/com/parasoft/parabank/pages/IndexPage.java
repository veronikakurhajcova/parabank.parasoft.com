package com.parasoft.parabank.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class IndexPage {
	public WebDriver driver;
	
	//Registration
	@FindBy(xpath="//a[text()='Register']")
	private WebElement registerBtn;

	public IndexPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void registerUser() {
		registerBtn.click();
	}
	
	
}
