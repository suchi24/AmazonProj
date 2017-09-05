package com.example.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.util.Set;

public class switchWindow {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver;
		driver = new FirefoxDriver();
		driver.get("http://toolsqa.com/automation-practice-switch-windows/");
		driver.manage().window().maximize();
		WebElement btn = driver.findElement(By.id("button1"));
		btn.click();
		String oldwindow = driver.getWindowHandle();
		Set<String> getAllWindows = driver.getWindowHandles();
		String[] getWindow = getAllWindows.toArray(new String[getAllWindows.size()]);
		for (String window : getWindow) {
			driver.switchTo().window(window);
		    driver.get("https://www.google.com");
		    driver.manage().window().maximize();
		}
		System.out.println(driver.getCurrentUrl());
		//driver.switchTo().window(getWindow[0]);
		driver.switchTo().window(oldwindow);
		System.out.println(driver.getCurrentUrl());
		driver.close();
	}

}
