package com.parabank.parasoft.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountOverviewPage {
	WebDriver driver;
	
	@FindBy(xpath="//h1[@class='title' and contains(text(), 'Accounts Overview')]")
	private WebElement successfullyAccountText;
	
	public AccountOverviewPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public boolean successfullyAccountHeadlineIsDisplayed() {
		boolean successAccountMessage = successfullyAccountText.isDisplayed();
		return successAccountMessage;
	}

}
