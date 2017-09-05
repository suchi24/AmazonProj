package com.example.tests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class webTable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver", "E:/suchi/Abhi_Training/Selenium/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://money.rediff.com/gainers/bsc/daily/groupa");
		WebElement table = driver.findElement(By.xpath("//*[@class='dataTable']"));
		
		List<WebElement> rows = table.findElements(By.tagName("tr"));
		
		for (int rownum = 0; rownum < rows.size(); rownum++){
			List<WebElement> header = rows.get(rownum).findElements(By.tagName("th"));
			for (int head = 0; head < header.size(); head++){
				System.out.print(header.get(head).getText() + " ");
			}
			header = rows.get(rownum).findElements(By.tagName("td"));
			for (int head = 0; head < header.size(); head++) {
				System.out.print(header.get(head).getText() + " ");
			}
			System.out.println("");
		}
	}

}
