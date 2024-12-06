package com.parasoft.parabank.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {
	public WebDriver driver;
	Properties prop;
	
	//RegisterForm
	@FindBy(id="customer.firstName")
	private WebElement txtFirstName;
	
	@FindBy(id="customer.lastName")
	private WebElement txtLastName;
	
	@FindBy(id="customer.address.street")
	private WebElement txtAddress;
	
	@FindBy(id="customer.address.city")
	private WebElement txtCity;
	
	@FindBy(id="customer.address.state")
	private WebElement txtState;
	
	@FindBy(id="customer.address.zipCode")
	private WebElement txtZipCode;
	
	@FindBy(id="customer.phoneNumber")
	private WebElement txtPhoneNumber;
	
	@FindBy(id="customer.ssn")
	private WebElement txtSsn;
	
	@FindBy(id="customer.username")
	private WebElement txtUsername;
	
	@FindBy(id="customer.password")
	private WebElement txtPassword;
	
	@FindBy(id="repeatedPassword")
	private WebElement txtConfirmPassword;
	
	@FindBy(xpath="//input[contains(@value, 'Register')]")
	private WebElement btnRegister;
	
	@FindBy(xpath="//p[contains(text(),'account')]")
	private WebElement successfullAccountMsg;
	
	public RegisterPage(WebDriver driver, Properties prop) {
		this.driver = driver;
		this.prop=prop;
		PageFactory.initElements(driver, this);
	}
	
	public void fillRegisterForm() {
		txtFirstName.sendKeys(prop.getProperty("firstName"));
		txtLastName.sendKeys(prop.getProperty("lastName"));
		txtAddress.sendKeys(prop.getProperty("address"));
		txtCity.sendKeys(prop.getProperty("city"));
		txtState.sendKeys(prop.getProperty("state"));
		txtZipCode.sendKeys(prop.getProperty("zipCode"));
		txtPhoneNumber.sendKeys(prop.getProperty("phone"));
		txtSsn.sendKeys(prop.getProperty("ssn"));
		txtUsername.sendKeys(prop.getProperty("username"));
		txtPassword.sendKeys(prop.getProperty("password"));
		txtConfirmPassword.sendKeys(prop.getProperty("confirmPassword"));
		btnRegister.click();
	}
	
	public boolean isSuccessAccountMsgVisible() {
		boolean textMsgVisible = successfullAccountMsg.isDisplayed();
		return textMsgVisible;
	}
	
	

}
