package com.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * Q. How to run tests with different data sets?
 * @DataProvider: Marks a method as data provider. Use this method to provide different sets of data.
 * a. First the method providing the data must be annotated with @Dataprovider and return an Object[][]
 * b. The @Test method must use dataProvider name same as above dataProvider's name
 *
 */
public class TestNGDataprovider {
	
	WebDriver driver;
	
	@BeforeClass
	void setUpClass() { // 1 time
		System.setProperty("webdriver.chrome.driver", "/Users/shaan/Downloads/chromedriver");
	}
	
	@AfterClass
	void tearDownClass() { // 1 time
		System.clearProperty("webdriver.chrome.driver");
	}
	
	@BeforeMethod
	void setUpMethod() { // 2 times
        driver = new ChromeDriver();
        driver.get("http://www.google.com");
	}
	
	@AfterMethod
	void tearDownMethod() { // 2 times
		driver.quit();
	}
		
	@Test(dataProvider = "calc-data", dataProviderClass = testng.TestData.class)
	void calcTest(String input, String expected) {
		//WebElement element = driver.findElement(By.id("lst-ib"));
		WebElement element = driver.findElement(By.name("q")); 
        element.sendKeys(input);
        element.submit();
        
        WebElement result = driver.findElement(By.id("cwos"));
        Assert.assertEquals(result.getText(), expected);
	}
	
}