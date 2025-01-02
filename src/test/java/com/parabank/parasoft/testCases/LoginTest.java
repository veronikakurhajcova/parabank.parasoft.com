package com.parabank.parasoft.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.parabank.parasoft.base.Base;
import com.parabank.parasoft.pages.AccountOverviewPage;
import com.parabank.parasoft.pages.HomePage;

public class LoginTest extends Base {
	HomePage homePage;
	AccountOverviewPage accountOverviewPage;

	public LoginTest() throws IOException {
		super();
	}

	@BeforeMethod
	public void setup() {
		driver = initializeBrowserAndOpenApplicationUrl(configProp.getProperty("browserName"));
		homePage = new HomePage(driver);
		accountOverviewPage = new AccountOverviewPage(driver);
	}

	@Test
	public void TC_01_loginWithValidCredentials() {
		homePage.loginUser(dataProp.getProperty("username"), dataProp.getProperty("password"));
		Assert.assertTrue(accountOverviewPage.successfullyAccountHeadlineIsDisplayed(),
				"Successfully account headline is not displayed");
	}

	@Test
	public void TC_02_loginWithInvalidUsername() {
		homePage.loginUser(dataProp.getProperty("invalidUsername"), dataProp.getProperty("password"));
		Assert.assertFalse(accountOverviewPage.successfullyAccountHeadlineIsDisplayed(),
				"Account login with invalid username should fail, but it succeeded");
	}

	@Test
	public void TC_03_loginWithInvalidPassword() {
		homePage.loginUser(dataProp.getProperty("username"), dataProp.getProperty("invalidPassword"));
		Assert.assertFalse(accountOverviewPage.successfullyAccountHeadlineIsDisplayed(),
				"Account login with invalid password should fail, but it succeeded");
	}

	@Test
	public void TC_04_loginWithEmptyCredentials() {
		homePage.loginUser("", "");
		Assert.assertTrue(homePage.emptyUsernameAndPasswordErrorTextIsDisplayed(),
				"Error: The error message was not displayed when empty credentials were provided.");
	}

	public void TC_05_loginWithEmptyUsername() {
		homePage.loginUser(dataProp.getProperty("username"), "");
		Assert.assertTrue(homePage.emptyUsernameAndPasswordErrorTextIsDisplayed(),
				"Error: The error message was not displayed when empty username is provided.");
	}

	public void TC_06_loginWithEmptyPassword() {
		homePage.loginUser("", dataProp.getProperty("password"));
		Assert.assertTrue(homePage.emptyUsernameAndPasswordErrorTextIsDisplayed(),
				"Error: The error message was not displayed when empty password is provided.");
	}

	@AfterMethod
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}

}
