package com.example.tests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class iframe {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver;
		driver = new FirefoxDriver();
		driver.get("http://toolsqa.com/iframe-practice-page/");
		driver.manage().window().maximize();
		//driver.switchTo().frame(0);
		//System.out.println("Inside frame 0 ");
		//driver.switchTo().frame("IF1");
		//System.out.println("Inside Frame 1");
		//driver.switchTo().frame("iframe1");
		//System.out.println("Inside frame ");
		WebElement myframe = driver.findElement(By.xpath("//*[@id='IF1']"));
		driver.switchTo().frame(myframe);
		System.out.println("Inside frame");
		driver.switchTo().parentFrame();
		List<WebElement> myFrame = driver.findElements(By.tagName("iFrame"));
		System.out.println("Frame size " + myFrame.size());
	}

}
