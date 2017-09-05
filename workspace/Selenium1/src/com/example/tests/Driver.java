package com.example.tests;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;



public class Driver {

	static WebDriver driver;
	static String chromeBrowser;
	static String firefoxBrowser;
	static String IEBrowser;
	static String SafariBrowser;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		//AutomationScript.SearchIphone();
		String dt_path = "E:/ExcelFiles/TestSuite.xls";
		
		String [][] recData = ReusableMethod.readExcelSheet(dt_path,"Sheet1");
		for (int i=1; i< recData.length; i++) {
			String execute = recData[i][1];
			System.out.println(execute);
			chromeBrowser = recData[i][3];
			firefoxBrowser = recData[i][4];
			IEBrowser = recData[i][5];
			SafariBrowser = recData[i][6];
			if (execute.equalsIgnoreCase("Y")){
			  try{
					//System.setProperty("webdriver.chrome.driver","E:/suchi/Abhi_Training/Selenium/chromedriver.exe");
				    if (firefoxBrowser.equalsIgnoreCase("Y")) {
						System.setProperty("webdriver.gecko.driver", "F:/Drivers/geckodriver/geckodriver.exe");
				    	driver = new FirefoxDriver();
				    } else if (chromeBrowser.equalsIgnoreCase("Y")){
				    	driver = new ChromeDriver();
				    } else if (IEBrowser.equalsIgnoreCase("Y")) {
				    	
				    	File file = new File("F:/Drivers/IEDriver/IEDriverServer.exe");
				    	System.setProperty("webdriver.ie.driver", file.getAbsolutePath());
				    	driver = new InternetExplorerDriver();
				    } else if (SafariBrowser.equalsIgnoreCase("Y")) {
				    	System.setProperty("webdriver.safari.driver","F:/Drivers/safari/SafariDriver.safariextz.exe");
				    	
				    	driver = new SafariDriver();
				    	
				    }
				    
					String testcase = recData[i][2];
					Method tc = AutomationScript.class.getMethod(testcase);
					tc.invoke(tc);
			  } catch(Exception e){
				  System.out.println(e.getMessage());
			  }
				
			}
		}
		//AutomationScript.SearchIphone();
		//AutomationScript.checkMainTab();
		//AutomationScript.departmentDropdown();
		//AutomationScript.signInAccount();
		//AutomationScript.allMenu();
		//AutomationScript.emptyCartValidate();
		//AutomationScript.HelpMenuValidate();
		//AutomationScript.SearchAndAddQuantity();
		//AutomationScript.SearchDropDown();
		//AutomationScript.updateQty();
		
	}

}
