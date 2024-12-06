package com.parasoft.parabank.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class IndexPage {
    WebDriver driver;
    Properties prop;
	
	//Registration
	@FindBy(linkText="Register")
    private WebElement registerBtn;

	public IndexPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public RegisterPage clickRegisterBtn() {
		registerBtn.click();
		return new RegisterPage(driver, prop);
	}
}
