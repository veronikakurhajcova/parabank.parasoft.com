package com.parabank.parasoft.helpers;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitHelper {
	
	private WebDriver driver;
	
	public WaitHelper(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement waitForElementToBeClicable(WebElement element, int timeInSeconds) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeInSeconds));
		return wait.until(ExpectedConditions.elementToBeClickable(element));
	}

}
