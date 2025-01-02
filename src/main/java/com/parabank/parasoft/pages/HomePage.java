package com.parabank.parasoft.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.parabank.parasoft.helpers.WaitHelper;
import com.parabank.parasoft.utils.Utilities;

public class HomePage {
	WebDriver driver;
	WaitHelper waitHelper;
	
	//Register section
	
	@FindBy(xpath="//a[text()='Register']")
	private WebElement registerButton;
	
	//Login section
	
	@FindBy(name="username")
	private WebElement loginUsernameField;
	
	@FindBy(name="password")
	private WebElement loginPasswordField;
	
	@FindBy(xpath="//input[@value='Log In']")
	private WebElement loginButton;
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		waitHelper = new WaitHelper(driver);
	}
	
	public void registrationUser() {
		waitHelper.waitForElementToBeClicable(registerButton, Utilities.IMPLICIT_WAIT_TIME_FOR_ELEMENT);
		registerButton.click();
	}
	
	public void loginUser(String username, String password) {
		loginUsernameField.sendKeys(username);
		loginPasswordField.sendKeys(password);
		loginButton.click();
	}

	
	
	
	

}
