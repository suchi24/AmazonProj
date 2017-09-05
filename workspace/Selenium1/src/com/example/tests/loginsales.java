package com.example.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class loginsales {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		WebDriver driver;
		driver = new FirefoxDriver();
		driver.get("https://login.salesforce.com/");
		
		WebElement user = driver.findElement(By.id("username"));
		user.click();
		user.sendKeys("abc");
		String username1 = user.getAttribute("value");
		System.out.println("username " + username1);
		WebElement passwd = driver.findElement(By.id("password"));
		passwd.sendKeys("def");
		String password1 = passwd.getAttribute("value");
		System.out.println("password " + password1);
		WebElement login = driver.findElement(By.id("Login"));
		login.click();
		
		WebElement err = driver.findElement(By.id("error"));
		String errormsg = err.getText();
		System.out.println(errormsg);
		
		String idvalue = err.getAttribute("id");
		System.out.println("id name " + idvalue);
		String classvalue = err.getAttribute("class");
		System.out.println("class name " + classvalue);
		String stylevalue = err.getAttribute("style");
		System.out.println("style value " + stylevalue);
		
	}

}
