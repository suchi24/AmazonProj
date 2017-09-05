package com.example.tests;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class SalesLogin1 {
	private WebDriver driver;
	private String baseUrl;
	private boolean acceptNextAlert = true;
	private StringBuffer verificationErrors = new StringBuffer();

	@Before
	public void setUp() throws Exception {
		/*driver = new FirefoxDriver();
		System.setProperty("webdriver.gecko.driver", "E:/suchi/Abhi_Training/Selenium/geckodriver.exe");
		baseUrl = "https://login.salesforce.com/";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);*/
	}

	@Test
	public void testSalesLogin1() throws Exception {
		
		System.setProperty("webdriver.gecko.driver", "E:/suchi/Abhi_Training/Selenium/geckodriver.exe");
		driver = new FirefoxDriver();
	    driver.get("login.salesforce.com");
	    WebElement username = driver.findElement(By.id("username"));
	    username.sendKeys("suchi@gmail.com");
	    
	
		driver.get("https://login.salesforce.com");
		driver.findElement(By.id("username")).clear();
		driver.findElement(By.id("username")).sendKeys("kk.suchithra@gmail.com");
		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("password")).sendKeys("Rithesh12");
		driver.findElement(By.id("Login")).click();
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
		String verificationErrorString = verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			fail(verificationErrorString);
		}
	}

	private boolean isElementPresent(By by) {
		try {
			driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	private boolean isAlertPresent() {
		try {
			driver.switchTo().alert();
			return true;
		} catch (NoAlertPresentException e) {
			return false;
		}
	}

	private String closeAlertAndGetItsText() {
		try {
			Alert alert = driver.switchTo().alert();
			String alertText = alert.getText();
			if (acceptNextAlert) {
				alert.accept();
			} else {
				alert.dismiss();
			}
			return alertText;
		} finally {
			acceptNextAlert = true;
		}
	}
}
