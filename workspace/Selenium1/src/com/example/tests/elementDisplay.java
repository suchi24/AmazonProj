package com.example.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class elementDisplay {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver","E:/suchi/Abhi_Training/Selenium/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://login.salesforce.com");
		
		WebElement userName = driver.findElement(By.xpath("//input[@id='username']"));
		enterText(userName,"kk.suchithra@gmail.com","username");
		/*if (userName.isDisplayed()){
			userName.sendKeys("kk.suchithra@gmail.com");
			System.out.println("Pass : username is correct");
		} else {
			System.out.println("Fail : username is incorrect");
		}
		*/
		WebElement password = driver.findElement(By.xpath("//input[@id='password']"));
		enterText(password,"Rithesh12","password");
		/*if (password.isDisplayed()){
			password.sendKeys("Rithesh12");
			System.out.println("Pass : password is correct");
		} else {
			System.out.println("Fail : password is incorrect");
		}
		*/
		WebElement login= driver.findElement(By.id("Login"));
		clicklogin(login, "login");
		

	}
	public static void enterText(WebElement obj, String textVal, String objName){
		if (obj.isDisplayed()){
			obj.sendKeys(textVal);
			System.out.println("Pass : " + textVal + " is entered in " + objName + " field");
		} else {
			System.out.println("Fail : " + objName + " is entered in ");
		}
	}
	public static void clicklogin(WebElement obj, String objName){
		if (obj.isDisplayed()){
			obj.click();
			System.out.println("Pass : " + objName + " is clicked");
		} else {
			System.out.println("Login is not clicked");
		}
	}
}
