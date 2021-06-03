package com.example;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class BaseTest {
	private static List<WebDriver> driverPool = new ArrayList<WebDriver>();
	
	@BeforeSuite
	void setUpSuite() {//load config files, open DB conn's, setup logging
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\phmalope\\devProjects\\Driver\\chromedriver.exe");
//		System.setProperty("webdriver.gecko.driver", "/Users/shaan/Downloads/geckodriver");
	}
	
	WebDriver getDriver() {//method overloading
		return getDriver(BrowserType.CHROME, "https://www.google.com");
	}
	
	WebDriver getDriver(BrowserType type, String baseURL) {	
		WebDriver driver = DriverFactory.getInstance().getDriver(type);
		driverPool.add(driver);
		driver.get(baseURL);
		return driver;
	}
	
	@AfterSuite
	void tearDownSuite() {//close files, DB conn's etc
		for (WebDriver webDriver : driverPool) {
			//webDriver.quit();
		}
	}

}
