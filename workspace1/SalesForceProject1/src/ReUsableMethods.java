import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.Exception;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import org.openqa.selenium.WebElement;


public class ReUsableMethods {
	
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
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
		str_time = dateFormat.format(exec_time);
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
			exeStatus = "Failed";
			report = 1;
			bw.write("<TR COLS=7><TD BGCOLOR=#EEEEEE WIDTH=3%><FONT FACE=VERDANA SIZE=2>"
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
}
