//Valid username and Valid password and click login
package com.example.tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.Exception;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class readObj1 {

	public static void main(String[] args) throws IOException, Exception {
		// TODO Auto-generated method stub
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver","E:/suchi/Abhi_Training/Selenium/chromedriver.exe");
		
		String dt_path = "E:/ExcelFiles/or.xls";
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
						  
						  clickobject(elem,recData[i][j]);
				    } else if (recData[i][j].toLowerCase().equals("remind me")) {
						    Thread.sleep(1000);
						    WebElement elem = getLocator(driver, recData[i][j+1], recData[i][j+2]);
						    
						    clickobject(elem,recData[i][j]);
	
				    } else if (recData[i][j].toLowerCase().equals("user dropdown")) {
				    		WebElement elem = getLocator(driver, recData[i][j+1], recData[i][j+2]);
				    		clickobject(elem, recData[i][j]);
				    } else if (recData[i][j].toLowerCase().equals("logout")) {
				    		WebElement elem = getLocator(driver, recData[i][j+1], recData[i][j+2]);
				    		clickobject(elem, recData[i][j]);
						  
						   flag=1;
						  break;
				    }
					
			}
			if (flag==1)
				break;
			System.out.println("");
		}
		driver.close();
		
	}
	public static WebElement getLocator(WebDriver driver, String locatorType, String locatorValue) throws Exception {
		if (locatorType.toLowerCase().equals("id")) 
				return driver.findElement(By.id(locatorValue));
		else if (locatorType.toLowerCase().equals("name"))
				return driver.findElement(By.name(locatorValue));
		else if (locatorType.toLowerCase().equals("classname") || (locatorType.toLowerCase().equals("class")))
			return driver.findElement(By.className(locatorValue));
		else if (locatorType.toLowerCase().equals("tagname") || (locatorType.toLowerCase().equals("tag")))
			return driver.findElement(By.tagName(locatorValue));
		else if (locatorType.toLowerCase().equals("xpath"))
			return driver.findElement(By.xpath(locatorValue));
		else if (locatorType.toLowerCase().equals("css") || (locatorType.toLowerCase().equals("cssselector")))
			return driver.findElement(By.cssSelector(locatorValue));
		else if (locatorType.toLowerCase().equals("linktext") || (locatorType.toLowerCase().equals("link")))
			return driver.findElement(By.linkText(locatorValue));
		else if (locatorType.toLowerCase().equals("partiallinktext"))
			return driver.findElement(By.partialLinkText(locatorValue));
		else
			throw new Exception("Locator Type " + locatorType + " is not defined");
	}
	public static String[][] readExcelSheet(String path, String sheetname) throws IOException {
		
		File xlFile = new File(path);
		FileInputStream xlDoc = new FileInputStream(xlFile);
		HSSFWorkbook wb = new HSSFWorkbook(xlDoc);
		HSSFSheet sheet = wb.getSheet(sheetname);
		
		int iRowCount = sheet.getLastRowNum() + 1;
		int iColCount = sheet.getRow(0).getLastCellNum();
		
		String xlData[][] = new String[iRowCount][iColCount];
		//System.out.print("row = " + iRowCount + " col = " + iColCount);
		
		for (int i = 0; i < xlData.length; i++){
			for (int j = 0; j < xlData[0].length; j++){
				xlData[i][j] = sheet.getRow(i).getCell(j).getStringCellValue();
				//System.out.print(sheet.getRow(i).getCell(j).getStringCellValue() + " ");
			}
		}
		
		return xlData;
		
	}
	public static void enterText(WebElement obj, String textVal, String objName){
		if (obj.isDisplayed()){
			obj.sendKeys(textVal);
			System.out.println("Pass : " + textVal + " is entered in " + objName + " field");
		} else {
			System.out.println("Fail : " + objName + " is entered in ");
		}
	}
	public static void clickobject(WebElement obj, String objName){
		if (obj.isDisplayed()){
			obj.click();
			System.out.println("Pass : " + objName + " is clicked");
		} else {
			System.out.println("Login is not clicked");
		}
	}

}
