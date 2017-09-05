package com.example.tests;
import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
public class sfMySettings {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver;
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
	    if (driver.findElement(By.linkText("Remind Me Later")).isDisplayed()) {
	    	driver.findElement(By.linkText("Remind Me Later")).click();
	    }
	    driver.findElement(By.id("userNavLabel")).click();
	    WebElement profile = driver.findElement(By.xpath("//*[@id='userNav-menuItems']/a[text()='My Settings']"));
	    profile.click();
	    Thread.sleep(1000);
	    WebElement personal = driver.findElement(By.id("PersonalInfo_font"));
	    personal.click();
	    Thread.sleep(1000);
	    WebElement loginhistory =  driver.findElement(By.id("LoginHistory_font"));
	    loginhistory.click();
	    Thread.sleep(1000);
	    WebElement download = driver.findElement(By.xpath("//*[@id='RelatedUserLoginHistoryList_body']//*[contains(text(),'Download')]"));
	    download.click();
	    Thread.sleep(1000);
	    WebElement display = driver.findElement(By.id("DisplayAndLayout_font"));
	    display.click();
	    Thread.sleep(1000);
	    WebElement custom = driver.findElement(By.id("CustomizeTabs_font"));
	    custom.click();
	    
	    
	}

}
