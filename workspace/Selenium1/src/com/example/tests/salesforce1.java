package com.example.tests;
import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class salesforce1  {
	  private static WebDriver driver;
	  private String baseUrl;
	  private boolean acceptNextAlert = true;
	  private StringBuffer verificationErrors = new StringBuffer();
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.gecko.driver", "E:/suchi/Abhi_Training/Selenium/geckodriver.exe");
	    driver = new FirefoxDriver();
	    driver.get("https://login.salesforce.com");
	    WebElement username = driver.findElement(By.xpath("//input[@id='username']"));
	    username.sendKeys("kk.suchithra@gmail.com");
	    WebElement password = driver.findElement(By.id("password"));
	    password.sendKeys("Rithesh12");
	    WebElement login = driver.findElement(By.id("Login"));
	    login.click();
	    Thread.sleep(1000);
	    driver.findElement(By.linkText("Remind Me Later")).click();
	    driver.findElement(By.id("userNavLabel")).click();
	    driver.findElement(By.linkText("Logout")).click();
	    
	    
	    driver.close();
	}

}
