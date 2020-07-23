package com.example.tests;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import java.lang.reflect.Method;

public class AutomationScript extends ReusableMethod {

	//public static void main(String[] args) extends ReusableMethod {
		public static WebDriver driver;
		static String oldWindow="";
		static String dt_path = "E:/ExcelFiles/amazon1.xls";
		static String path = "E:/ExcelFiles/TestSuite.xls";
		static String browserType;
		
		//public static void main() throws IOException, Exception {
		public static void SearchIphone() throws IOException, Exception {
			startReport("Amazon Report","C:/Users/KumFamily/Report/");
			
			//String testdata = "E:/ExcelFiles/TestSheet.xls";
			int flag=0;
			
			// TODO Auto-generated method stub
			
			System.out.println("Adding into develop branch");
			String recData[][] = ReusableMethod.readExcelSheet(dt_path,"Sheet1");
			String xlData[][] = ReusableMethod.readExcelSheet(path,"Sheet1");
		
			//driver = new ChromeDriver();
			driver = Driver.driver;
			driver.get("https://amazon.com");
			driver.manage().window().maximize();
			for (int i = 0; i< recData.length; i++){
				for (int j = 0; j < recData[0].length; j++){
					
						if (recData[i][j].toLowerCase().equals("search box") ) {
							System.out.println(recData[i][j]);
						  WebElement elem = ReusableMethod.getLocator(driver,recData[i][j+1],recData[i][j+2]);
						  enterText(elem,"iphone6",recData[i][j]);
						  Thread.sleep(3000);
						}else if (recData[i][j].toLowerCase().equalsIgnoreCase("search button")){
							WebElement elem = ReusableMethod.getLocator(driver,recData[i][j+1],recData[i][j+2]);
							clickButton(elem,recData[i][j]);
							Thread.sleep(3000);
						}else if (recData[i][j].toLowerCase().equalsIgnoreCase("apple iphone6")){
							WebElement elem = ReusableMethod.getLocator(driver,recData[i][j+1],recData[i][j+2]);
							
							Robot robot = new Robot();
							robot.keyPress(KeyEvent.VK_PAGE_DOWN);
							robot.keyRelease(KeyEvent.VK_PAGE_DOWN);
							
							Thread.sleep(1000);
							clickButton(elem,recData[i][j]);
							Thread.sleep(3000);
						}else if (recData[i][j].toLowerCase().equalsIgnoreCase("add to cart")){
							oldWindow = driver.getWindowHandle();
							WebElement elem = ReusableMethod.getLocator(driver,recData[i][j+1],recData[i][j+2]);
							clickButton(elem,recData[i][j]);
							Thread.sleep(3000);
							//driver.switchTo().alert().dismiss();
					    	Set<String> temp = driver.getWindowHandles();
							String actualTitle=null;
							for(String w:temp)
							{
								driver.switchTo().window(w);
								actualTitle = driver.getTitle();
								System.out.println(actualTitle);
								//if (recData[i][j].toLowerCase().equalsIgnoreCase("no thanks")){
								WebElement no_thanks = ReusableMethod.getLocator(driver,"xpath",".//*[@id='siNoCoverage-announce']");
								clickButton(no_thanks,recData[i][j]);
								Thread.sleep(3000);
							}
						}else if (recData[i][j].toLowerCase().equalsIgnoreCase("added to cart")){
							WebElement elem = ReusableMethod.getLocator(driver,recData[i][j+1],recData[i][j+2]);
							if (elem.isDisplayed()) 
								System.out.println("Yes, Added to cart");
							Thread.sleep(3000);
						} 	
					}
				}
			
		driver.close();
		Update_Report( "Fail", "Amazon Search Page",  "Successfully working");	
		if (Driver.chromeBrowser.equals("Y"))
			browserType = "Chrome";
		else if (Driver.firefoxBrowser.equals("Y"))
			browserType = "Firefox";
		else if (Driver.IEBrowser.equals("Y"))
			browserType = "IE";
		else if (Driver.SafariBrowser.equals("Y"))
			browserType = "Safari";
		ReusableMethod.writeExcel(path, "SearchIphone", "Fail", browserType);
		bw.close();
		
		}	

	public static void checkMainTab() throws IOException, Exception{
	
		startReport("Amazon Report","C:/Users/KumFamily/Report/");
		int flag=0;
		String recData[][] = ReusableMethod.readExcelSheet(dt_path,"Sheet1");
		//String xlData[][] = ReusableMethod.readExcelSheet(path,"Sheet1");
	
		driver = new ChromeDriver();
		driver.get("https://amazon.com");
		driver.manage().window().maximize();
		for (int i = 0; i< recData.length; i++){
			for (int j = 0; j < recData[0].length; j++){
				if (recData[i][j].toLowerCase().equals("departments") ) {
				  WebElement elem = ReusableMethod.getLocator(driver,recData[i][j+1],recData[i][j+2]);
				  if (elem.isDisplayed()) {
					  System.out.println("Departments is displayed");
				  } else {
					  System.out.println("Departments is not displayed");
				  }
				  Thread.sleep(3000);
				} else if (recData[i][j].toLowerCase().equals("dep drpdwn") ) {
					  WebElement elem = ReusableMethod.getLocator(driver,recData[i][j+1],recData[i][j+2]);
					  clickButton(elem,recData[i][j]);
					  if (elem.isDisplayed()) {
						  System.out.println("department dropdown is displayed");
					  }else {
						  System.out.println("department dropdown is not displayed");
					  }
						Thread.sleep(3000);
				}else if (recData[i][j].toLowerCase().equals("your amazon") ) {
					  WebElement elem = ReusableMethod.getLocator(driver,recData[i][j+1],recData[i][j+2]);
					  if (elem.isDisplayed()) {
						  System.out.println("your amazon is displayed");
					  }else {
						  System.out.println("your amazon is not displayed");
					  }
					  Thread.sleep(3000);
				}else if (recData[i][j].toLowerCase().equals("todays deals") ) {
					  WebElement elem = ReusableMethod.getLocator(driver,recData[i][j+1],recData[i][j+2]);
					  if (elem.isDisplayed()) {
						  System.out.println("Today's deals is displayed");
					  }else {
						  System.out.println("Today's deals is not displayed");
					  }
					  Thread.sleep(3000);
				}else if (recData[i][j].toLowerCase().equals("appstore") ) {
					  WebElement elem = ReusableMethod.getLocator(driver,recData[i][j+1],recData[i][j+2]);
					  if (elem.isDisplayed()) {
						  System.out.println("Today's deals is displayed");
					  }else {
						  System.out.println("Today's deals is not displayed");
					  }
					  Thread.sleep(3000);
				}
			
			
				
			}
		}
		
		driver.close();
		Update_Report( "Pass", "Search Main Tab Page",  "Successfully working");	
		ReusableMethod.writeExcel(path, "checkMainTab", "Pass", "Chrome");
		bw.close();

	}
	public static void departmentDropdown() throws IOException, Exception{
		
		startReport("Amazon Report","C:/Users/KumFamily/Report/");
		int flag=0;
		String recData[][] = ReusableMethod.readExcelSheet(dt_path,"Sheet1");
		//String xlData[][] = ReusableMethod.readExcelSheet(path,"Sheet1");
	
		driver = new ChromeDriver();
		driver.get("https://amazon.com");
		driver.manage().window().maximize();
		for (int i = 0; i< recData.length; i++){
			for (int j = 0; j < recData[0].length; j++){
				if (recData[i][j].toLowerCase().equals("departments") ) {
				  WebElement elem = ReusableMethod.getLocator(driver,recData[i][j+1],recData[i][j+2]);
				  if (elem.isDisplayed()) {
					  System.out.println("Departments is displayed");
				  } else {
					  System.out.println("Departments is not displayed");
				  }
				  Thread.sleep(3000);
				} else if (recData[i][j].toLowerCase().equals("dep drpdwn") ) {
					  WebElement elem = ReusableMethod.getLocator(driver,recData[i][j+1],recData[i][j+2]);
					  //clickButton(elem,recData[i][j]);
					  Actions action =  new Actions(driver);
					  action.moveToElement(elem).build().perform();
					   Thread.sleep(6000);
				}else if (recData[i][j].toLowerCase().equals("amazon video") ) {
					  WebElement elem = ReusableMethod.getLocator(driver,recData[i][j+1],recData[i][j+2]);
					  if (elem.isDisplayed()) {
						  System.out.println("Amazon video is displayed");
					  }else {
						  System.out.println("Your amazon is not displayed");
					  }
					  Thread.sleep(3000);
				}else if (recData[i][j].toLowerCase().equals("amazon music") ) {
					  WebElement elem = ReusableMethod.getLocator(driver,recData[i][j+1],recData[i][j+2]);
					  if (elem.isDisplayed()) {
						  System.out.println("amazon music is displayed");
					  }else {
						  System.out.println("amazon music is not displayed");
					  }
					  Thread.sleep(3000);
				}else if (recData[i][j].toLowerCase().equals("appstore") ) {
					  WebElement elem = ReusableMethod.getLocator(driver,recData[i][j+1],recData[i][j+2]);
					  if (elem.isDisplayed()) {
						  System.out.println("appstore is displayed");
					  }else {
						  System.out.println("appstore is not displayed");
					  }
					  Thread.sleep(3000);
				}
			
				
			}
		}
		
		driver.close();
		Update_Report( "Pass", "Department Dropdown",  "Successfully working");	
		ReusableMethod.writeExcel(path, "departmentDropdown", "Pass", "Chrome");
		bw.close();

	}

public static void signInAccount() throws IOException, Exception{
		
		startReport("Amazon Report","C:/Users/KumFamily/Report/");
		int flag=0;
		String recData[][] = ReusableMethod.readExcelSheet(dt_path,"Sheet1");
		//String xlData[][] = ReusableMethod.readExcelSheet(path,"Sheet1");
	
		driver = new ChromeDriver();
		driver.get("https://amazon.com");
		driver.manage().window().maximize();
		for (int i = 0; i< recData.length; i++){
			for (int j = 0; j < recData[0].length; j++){
				if (recData[i][j].toLowerCase().equals("signin") ) {
				  WebElement elem = ReusableMethod.getLocator(driver,recData[i][j+1],recData[i][j+2]);
				  Actions action =  new Actions(driver);
				  action.moveToElement(elem).build().perform();
				   Thread.sleep(6000);
				} else if (recData[i][j].toLowerCase().equals("your lists") ) {
					  WebElement elem = ReusableMethod.getLocator(driver,recData[i][j+1],recData[i][j+2]);
					  //clickButton(elem,recData[i][j]);
					  if (elem.isDisplayed()){
						  System.out.println("Your lists is displayed");
					  } else {
						  System.out.println("Your lists is not displayed");
					  }
					   Thread.sleep(3000);
				}else if (recData[i][j].toLowerCase().equals("your account") ) {
					  WebElement elem = ReusableMethod.getLocator(driver,recData[i][j+1],recData[i][j+2]);
					  if (elem.isDisplayed()) {
						  System.out.println("Your account is displayed");
					  }else {
						  System.out.println("Your account is not displayed");
					  }
					  Thread.sleep(3000);
				}else if (recData[i][j].toLowerCase().equals("your order") ) {
					  WebElement elem = ReusableMethod.getLocator(driver,recData[i][j+1],recData[i][j+2]);
					  if (elem.isDisplayed()) {
						  System.out.println("your order is displayed");
					  }else {
						  System.out.println("your order is not displayed");
					  }
					  Thread.sleep(3000);
				}
				
			}
		}
		
		driver.close();
		Update_Report( "Pass", "signInAccount and Lists",  "Successfully working");	
		ReusableMethod.writeExcel(path, "signInAccount", "Pass", "Chrome");
		bw.close();

	}
public static void allMenu() throws IOException, Exception{
	
	startReport("Amazon Report","C:/Users/KumFamily/Report/");
	int flag=0;
	String recData[][] = ReusableMethod.readExcelSheet(dt_path,"Sheet1");
	//String xlData[][] = ReusableMethod.readExcelSheet(path,"Sheet1");

	driver = new ChromeDriver();
	driver.get("https://amazon.com");
	driver.manage().window().maximize();
	for (int i = 0; i< recData.length; i++){
		for (int j = 0; j < recData[0].length; j++){
			if (recData[i][j].toLowerCase().equals("all menu") ) {
			  WebElement elem = ReusableMethod.getLocator(driver,recData[i][j+1],recData[i][j+2]);
			  clickButton(elem, recData[i][j]);
			  Thread.sleep(6000);
			} else if (recData[i][j].toLowerCase().equals("all dept") ) {
				  WebElement elem = ReusableMethod.getLocator(driver,recData[i][j+1],recData[i][j+2]);
				  //clickButton(elem,recData[i][j]);
				  if (elem.isDisplayed()){
					  System.out.println("All Department is displayed");
				  } else {
					  System.out.println("All Department is not displayed");
				  }
				   Thread.sleep(3000);
			}else if (recData[i][j].toLowerCase().equals("alexa skills") ) {
				  WebElement elem = ReusableMethod.getLocator(driver,recData[i][j+1],recData[i][j+2]);
				  if (elem.isDisplayed()) {
					  System.out.println("Alexa skills is displayed");
				  }else {
					  System.out.println("Alexa skills is not displayed");
				  }
				  Thread.sleep(3000);
			}else if (recData[i][j].toLowerCase().equals("amazon devices") ) {
				  WebElement elem = ReusableMethod.getLocator(driver,recData[i][j+1],recData[i][j+2]);
				  if (elem.isDisplayed()) {
					  System.out.println("amazon devices is displayed");
				  }else {
					  System.out.println("amazon devices is not displayed");
				  }
				  Thread.sleep(3000);
			}else if (recData[i][j].toLowerCase().equals("amazon video") ) {
				  WebElement elem = ReusableMethod.getLocator(driver,recData[i][j+1],recData[i][j+2]);
				  if (elem.isDisplayed()) {
					  System.out.println("amazon video is displayed");
				  }else {
					  System.out.println("amazon video is not displayed");
				  }
				  Thread.sleep(3000);
			}else if (recData[i][j].toLowerCase().equals("clothing") ) {
				  WebElement elem = ReusableMethod.getLocator(driver,recData[i][j+1],recData[i][j+2]);
				  if (elem.isDisplayed()) {
					  System.out.println("clothing is displayed");
				  }else {
					  System.out.println("clothing is not displayed");
				  }
				  Thread.sleep(3000);
			}else if (recData[i][j].toLowerCase().equals("women") ) {
				  WebElement elem = ReusableMethod.getLocator(driver,recData[i][j+1],recData[i][j+2]);
				  if (elem.isDisplayed()) {
					  System.out.println("Women Sub Menu is displayed");
				  }else {
					  System.out.println("Women Sub Menu is not displayed");
				  }
				  Thread.sleep(3000);
			}else if (recData[i][j].toLowerCase().equals("men")) {
				  WebElement elem = ReusableMethod.getLocator(driver,recData[i][j+1],recData[i][j+2]);
				  if (elem.isDisplayed()) {
					  System.out.println("Men's sub menu is displayed");
				  }else {
					  System.out.println("Menu's sub menu is not displayed");
				  }
				  Thread.sleep(3000);
			}else if (recData[i][j].toLowerCase().equals("girls") ) {
				  WebElement elem = ReusableMethod.getLocator(driver,recData[i][j+1],recData[i][j+2]);
				  if (elem.isDisplayed()) {
					  System.out.println("Girls sub menu is displayed");
				  }else {
					  System.out.println("Girls sub menu is not displayed");
				  }
				  Thread.sleep(3000);
			}
		}
	}
	
	driver.close();
	Update_Report( "Fail", "All menu dropdown",  "Successfully working");	
	ReusableMethod.writeExcel(path, "allMenu", "Fail", "Chrome");
	bw.close();

}
public static void emptyCartValidate() throws IOException, Exception{
	
	startReport("Amazon Report","C:/Users/KumFamily/Report/");
	int flag=0;
	String recData[][] = ReusableMethod.readExcelSheet(dt_path,"Sheet1");
	//String xlData[][] = ReusableMethod.readExcelSheet(path,"Sheet1");

	driver = new ChromeDriver();
	driver.get("https://amazon.com");
	driver.manage().window().maximize();
	for (int i = 0; i< recData.length; i++){
		for (int j = 0; j < recData[0].length; j++){
			if (recData[i][j].toLowerCase().equals("search box") ) {
			  WebElement elem = ReusableMethod.getLocator(driver,recData[i][j+1],recData[i][j+2]);
			  enterText(elem,"iphone6S",recData[i][j]);
			  Thread.sleep(2000);
			} else if (recData[i][j].toLowerCase().equals("search button") ) {
				  WebElement elem = ReusableMethod.getLocator(driver,recData[i][j+1],recData[i][j+2]);
				  //clickButton(elem,recData[i][j]);
				  clickButton(elem, recData[i][j]);
				  Thread.sleep(3000);
				  WebElement iphone = driver.findElement(By.xpath("//*[@id='result_2']//*[contains(text(),'Apple iPhone 6S 64GB')]"));
				  Actions action = new Actions(driver);
				  action.moveToElement(iphone);
				  iphone.click();
				  //driver.findElement(By.xpath(".//*[@id='result_2']//*[contains(text(),'Apple iPhone 6S 64GB')]"));
			}else if (recData[i][j].toLowerCase().equals("iphone6s64GB") ) {
				System.out.println("64 gb");
				  //WebElement iphone = driver.findElement(By.xpath("//*[@id='result_2']//*[contains(text(),'Apple iPhone 6S 64GB')]"));
				  WebElement iphone = ReusableMethod.getLocator(driver,recData[i][j+1],recData[i][j+2]);
				  Actions action = new Actions(driver);
				  action.moveToElement(iphone);
				  iphone.click();
				  Thread.sleep(4000);
			} else if (recData[i][j].toLowerCase().equals("add to cartubb")){
				  WebElement addtocart = ReusableMethod.getLocator(driver,recData[i][j+1], recData[i][j+2]);
				  //action.moveToElement(addtocart);
				  clickButton(addtocart, recData[i][j]);
				  Thread.sleep(3000);
			 
				  WebElement checkcart = ReusableMethod.getLocator(driver, recData[6][2], recData[6][3]);
				  clickButton(checkcart, recData[6][1]);
				  Thread.sleep(3000);
			}else if (recData[i][j].toLowerCase().equals("delete item") ) {
				  WebElement elem = ReusableMethod.getLocator(driver,recData[i][j+1],recData[i][j+2]);
				  clickButton(elem, recData[i][j]);
				  Thread.sleep(3000);
			} else if (recData[i][j].toLowerCase().equals("verify cart")){
				  WebElement checkcart = ReusableMethod.getLocator(driver, recData[i][j+1], recData[i][j+2]);
				  clickButton(checkcart, recData[i][j]);
				  Thread.sleep(3000);
			}else if (recData[i][j].toLowerCase().equals("empty") ) {
				  WebElement elem = ReusableMethod.getLocator(driver,recData[i][j+1],recData[i][j+2]);
				  if (elem.isDisplayed()) {
					  System.out.println("Cart is Empty");
				  }else {
					  System.out.println("Cart is not Empty");
				  }
				  Thread.sleep(3000);
			}	
			}
	}
	
	driver.close();
	Update_Report( "Pass", "Empty Cart Validation",  "Successfully working");	
	ReusableMethod.writeExcel(path, "emptyCartValidate", "Pass", "Chrome");
	bw.close();

}
public static void HelpMenuValidate() throws IOException, Exception{
	
	startReport("Amazon Report","C:/Users/KumFamily/Report/");
	int flag=0;
	String recData[][] = ReusableMethod.readExcelSheet(dt_path,"Sheet1");
	//String xlData[][] = ReusableMethod.readExcelSheet(path,"Sheet1");

	driver = new ChromeDriver();
	driver.get("https://amazon.com");
	driver.manage().window().maximize();
	for (int i = 0; i< recData.length; i++){
		for (int j = 0; j < recData[0].length; j++){
			if (recData[i][j].toLowerCase().equals("help menu") ) {
			  WebElement elem = ReusableMethod.getLocator(driver,recData[i][j+1],recData[i][j+2]);
			  clickButton(elem,recData[i][j]);
			  Thread.sleep(2000);
			} else if (recData[i][j].toLowerCase().equals("heading help") ) {
				  WebElement elem = ReusableMethod.getLocator(driver,recData[i][j+1],recData[i][j+2]);
				  if (elem.isDisplayed()){
					  System.out.println("Heading Help is displayed");
				  } else {
					  System.out.println("Heading help is not displayed");
				  }
				  Thread.sleep(3000);
			} else if (recData[i][j].toLowerCase().equals("Help-Your orders") ) {
				  WebElement elem = ReusableMethod.getLocator(driver,recData[i][j+1],recData[i][j+2]);
				  if (elem.isDisplayed()){
					  System.out.println("Help your order is displayed");
				  }else {
					  System.out.println("Help your order is not displayed");
				  }
				  
				  Thread.sleep(4000);
			} else if (recData[i][j].toLowerCase().equals("return and refund")){
				  WebElement elem = ReusableMethod.getLocator(driver,recData[i][j+1], recData[i][j+2]);
				  if (elem.isDisplayed()){
					  System.out.println("Return and Refund is displayed");
				  }else {
					  System.out.println("Return and refund is not displayed");
				  }
				  
				  //action.moveToElement(addtocart);
				  Thread.sleep(3000);
			 }else if (recData[i][j].toLowerCase().equals("device support") ) {
				  WebElement elem = ReusableMethod.getLocator(driver,recData[i][j+1],recData[i][j+2]);
				  if (elem.isDisplayed()){
					  System.out.println("Device support is displayed");
				  } else {
					  System.out.println("Device support is not displayed");
				  }
				  Thread.sleep(3000);
			} else if (recData[i][j].toLowerCase().equals("search icon")){
				  WebElement elem = ReusableMethod.getLocator(driver, recData[i][j+1], recData[i][j+2]);
				  if (elem.isDisplayed()){
					  System.out.println("Search icon is visible");
				  }else {
					  System.out.println("Search icon is not visible");
				  }
				  
				  Thread.sleep(3000);
			}else if (recData[i][j].toLowerCase().equals("search textbox") ) {
				  WebElement elem = ReusableMethod.getLocator(driver,recData[i][j+1],recData[i][j+2]);
				  if (elem.isDisplayed()) {
					  System.out.println("Search textbox is visible");
				  }else {
					  System.out.println("Search textbox is not visible");
				  }
				  Thread.sleep(3000);
			}	
			}
	}
	
	driver.close();
	Update_Report( "Pass", "Help Menu",  "Successfully working");	
	ReusableMethod.writeExcel(path, "HelpMenuValidate", "Pass", "Chrome");
	bw.close();

}
public static void SearchAndAddQuantity() throws IOException, Exception{
	
	startReport("Amazon Report","C:/Users/KumFamily/Report/");
	int flag=0;
	String recData[][] = ReusableMethod.readExcelSheet(dt_path,"Sheet1");
	//String xlData[][] = ReusableMethod.readExcelSheet(path,"Sheet1");

	driver = new ChromeDriver();
	driver.get("https://amazon.com");
	driver.manage().window().maximize();
	for (int i = 0; i< recData.length; i++){
		for (int j = 0; j < recData[0].length; j++){
			if (recData[i][j].toLowerCase().equals("search box") ) {
			  WebElement elem = ReusableMethod.getLocator(driver,recData[i][j+1],recData[i][j+2]);
			  enterText(elem,"Head First Java in Books",recData[i][j]);
			  Thread.sleep(2000);
			} else if (recData[i][j].toLowerCase().equals("search button") ) {
				  WebElement elem = ReusableMethod.getLocator(driver,recData[i][j+1],recData[i][j+2]);
				  clickButton(elem, recData[i][j]);
				  Thread.sleep(3000);
			} else if (recData[i][j].toLowerCase().equals("head first book") ) {
				  WebElement elem = ReusableMethod.getLocator(driver,recData[i][j+1],recData[i][j+2]);
				  clickButton(elem, recData[i][j]);
				  Thread.sleep(4000);
			} else if (recData[i][j].toLowerCase().equals("qty drpdown")){
				  WebElement elem = ReusableMethod.getLocator(driver,recData[i][j+1], recData[i][j+2]);
				  clickButton(elem, recData[i][j]);
				   
				  //action.moveToElement(addtocart);
				  Thread.sleep(3000);
			 } else if (recData[i][j].toLowerCase().equals("qty 5") ) {
				  WebElement elem = ReusableMethod.getLocator(driver,recData[i][j+1],recData[i][j+2]);
				  clickButton(elem, recData[i][j]);
				  Thread.sleep(6000);
				  if (recData[i+1][j].toLowerCase().equals("sign drpdown")) {
					  WebElement dropdown = ReusableMethod.getLocator(driver, recData[i+1][j+1],recData[i+1][j+2]);
					  if (dropdown.isDisplayed()){
						  WebElement container = driver.findElement(By.xpath(".//*[@id='dp-container']"));
						  Actions action = new Actions(driver);
						  action.moveToElement(container).build().perform();
						  WebElement addtocart = ReusableMethod.getLocator(driver,recData[4][2], recData[4][3]);
						  clickButton(addtocart, "Add to cart");
						  Thread.sleep(3000);
			
					  }
						  
				  }
			 }else if (recData[i][j].toLowerCase().equals("cart count")){
				  WebElement elem = ReusableMethod.getLocator(driver,recData[i][j+1], recData[i][j+2]);
				  if (elem.isDisplayed()){
					  System.out.println("Qty displayed correctly");
				  } else {
					  System.out.println("Qty is not displayed correctly");
				  }
				   
				  //action.moveToElement(addtocart);
				  Thread.sleep(3000);
			 } 
			
		}
	}
	
	driver.close();
	Update_Report( "Pass", "Search and Add Quantity",  "Successfully working");	
	ReusableMethod.writeExcel(path, "SearchAndAddQuantity", "Pass", "Chrome");
	bw.close();

}
public static void updateQty() throws IOException, Exception{
	
	startReport("Amazon Report","C:/Users/KumFamily/Report/");
	int flag=0;
	String recData[][] = ReusableMethod.readExcelSheet(dt_path,"Sheet1");
	//String xlData[][] = ReusableMethod.readExcelSheet(path,"Sheet1");

	driver = new ChromeDriver();
	driver.get("https://amazon.com");
	driver.manage().window().maximize();
	for (int i = 0; i< recData.length; i++){
		for (int j = 0; j < recData[0].length; j++){
			if (recData[i][j].toLowerCase().equals("search box") ) {
			  WebElement elem = ReusableMethod.getLocator(driver,recData[i][j+1],recData[i][j+2]);
			  enterText(elem,"Head First Java in Books",recData[i][j]);
			  Thread.sleep(2000);
			} else if (recData[i][j].toLowerCase().equals("search button") ) {
				  WebElement elem = ReusableMethod.getLocator(driver,recData[i][j+1],recData[i][j+2]);
				  clickButton(elem, recData[i][j]);
				  Thread.sleep(3000);
			} else if (recData[i][j].toLowerCase().equals("head first book") ) {
				  WebElement elem = ReusableMethod.getLocator(driver,recData[i][j+1],recData[i][j+2]);
				  clickButton(elem, recData[i][j]);
				  Thread.sleep(4000);
			} else if (recData[i][j].toLowerCase().equals("qty drpdown")){
				  WebElement elem = ReusableMethod.getLocator(driver,recData[i][j+1], recData[i][j+2]);
				  clickButton(elem, recData[i][j]);
				   
				  //action.moveToElement(addtocart);
				  Thread.sleep(3000);
			 } else if (recData[i][j].toLowerCase().equals("qty 5") ) {
				  WebElement elem = ReusableMethod.getLocator(driver,recData[i][j+1],recData[i][j+2]);
				  clickButton(elem, recData[i][j]);
				  Thread.sleep(6000);
				  if (recData[i+1][j].toLowerCase().equals("sign drpdown")) {
					  WebElement dropdown = ReusableMethod.getLocator(driver, recData[i+1][j+1],recData[i+1][j+2]);
					  if (dropdown.isDisplayed()){
						  WebElement container = driver.findElement(By.xpath(".//*[@id='dp-container']"));
						  Actions action = new Actions(driver);
						  action.moveToElement(container).build().perform();
						  WebElement addtocart = ReusableMethod.getLocator(driver,recData[4][2], recData[4][3]);
						  clickButton(addtocart, "Add to cart");
						  Thread.sleep(3000);
			
					  }
						  
				  }
			 }else if (recData[i][j].toLowerCase().equals("cart count")){
				  WebElement elem = ReusableMethod.getLocator(driver,recData[i][j+1], recData[i][j+2]);
				  clickButton(elem,recData[i][j]);
				  
				  //action.moveToElement(addtocart);
				  Thread.sleep(3000);
			 }else if (recData[i][j].toLowerCase().equals("dropdown qty")){
				  WebElement elem = ReusableMethod.getLocator(driver,recData[i][j+1], recData[i][j+2]);
				  clickButton(elem, recData[i][j]);
				   
				  //action.moveToElement(addtocart);
				  Thread.sleep(3000);
			 } else if (recData[i][j].toLowerCase().equals("update qty")){
				  WebElement elem = ReusableMethod.getLocator(driver,recData[i][j+1], recData[i][j+2]);
				  clickButton(elem, recData[i][j]);
				   
				  //action.moveToElement(addtocart);
				  Thread.sleep(3000);
			 }else if (recData[i][j].toLowerCase().equals("save for later")){
				  WebElement elem = ReusableMethod.getLocator(driver,recData[i][j+1], recData[i][j+2]);
				  clickButton(elem, recData[i][j]);
				   
				  //action.moveToElement(addtocart);
				  Thread.sleep(3000);
			 }else if (recData[i][j].toLowerCase().equals("verify saved")){
				  WebElement elem = ReusableMethod.getLocator(driver,recData[i][j+1], recData[i][j+2]);
				 if (elem.isDisplayed()){
					 System.out.println("Saved for later is present");
				 }else {
					 System.out.println("Saved for later is not exists");
				 }
				   
				  //action.moveToElement(addtocart);
				  Thread.sleep(3000);
			 }
			
		}
	}
	
	driver.close();
	Update_Report( "Pass", "Update Qty and Save it for later",  "Successfully working");	
	ReusableMethod.writeExcel(path, "updateQty", "Pass", "Chrome");
	bw.close();

}

public static void SearchDropDown() throws IOException, Exception{
	
	startReport("Amazon Report","C:/Users/KumFamily/Report/");
	int flag=0;
	String recData[][] = ReusableMethod.readExcelSheet(dt_path,"Sheet1");
	//String xlData[][] = ReusableMethod.readExcelSheet(path,"Sheet1");

	driver = new ChromeDriver();
	driver.get("https://amazon.com");
	driver.manage().window().maximize();
	for (int i = 0; i< recData.length; i++){
		for (int j = 0; j < recData[0].length; j++){
			if (recData[i][j].toLowerCase().equals("search box") ) {
			  WebElement elem = ReusableMethod.getLocator(driver,recData[i][j+1],recData[i][j+2]);
			  enterText(elem,"iphone",recData[i][j]);
			  Thread.sleep(3000);
			  WebElement elem1 = ReusableMethod.getLocator(driver,recData[19][2],recData[19][3]);
			  clickButton(elem1, recData[19][1]);
			  Thread.sleep(2000);
			} else if (recData[i][j].toLowerCase().equals("cellphone")){
				  WebElement elem = ReusableMethod.getLocator(driver,recData[i][j+1], recData[i][j+2]);
				  clickButton(elem, recData[i][j]);
				  Thread.sleep(3000);
			 }else if (recData[i][j].toLowerCase().equals("electronics") ) {
				  WebElement elem = ReusableMethod.getLocator(driver,recData[i][j+1],recData[i][j+2]);
				  clickButton(elem, recData[i][j]);
				  Thread.sleep(6000);
		     }
			
		}
	}
	
	driver.close();
	Update_Report( "Pass", "Search Dropdown",  "Successfully working");	
	ReusableMethod.writeExcel(path, "SearchDropDown", "Pass", "Chrome");
	bw.close();

}

}
