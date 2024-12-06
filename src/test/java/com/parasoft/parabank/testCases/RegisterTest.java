package com.parasoft.parabank.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.parasoft.parabank.base.Base;
import com.parasoft.parabank.pages.IndexPage;
import com.parasoft.parabank.pages.RegisterPage;

public class RegisterTest extends Base {
	
	public RegisterTest() throws IOException {
		super();
	}
	
	IndexPage indexPage;
	RegisterPage registerPage;
	
	@BeforeTest
	public void setUp() {
		driver = initializeBrowserAndOpenUrl(prop.getProperty("browser"));
		indexPage = new IndexPage(driver);
		registerPage = new RegisterPage(driver,prop);	
	}

	@Test
	public void validRegistration() {
		indexPage.clickRegisterBtn();
		registerPage.fillRegisterForm();
		Assert.assertTrue(registerPage.isSuccessAccountMsgVisible(), "Registration was not successfull");
	}
	
	@AfterTest
	public void tearDown() {
		if(driver != null) {
			driver.quit();
		}
	}
	
	
}
