package com.parabank.parasoft.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.parabank.parasoft.utils.Utilities;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {
	
	public static WebDriver driver;
	public Properties configProp;
	public Properties dataProp;
	
	public Base() throws IOException {
		configProp = new Properties();
		File configFile = new File(System.getProperty("user.dir") + "\\src\\test\\resources\\configuration.properties");
		
		FileInputStream fis;
		try {
			fis = new FileInputStream(configFile);
			configProp.load(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		dataProp = new Properties();
		File dataFile = new File(System.getProperty("user.dir") + "\\src\\test\\resources\\dataTest.properties");
		
		FileInputStream dataFis;
		try{
			dataFis = new FileInputStream(dataFile);
			dataProp.load(dataFis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public WebDriver initializeBrowserAndOpenApplicationUrl(String browserName) {
		if(browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--disable-search-engine-choice-screen");
			driver = new ChromeDriver(options);
		} 
		else if(browserName.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver",
					"C:\\Users\\Veronika\\Downloads\\geckodriver-v0.35.0-win64 (1)\\geckodriver.exe");
			driver = new FirefoxDriver();
		} 
		else if(browserName.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Utilities.IMPLICIT_WAIT_TIME));
		driver.get(configProp.getProperty("url"));
		
		return driver;
	}
	

}
