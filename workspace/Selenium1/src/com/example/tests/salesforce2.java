package com.example.tests;
import java.util.regex.Pattern;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

//import com.gargoylesoftware.htmlunit.javascript.host.Set;
import java.util.Set;
//import java.lang.*;


public class salesforce2 {
	  	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		WebDriver driver;
		//String baseUrl;
		//boolean acceptNextAlert = true;
        //StringBuffer verificationErrors = new StringBuffer();
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
	    WebElement profile = driver.findElement(By.xpath("//*[@id='userNav-menuItems']/a[text()='My Profile']"));
	    profile.click();
	    Thread.sleep(1000);
	    driver.findElement(By.xpath("//*[@id='chatterTab']//*[@alt='Edit Profile']")).click();
	    Thread.sleep(2000);
	    //WebDriverWait wait = new WebDriverWait(driver, 60);// 1 minute 
	    //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='contactInfoTitle']")));
	    //Set<String> windowId = driver.getWindowHandles();    // get  window id of current window
        //Iterator<String> itererator = windowId.iterator();   

        //String mainWinID = itererator.next();
        //String  newAdwinID = itererator.next();

        //driver.switchTo().window(newAdwinID);
        //System.out.println("Admin ID " + driver.getTitle());
        //Thread.sleep(3000);
        //driver.close();
//
        //driver.switchTo().window(mainWinID);
        //System.out.println("Main Window ID " + driver.getTitle());
	    //if (driver.findElement(By.xpath("//*[@id='aboutTab']")).isDisplayed()) {
	    //	driver.findElement(By.xpath("//*[@id='aboutTab']")).click();
	    	
	    }
	    
	    
	    
	}

}
