package com.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * 
 *
 */
public class TestNGParallelTests2 {
	
	@BeforeClass
	void setUpClass() { 
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\phmalope\\devProjects\\Driver\\chromedriver.exe");
	}
	
	@Test
	void searchTest() {   
        WebDriver driver = new ChromeDriver();
        driver.get("http://www.google.com");
        
        WebElement element = driver.findElement(By.name("q"));
        element.sendKeys("Selenium WebDriver");
        element.submit();
        
        Assert.assertTrue(driver.getTitle().startsWith("Selenium WebDriver"));
        driver.quit();
	}
}
