

//import org.junit.*;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutomationScripts extends ReUsableMethods{
	public static WebDriver driver;

	
	
	static String dt_path = "E:/ExcelFiles/or.xls";
	
	public static void SFDCLogin() throws Exception {



		/* Launch a Browser*/
		//System.setProperty("webdriver.gecko.driver", "C:/Users/Abhis_lw0caw1/Google Drive/July 10 2017/July 10 2017 Read Only/Framework/Lib/geckodriver.exe");
		startReport("Suchi Report","C:/Users/KumFamily/Report/");
		String testdata = "E:/ExcelFiles/TestSheet.xls";
		int flag=0;
		
		String recData[][] = readExcelSheet(dt_path,"Sheet4");
		String Data[][] = readExcelSheet(testdata,"Sheet1");
		driver = new ChromeDriver();
		driver.get("https://login.salesforce.com");
		for (int i = 0; i< recData.length; i++){
			for (int j = 0; j < recData[0].length; j++){
	
					if (recData[i][j].toLowerCase().equals("user") ) {

					  WebElement elem = getLocator(driver,recData[i][j+1],recData[i][j+2]);
					  
					  for (int k = 0; k < Data.length; k++){
						  for (int l = 0; l < Data[0].length; l++){
							  if (Data[k][l].equals("username")){
								  enterText(elem,Data[k][l+1],recData[i][j]);
								  break;
							  }
						  }
					  }
					  //enterText(elem,"kk.suchithra@gmail.com", recData[i][j]);
					 
				    } else if (recData[i][j].toLowerCase().equals("password")){
				    	
						  WebElement elem = getLocator(driver,recData[i][j+1],recData[i][j+2]);
						  for (int k = 0; k < Data.length; k++){
							  for (int l = 0; l < Data[0].length; l++){
								  if (Data[k][l].equals("password")){
									  enterText(elem,Data[k][l+1],recData[i][j]);
									  break;
								  }
							  }
						  } 
						  //enterText(elem,"Rithesh12", recData[i][j]);
						  
						
				    }else if (recData[i][j].toLowerCase().equals("login")){
				    	
						  WebElement elem = getLocator(driver, recData[i][j+1],recData[i][j+2]);
						  
						  clickButton(elem,recData[i][j]);
				    } else if (recData[i][j].toLowerCase().equals("remind me")) {
						    Thread.sleep(1000);
						    WebElement elem = getLocator(driver, recData[i][j+1], recData[i][j+2]);
						    
						    clickButton(elem,recData[i][j]);
	
				    } else if (recData[i][j].toLowerCase().equals("user dropdown")) {
				    		WebElement elem = getLocator(driver, recData[i][j+1], recData[i][j+2]);
				    		clickButton(elem, recData[i][j]);
				    } else if (recData[i][j].toLowerCase().equals("logout")) {
				    		WebElement elem = getLocator(driver, recData[i][j+1], recData[i][j+2]);
	
						  driver.close();
						   flag=1;
						  break;
				    }
					if (flag==1)
						break;
			}
			System.out.println("");
		}
		Update_Report( "Pass", "Sales Force Login",  "Successfully logged in");

		bw.close();
	}
	public static void SFDC_WrongPassword() throws Exception {
		System.setProperty("webdriver.chrome.driver","E:/suchi/Abhi_Training/Selenium/chromedriver.exe");
		startReport("Suchi Report","C:/Users/KumFamily/Report/");

		String testdata = "E:/ExcelFiles/TestSheet.xls";
		int flag=0;
		
		String recData[][] = readExcelSheet(dt_path,"Sheet4");
		String Data[][] = readExcelSheet(testdata,"Sheet2");
		driver = new ChromeDriver();
		driver.get("https://login.salesforce.com");
		for (int i = 0; i< recData.length; i++){
			for (int j = 0; j < recData[0].length; j++){
				//System.out.print(recData[i][j] + " ");
				

					//By value = getLocator(recData[i][j],recData[i][j-1]);
				System.out.println("data is " + recData[i][j] + " " );
					if (recData[i][j].toLowerCase().equals("user") ) {
					//String xpath1 = recData[i][j];
					  //WebElement userName = driver.findElement(By.id(recData[i][j+1]));
					  WebElement elem = getLocator(driver,recData[i][j+1],recData[i][j+2]);
					  
					  for (int k = 0; k < Data.length; k++){
						  for (int l = 0; l < Data[0].length; l++){
							  if (Data[k][l].equals("username")){
								  enterText(elem,Data[k][l+1],recData[i][j]);
								  break;
							  }
						  }
					  }
					  //enterText(elem,Data[k][l+1], recData[i][j]);
					  //break;
				    } else if (recData[i][j].toLowerCase().equals("password")){
				    	
						  WebElement elem = getLocator(driver,recData[i][j+1],recData[i][j+2]);
						  for (int k = 0; k < Data.length; k++){
							  for (int l = 0; l < Data[0].length; l++){
								  if (Data[k][l].equals("password")){
									  enterText(elem,Data[k][l+1],recData[i][j]);
									  break;
								  }
							  }
						  } 
						  //enterText(elem,"", recData[i][j]);
						  
						  //break;
				    }else if (recData[i][j].toLowerCase().equals("login")){
				    	
						  WebElement value = getLocator(driver, recData[i][j+1],recData[i][j+2]);
						  
						  clickButton(value,recData[i][j]);
						  Thread.sleep(2000);
				    } else if (recData[i][j].toLowerCase().equals("error")) {
						  //WebElement elem = driver.findElement(By.xpath(".//*[@id='error' and contains(text(),'password')]"));
						  WebElement elem = getLocator(driver, recData[i][j+1],recData[i][j+2]);
						  driver.close();
						   flag=1;
						  break;
						  
						  //break;
				    } 
					if (flag==1)
						break;
			}
			
			System.out.println("");
		}
		Update_Report( "Pass", "Sales Force Wrong Password",  "Successfully gives error message");
		bw.close();
	}
	public static void validateErrorMessage(){
		
	}







}
