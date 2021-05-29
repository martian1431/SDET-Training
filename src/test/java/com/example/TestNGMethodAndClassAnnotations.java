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
import org.testng.annotations.Test;

/**
 * Q. Describe the following Annotations and usage scenarios? 
 * 
 * @BeforeMethod: The annotated method runs before each test method.
 * @AfterMethod:  The annotated method runs after each test method. 
 * @BeforeClass:  The annotated method runs before the first test method and once per class.
 * @AfterClass:   The annotated method runs after the last test method and once per class.
 * 
 */
public class TestNGMethodAndClassAnnotations {
	
	WebDriver driver;
	
	@BeforeClass
	void setUpClass() { // 1 time
		System.setProperty("webdriver.chrome.driver", "Driver/chromedriver.exe");
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
	
	@Test
	void calcTest() {
		//WebElement element = driver.findElement(By.id("lst-ib"));
		WebElement element = driver.findElement(By.name("q")); 
        element.sendKeys("2 + 3");
        element.submit();
        
        WebElement result = driver.findElement(By.id("cwos"));
        Assert.assertEquals(result.getText(), "5");
	}
	
	@Test
	void calcTest2() {
		//WebElement element = driver.findElement(By.id("lst-ib"));
		WebElement element = driver.findElement(By.name("q")); 
        element.sendKeys("sqrt 16");
        element.submit();
        
        WebElement result = driver.findElement(By.id("cwos"));
        Assert.assertEquals(result.getText(), "4");
	}
	
}