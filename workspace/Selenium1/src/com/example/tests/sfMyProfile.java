package com.example.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class sfMyProfile {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver","E:/suchi/Abhi_Training/Selenium/chromedriver.exe");
		driver = new ChromeDriver();
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
	    driver.switchTo().frame("contactInfoContentId");
	    
		
	}

}
