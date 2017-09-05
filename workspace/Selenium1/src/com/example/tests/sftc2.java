//Test case to read from excel file, the url, username and password. Valid username and blank password
package com.example.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class sftc2 {

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub

		
		String dtpath = "E:/ExcelFiles/salesforcelogin.xls";
		//String recData[][] = readExcelSheet(dtpath,"Sheet1");
		
		File xlFile = new File(dtpath);
		FileInputStream xlDoc = new FileInputStream(xlFile);
		HSSFWorkbook wb = new HSSFWorkbook(xlDoc);
		HSSFSheet sheet = wb.getSheet("Sheet2");
		
		int iRowCount = sheet.getLastRowNum() + 1;
		int iColCount = sheet.getRow(0).getLastCellNum();
		
		String xlData[][] = new String[iRowCount][iColCount];
		for (int i = 0; i < xlData.length; i++){
			for (int j = 0; j < xlData[0].length; j++){
				xlData[i][j] = sheet.getRow(i).getCell(j).getStringCellValue();
				if (xlData[i][j].startsWith("https")) {
			

					WebDriver driver;
					driver = new FirefoxDriver();
					driver.get(xlData[i][j]);
					WebElement uname = driver.findElement(By.id("username"));
					String user = sheet.getRow(i).getCell(j+1).getStringCellValue();
					uname.sendKeys(user);
					WebElement pwd = driver.findElement(By.id("password"));
					HSSFRow row = sheet.getRow(i);
					String passwd =  (row.getCell(j+2)+"").toString();
					//String passwd = sheet.getRow(i).getCell(j+2).getStringCellValue()+"";
					pwd.sendKeys(passwd);
					WebElement login = driver.findElement(By.id("Login"));
					login.click();
				    Thread.sleep(1000);
				   
				    if (driver.findElement(By.xpath("//*[@id='error' and contains(text(),'password')]")).isDisplayed()) {
				    
				    	
				    	//writeExcelSheet(dtpath, "Sheet1", i, j + 4);
						//row = sheet.getRow(i);
						
						//String actualRes = (row.getCell(j+4)+"").toString();
				    	
						row.getCell(j+4).setCellValue("Please enter your password");
						
						FileOutputStream fout = new FileOutputStream(dtpath);
						
						wb.write(fout);
				    	
				    }
					break;
				}
			}
			System.out.println();
		}
		System.out.println("Login failed");
	}
		
		
	
}