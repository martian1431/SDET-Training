package com.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Q. How to mark any method as part of test?
 * @Test:	Marks a class or a method as part of the test.
 * 
 * Q. Commonly used assert methods to assert the result?
 * Assert.assertEquals(actual, expected);
 * Assert.assertNotEquals(actual, expected);
 * Assert.assertTrue(condition);
 * Assert.assertFalse(condition);
 * Assert.assertNull(object);
 * Assert.assertNotNull(object);	
 */
public class TestNGDemo {
	
	@Test
	void calcTest() {
		System.setProperty("webdriver.chrome.driver", "Driver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://www.google.com");
        
        //WebElement element = driver.findElement(By.id("lst-ib"));
        WebElement element = driver.findElement(By.name("q")); 
        element.sendKeys("2 + 3");
        element.submit();
        
        WebElement result = driver.findElement(By.id("cwos"));
        Assert.assertEquals(result.getText(), "5");
        // close browser
        driver.close();
	
	}
}
