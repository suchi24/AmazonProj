package com.example.tests;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.Exception;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Hyperlink;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.openqa.selenium.WebElement;



public class ReusableMethod {
	
	static BufferedWriter bw = null;
	static BufferedWriter bw1 = null;
	static String htmlname;
	static String objType;
	static String objName;
	static String TestData;
	static String rootPath;
	static int report;


	static Date cur_dt = null;
	static String filenamer;
	static String TestReport;
	int rowcnt;
	static String exeStatus = "True";
	static int iflag = 0;
	static int j = 1;

	static String fireFoxBrowser;
	static String chromeBrowser;

	
	static String result;

	static int intRowCount = 0;
	static String dataTablePath;
	static int i;
	static String browserName;

	
	/* Name Of the method: enterText
	 * Brief Description: Enter the text value to the text box
	 * Arguments: obj --> Text box object, textVal --> value to be entered, objName --> name of the object
	 * Created by: Automation team
	 * Creation Date: Aug 23 2017
	 * Last Modified: Aug 23 2017
	 * */
	public static void enterText(WebElement obj, String textVal, String objName) throws IOException{
		if(obj.isDisplayed()){
			//obj.clear();
			obj.sendKeys(textVal);
			Update_Report("Pass: ", textVal + " is entered" , objName + " in text box");
		}else{
			Update_Report("Fail: ", textVal + " is entered", objName + " is invalid");

		}

	}
	/* Name Of the method: clickButton
	 * Brief Description: Click on button
	 * Arguments: obj --> web object,  objName --> name of the object
	 * Created by: Automation team
	 * Creation Date: Aug 23 2017
	 * Last Modified: Aug 23 2017
	 * */
	
	public static void clickButton(WebElement obj,  String objName) throws IOException{
		
		if(obj.isDisplayed()){
			obj.click();
			Update_Report("Pass: ", objName , " button is clicked");
		}else{
			Update_Report("Fail: " ,objName, " button is not clicked");

		}
		
	}
	
	public static void startReport(String scriptName, String ReportsPath) throws IOException{

		String strResultPath = null;


		String testScriptName =scriptName;


		cur_dt = new Date(); 
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
		String strTimeStamp = dateFormat.format(cur_dt);

		if (ReportsPath == "") { 

			ReportsPath = "C:\\";
		}

		if (ReportsPath.endsWith("\\")) { 
			ReportsPath = ReportsPath + "\\";
		}

		strResultPath = ReportsPath + "Log" + "/" +testScriptName +"/"; 
		File f = new File(strResultPath);
		f.mkdirs();
		htmlname = strResultPath  + testScriptName + "_" + strTimeStamp 
				+ ".html";



		bw = new BufferedWriter(new FileWriter(htmlname));

		bw.write("<HTML><BODY><TABLE BORDER=0 CELLPADDING=3 CELLSPACING=1 WIDTH=100%>");
		bw.write("<TABLE BORDER=0 BGCOLOR=BLACK CELLPADDING=3 CELLSPACING=1 WIDTH=100%>");
		bw.write("<TR><TD BGCOLOR=#66699 WIDTH=27%><FONT FACE=VERDANA COLOR=WHITE SIZE=2><B>Browser Name</B></FONT></TD><TD COLSPAN=6 BGCOLOR=#66699><FONT FACE=VERDANA COLOR=WHITE SIZE=2><B>"
				+ "FireFox " + "</B></FONT></TD></TR>");
		bw.write("<HTML><BODY><TABLE BORDER=1 CELLPADDING=3 CELLSPACING=1 WIDTH=100%>");
		bw.write("<TR COLS=7><TD BGCOLOR=#BDBDBD WIDTH=3%><FONT FACE=VERDANA COLOR=BLACK SIZE=2><B>SL No</B></FONT></TD>"
				+ "<TD BGCOLOR=#BDBDBD WIDTH=10%><FONT FACE=VERDANA COLOR=BLACK SIZE=2><B>Step Name</B></FONT></TD>"
				+ "<TD BGCOLOR=#BDBDBD WIDTH=10%><FONT FACE=VERDANA COLOR=BLACK SIZE=2><B>Execution Time</B></FONT></TD> "
				+ "<TD BGCOLOR=#BDBDBD WIDTH=10%><FONT FACE=VERDANA COLOR=BLACK SIZE=2><B>Status</B></FONT></TD>"
				+ "<TD BGCOLOR=#BDBDBD WIDTH=47%><FONT FACE=VERDANA COLOR=BLACK SIZE=2><B>Detail Report</B></FONT></TD></TR>");
    
      
	}

	public static void Update_Report(String Res_type,String Action, String result) throws IOException {
		String str_time;
		Date exec_time = new Date();
		//WebDriver driver = AutomationScripts.driver;
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
		str_time = dateFormat.format(exec_time);
		String dtTablePath = "E:/ExcelFiles/TestSuite.xls";
		String browser = "Chrome";
		
		FileInputStream xlDoc = new FileInputStream(dtTablePath);
		
		HSSFWorkbook wb = new HSSFWorkbook(xlDoc);
	    String recData[][] = writeExcel(dtTablePath, "Sheet1", Res_type, browser);
		if (Res_type.startsWith("Pass")) {
			bw.write("<TR COLS=7><TD BGCOLOR=#EEEEEE WIDTH=3%><FONT FACE=VERDANA SIZE=2>"
					+ (j++)
					+ "</FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=10%><FONT FACE=VERDANA SIZE=2>"
					+Action
					+ "</FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=10%><FONT FACE=VERDANA SIZE=2>"
					+ str_time
					+ "</FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=10%><FONT FACE=VERDANA SIZE=2 COLOR = GREEN>"
					+ "Passed"
					+ "</FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=30%><FONT FACE=VERDANA SIZE=2 COLOR = GREEN>"
					+ result + "</FONT></TD></TR>");
			

		} else if (Res_type.startsWith("Fail")) {
			
			System.out.println("Fail");
			//String ss1Path= screenshot(dr);
	
		
			exeStatus = "Failed";
			report = 1;
	
			
			bw.write("<TR COLS=7><TD BGCOLOR=#EhtmlEEEEE WIDTH=3%><FONT FACE=VERDANA SIZE=2>"
					+ (j++)
					+ "</FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=10%><FONT FACE=VERDANA SIZE=2>"
					+Action
					+ "</FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=10%><FONT FACE=VERDANA SIZE=2>"
					+ str_time
					+ "</FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=10%><FONT FACE=VERDANA SIZE=2 COLOR = RED>"
					+ "<a href= "
					+ htmlname
					+ "  style=\"color: #FF0000\"> Failed </a>"

				+ "</FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=30%><FONT FACE=VERDANA SIZE=2 COLOR = RED>"
				+ result + "</FONT></TD></TR>");
			//String ss1Path= screenshot(driver);

		} 
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
public static String screenshot(WebDriver dr) throws IOException{
	
	Date exec_time = new Date();
	DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
	String str_time = dateFormat.format(exec_time);
	//String fileName = "C:/Users/Sreeram/Desktop/WorkDayScreenShots/ss.png";
	String  ss1Path = "C:/Users/KumFamily/Report/Log"+ str_time+".png";
	//String  ss1Path = "F:/salesforce1.png";
	File scrFile = ((TakesScreenshot)dr).getScreenshotAs(OutputType.FILE);
	FileUtils.copyFile(scrFile, new File(ss1Path));
	return ss1Path;
}

public static String[][] writeExcel(String dtTablePath, String testcase, String ResultType, String BrowserType) throws IOException  {
	
	File xlFile = new File(dtTablePath);
	FileInputStream xlDoc = new FileInputStream(xlFile);
	
	HSSFWorkbook wb = new HSSFWorkbook(xlDoc);

	HSSFSheet sheet = wb.getSheet("Sheet1");
	int cellno=3;
	
	HSSFWorkbook wb1 = new HSSFWorkbook(); //or new HSSFWorkbook();
	CreationHelper createHelper = wb1.getCreationHelper();
	
    Hyperlink link = createHelper.createHyperlink(Hyperlink.LINK_URL);
    //link.setAddress("C:/Users/KumFamily/Report/Log/Suchi Report/AmazonSearch.html");
    link.setAddress(htmlname);
    //System.out.println(htmlname);
	//HSSFCellStyle style = wb.createCellStyle();

	
	int iRowCount = sheet.getLastRowNum() + 1;
	int iColCount = sheet.getRow(0).getLastCellNum();
	String[][] xlData = new String[iRowCount][iColCount];

	for(int i=0; i < xlData.length; i++){
		for (int j = 0; j < xlData[0].length; j++){
			xlData[i][j] = sheet.getRow(i).getCell(j).getStringCellValue();
			
			//System.out.print(xlData[i][j]+ " ");
			//if (xlData[i][j].equalsIgnoreCase(testcase) && xlData[i][j+1].equalsIgnoreCase("Y")){
			if (BrowserType.equalsIgnoreCase("Chrome"))
				cellno = j+1;
			else if (BrowserType.equalsIgnoreCase("Firefox"))
				cellno = j + 2;
			else if (BrowserType.equalsIgnoreCase("IE"))
				cellno = j + 3;
			else if (BrowserType.equalsIgnoreCase("Safari"))
				cellno = j + 4;
			if (xlData[i][j].equalsIgnoreCase(testcase) && ResultType.equalsIgnoreCase("Pass") ){
				System.out.println("Passing");
			HSSFCellStyle titleStyle = wb.createCellStyle();
	
			titleStyle.setFillForegroundColor(new HSSFColor.GREEN().getIndex());
			titleStyle.setFillPattern(CellStyle.SOLID_FOREGROUND);
			sheet.getRow(i).getCell(cellno).setCellStyle(titleStyle);
			break;
			
			} else if (xlData[i][j].equalsIgnoreCase(testcase) && ResultType.equalsIgnoreCase("Fail") ) {
				System.out.println("yes, it fails");
				  //titleStyle = wb.createCellStyle();
			HSSFCellStyle titleStyle = wb.createCellStyle();
			Font hlink_font = wb.createFont();
			hlink_font.setUnderline(Font.U_SINGLE);
			hlink_font.setColor(IndexedColors.BLUE.getIndex());
			titleStyle.setFont(hlink_font);

			titleStyle.setFillForegroundColor(new HSSFColor.RED().getIndex());
			titleStyle.setFillPattern(CellStyle.SOLID_FOREGROUND);
			sheet.getRow(i).getCell(cellno).setCellStyle(titleStyle);
			sheet.getRow(i).getCell(cellno).setHyperlink(link);
			sheet.getRow(i).getCell(cellno).setCellStyle(titleStyle);
			break;
			}
		}
		//System.out.println();
	}
	FileOutputStream fout = new FileOutputStream(dtTablePath);
	
	wb.write(fout);
	fout.flush();
	fout.close();
	return xlData;
	
}




}
