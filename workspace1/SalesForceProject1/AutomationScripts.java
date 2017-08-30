

import org.junit.*;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

public class AutomationScripts extends ReUsableMethods{
	public static WebDriver driver;


	
	public static void SFDCLogin() throws Exception {



		/* Launch a Browser*/
		System.setProperty("webdriver.gecko.driver", "C:/Users/Abhis_lw0caw1/Google Drive/July 10 2017/July 10 2017 Read Only/Framework/Lib/geckodriver.exe");
		driver = new FirefoxDriver(); 

		/*Launch URL*/
		driver.get("https://login.salesforce.com/");

		/*Enter UserName CMMI-5 level coding std*/
		WebElement userName = driver.findElement(By.xpath("//input[@id='username']"));
		enterText(userName, "User@gmail.com", "UserName");
		
//		
//		if(userName.isDisplayed()){
//			userName.sendKeys("User@gmail.com");
//			System.out.println("Pass: Username is entered in username field");
//		}else{
//			System.out.println("Fail: UserName field is not displayed,please check your application");
//		}

		/*Enter Password*/
		WebElement password = driver.findElement(By.xpath("//input[@id='password']"));
		enterText(password, "Password123", "Password");
		
		
//		if(password.isDisplayed()){
//			password.sendKeys("password123");
//			System.out.println("Pass: password is entered in password field");
//		}else{
//			System.out.println("Fail: password field is not displayed,please check your application");
//		}

		WebElement loginButton = driver.findElement(By.xpath("//input[@id='Login']"));
		clickButton(loginButton, "Login");


	}

	public static void validateErrorMessage(){
		
	}







}
