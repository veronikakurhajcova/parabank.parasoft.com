package com.parabank.parasoft.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.parabank.parasoft.base.Base;
import com.parabank.parasoft.pages.HomePage;
import com.parabank.parasoft.pages.RegisterPage;

public class RegisterTest extends Base {
	HomePage homePage;
	RegisterPage registerPage;

	public RegisterTest() throws IOException {
		super();
	}

	@BeforeMethod
	public void setup() {
		initializeBrowserAndOpenApplicationUrl(configProp.getProperty("browserName"));
		homePage = new HomePage(driver);
		registerPage = new RegisterPage(driver);
	}

	@Test
	public void TC_01_registerWithValidCredentials() {
		homePage.registrationUser();
		registerPage.registerNewUser(dataProp.getProperty("firstName"), dataProp.getProperty("lastName"),
				dataProp.getProperty("address"), dataProp.getProperty("city"), dataProp.getProperty("state"),
				dataProp.getProperty("zipCode"), dataProp.getProperty("phone"), dataProp.getProperty("ssn"),
				dataProp.getProperty("username"), dataProp.getProperty("password"),
				dataProp.getProperty("confirmPassword"));

		Assert.assertTrue(registerPage.successfullyAccountMessageIsDisplayed(),
				"Successfully account message is not displayed");
	}

	@Test
	public void TC_02_registerWithInvalidUserName() {
		homePage.registrationUser();
		registerPage.registerNewUser(dataProp.getProperty("firstName"), dataProp.getProperty("lastName"),
				dataProp.getProperty("address"), dataProp.getProperty("city"), dataProp.getProperty("state"),
				dataProp.getProperty("zipCode"), dataProp.getProperty("phone"), dataProp.getProperty("ssn"),
				dataProp.getProperty("invalidUsername"), dataProp.getProperty("password"),
				dataProp.getProperty("confirmPassword"));
		Assert.assertTrue(registerPage.errorUserRegisterMessageIsDisplayed(),
				"Error Registration message is not displayed");
	}

	@Test
	public void TC_03_registerWithInvalidPassword() {
		homePage.registrationUser();
		registerPage.registerNewUser(dataProp.getProperty("firstName"), dataProp.getProperty("lastName"),
				dataProp.getProperty("address"), dataProp.getProperty("city"), dataProp.getProperty("state"),
				dataProp.getProperty("zipCode"), dataProp.getProperty("phone"), dataProp.getProperty("ssn"),
				dataProp.getProperty("invalidUsername"), dataProp.getProperty("invalidPassword"),
				dataProp.getProperty("confirmPassword"));

		Assert.assertTrue(registerPage.errorUserRegisterMessageIsDisplayed(),
				"Error Registration message is not displayed");
	}
	
	@Test
	public void TC_04_registerWithEmptyCredentials() {
		homePage.registrationUser();
		registerPage.registerNewUserWithEmptyFields();
		Assert.assertTrue(registerPage.allErrorMessagesAreDisplayed(), "Error Messages are not displayed");
	}
	
	@AfterMethod
	public void tearDown() {
		if(driver != null) {
			driver.quit();
		}
	}
		
	

}
