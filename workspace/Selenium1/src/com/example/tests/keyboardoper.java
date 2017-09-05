package com.example.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.HasInputDevices;
import org.openqa.selenium.interactions.Keyboard;
import org.openqa.selenium.Keys; 
public class keyboardoper {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver", "E:/suchi/Abhi_Training/Selenium/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://login.salesforce.com");
		driver.manage().window().maximize();
		WebElement username = driver.findElement(By.id("username"));
		
		Keyboard keyboard = ((HasInputDevices)driver).getKeyboard();
		keyboard.pressKey("a");
		keyboard.pressKey("b");
		keyboard.pressKey("c");
		keyboard.pressKey(Keys.NUMPAD1);
		keyboard.pressKey(Keys.chord("x","y","z"));
		keyboard.pressKey(Keys.chord(Keys.CONTROL,"t"));
		keyboard.pressKey(Keys.F5);
		
		
		
	}

}
