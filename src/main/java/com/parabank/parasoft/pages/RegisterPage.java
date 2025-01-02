package com.parabank.parasoft.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {
	WebDriver driver;

	//Register Fields
	
	@FindBy(id = "customer.firstName")
	private WebElement userFirstNameField;

	@FindBy(id = "customer.lastName")
	private WebElement userLastNameField;

	@FindBy(id = "customer.address.street")
	private WebElement userAddressField;

	@FindBy(id = "customer.address.city")
	private WebElement userCityField;

	@FindBy(id = "customer.address.state")
	private WebElement userStateField;

	@FindBy(id = "customer.address.zipCode")
	private WebElement userZipCodeField;

	@FindBy(id = "customer.phoneNumber")
	private WebElement userPhoneNumberField;

	@FindBy(id = "customer.ssn")
	private WebElement userSsnField;

	@FindBy(id = "customer.username")
	private WebElement usernameField;

	@FindBy(id = "customer.password")
	private WebElement userPasswordField;

	@FindBy(id = "repeatedPassword")
	private WebElement userConfirmPasswordField;
	
	@FindBy(xpath="//input[@value='Register']")
	private WebElement registerSubmitButton;
	
	@FindBy(xpath="//p[text()='Your account was created successfully. You are now logged in.']")
	private WebElement successfullyAccountText;
	
	//Register errors messages
	
	@FindBy(id="customer.firstName.errors")
	private WebElement firstNameErrorText;
	
	@FindBy(id="customer.lastName.errors")
	private WebElement lastNameErrorText;
	
	@FindBy(id="customer.address.street.errors")
	private WebElement addressErrorText;
	
	@FindBy(id="customer.address.city.errors")
	private WebElement cityErrorText;
	
	@FindBy(id="customer.address.state.errors")
	private WebElement stateErrorText;
	
	@FindBy(id="customer.address.zipCode.errors")
	private WebElement zipCodeErrorText;
	
	@FindBy(id="customer.ssn.errors")
	private WebElement ssnErrorMessage;
	
	@FindBy(id = "customer.username.errors")
	private WebElement errorUserRegistrationText;
	
	@FindBy(id="customer.password.errors")
	private WebElement errorUserPasswordRegistrationText;
	
	@FindBy(id="repeatedPassword.errors")
	private WebElement errorUserConfirmPasswordRegistrationText;
	
	@FindBy(xpath="//span[@class='error']")
	private WebElement allErrorMessages;

	public RegisterPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void registerNewUser(String firstName, String lastName, String address, String city, String state,
			String zipCode, String phone, String ssn, String username, String password, String confirmPassword) {
		userFirstNameField.sendKeys(firstName);
		userLastNameField.sendKeys(lastName);
		userAddressField.sendKeys(address);
		userCityField.sendKeys(city);
		userStateField.sendKeys(state);
		userZipCodeField.sendKeys(zipCode);
		userPhoneNumberField.sendKeys(phone);
		userSsnField.sendKeys(ssn);
		usernameField.sendKeys(username);
		userPasswordField.sendKeys(password);
		userConfirmPasswordField.sendKeys(confirmPassword);
		registerSubmitButton.click();
	}
	
	public void registerNewUserWithEmptyFields() {
		userFirstNameField.sendKeys("");
		userLastNameField.sendKeys("");
		userAddressField.sendKeys("");
		userCityField.sendKeys("");
		userStateField.sendKeys("");
		userZipCodeField.sendKeys("");
		userPhoneNumberField.sendKeys("");
		userSsnField.sendKeys("");
		usernameField.sendKeys("");
		userPasswordField.sendKeys("");
		userConfirmPasswordField.sendKeys("");
		registerSubmitButton.click();
	}
	
	public boolean successfullyAccountMessageIsDisplayed() {
		boolean successAccountMessage = successfullyAccountText.isDisplayed();
		return successAccountMessage;
	}
	
	public boolean errorUserRegisterMessageIsDisplayed() {
		boolean errorMessage = errorUserRegistrationText.isDisplayed();
		return errorMessage;
	}
	
	public boolean allErrorMessagesAreDisplayed() {
		boolean errorMessages = allErrorMessages.isDisplayed();
		return errorMessages;
	}

}
