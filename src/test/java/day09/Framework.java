package day09;

import java.io.File;
import java.io.FileInputStream;
import java.util.Set;
import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Framework {
	public static WebDriver driver;
	public static ExtentReports report;
	public static ExtentTest test;
	
	public static void browser(String browserValue)
	{
		try {
			switch (browserValue) {
			case "Chrome":
				driver = new ChromeDriver();
				test.log(LogStatus.INFO, "opened chrome browser");
				passScreenShot(browserValue);
				break;
			case "FireFox":
				driver = new FirefoxDriver();
				test.log(LogStatus.INFO, "opened FireFox browser");
				passScreenShot(browserValue);
				break;
			case "IE":
				driver = new InternetExplorerDriver();
				test.log(LogStatus.INFO, "opened IE browser");
				passScreenShot(browserValue);
				break;
			case "Edge":
				driver = new EdgeDriver();
				test.log(LogStatus.INFO, "opened Edge browser");
				passScreenShot(browserValue);
				break;
			}
		} catch (Exception e) {
			e.printStackTrace();
			test.log(LogStatus.ERROR, e.getMessage());
			failScreenShot(browserValue);
		}
	}
	
	
	public static void application(String url)
	{
		try {
			driver.get(url);
			test.log(LogStatus.INFO, "Open Application URL : "+url);
			passScreenShot("app");
		} catch (Exception e) {
			e.printStackTrace();
			test.log(LogStatus.ERROR, e.getMessage());
			failScreenShot("app");
		}
	}
	
	public static void typeIn(String fieldName)
	{
		try {
			driver.findElement(By.xpath(readXpath(fieldName))).sendKeys(readDataValue(fieldName));
			test.log(LogStatus.INFO, "User Entered value in "+fieldName+" as "+readDataValue(fieldName));
			passScreenShot(fieldName);
		} catch (Exception e) {
			e.printStackTrace();
			test.log(LogStatus.ERROR, e.getMessage());
			failScreenShot(fieldName);
		}
	}
	
	public static void clickIn(String fieldName)
	{
		try {
			driver.findElement(By.xpath(readXpath(fieldName))).click();
			test.log(LogStatus.INFO, "User Clicked in "+fieldName);
			passScreenShot(fieldName);
		} catch (Exception e) {
			e.printStackTrace();
			test.log(LogStatus.ERROR, e.getMessage());
			failScreenShot(fieldName);
		}
	}
	
	public static void clearAll(String fieldName)
	{
		try {
			driver.findElement(By.xpath(readXpath(fieldName))).clear();
			test.log(LogStatus.INFO, "User Cleared in "+fieldName);
			passScreenShot(fieldName);
		} catch (Exception e) {
			e.printStackTrace();test.log(LogStatus.ERROR, e.getMessage());
			failScreenShot(fieldName);
		}
	}
	
	public static void selectDropDownByValue(String fieldName)
	{
		try {
			Select dropdown = new Select(driver.findElement(By.xpath(readXpath(fieldName))));
			dropdown.selectByValue(readDataValue(fieldName));
			test.log(LogStatus.INFO, "User Select Dropdown in "+fieldName+" as "+readDataValue(fieldName));
			passScreenShot(fieldName);
		} catch (Exception e) {
			e.printStackTrace();
			test.log(LogStatus.ERROR, e.getMessage());
			failScreenShot(fieldName);
		}
	}
	
	public static void selectDropDownByText(String fieldName)
	{
		try {
			Select dropdown = new Select(driver.findElement(By.xpath(readXpath(fieldName))));
			dropdown.selectByVisibleText(readDataValue(fieldName));
			test.log(LogStatus.INFO, "User Select Dropdown in "+fieldName+" as "+readDataValue(fieldName));
			passScreenShot(fieldName);
		} catch (Exception e) {
			e.printStackTrace();test.log(LogStatus.ERROR, e.getMessage());
			failScreenShot(fieldName);
		}
	}
	
	public static void selectDropDownByIndex(String fieldName)
	{
		try {
			Select dropdown = new Select(driver.findElement(By.xpath(readXpath(fieldName))));
			test.log(LogStatus.INFO, "User Select Dropdown in "+fieldName+" as "+readDataValue(fieldName));			
			dropdown.selectByIndex(Integer.parseInt(readDataValue(fieldName)));
		} catch (Exception e) {
			e.printStackTrace();
			test.log(LogStatus.ERROR, e.getMessage());
		}
	}
	
	
	public static void alertOk()
	{
		try {
			driver.switchTo().alert().accept();
		} catch (Exception e) {
			e.printStackTrace();
			test.log(LogStatus.ERROR, e.getMessage());
		}
	}
	public static void alertCancel()
	{
		try {
			driver.switchTo().alert().dismiss();
		} catch (Exception e) {
			e.printStackTrace();test.log(LogStatus.ERROR, e.getMessage());
		}
	}
	public static void alertTypeIn(String dataValue)
	{
		try {
			driver.switchTo().alert().sendKeys(dataValue);
		} catch (Exception e) {
			e.printStackTrace();test.log(LogStatus.ERROR, e.getMessage());
		}
	}
	
	public static void switchToframe(String frameIdName)
	{
		try {
			driver.switchTo().frame(frameIdName);
		} catch (Exception e) {
			e.printStackTrace();test.log(LogStatus.ERROR, e.getMessage());
		}
	}
	
	public static void switchBackFromframe()
	{
		try {
			driver.switchTo().defaultContent();
		} catch (Exception e) {
			e.printStackTrace();test.log(LogStatus.ERROR, e.getMessage());
		}
	}
	
	public static void switchToWindow(String windowId)
	{
		try {
			driver.switchTo().window(windowId);
		} catch (Exception e) {
			e.printStackTrace();test.log(LogStatus.ERROR, e.getMessage());
		}
	}
	
	public static String getCurrentWindowID()
	{
		try {
			return driver.getWindowHandle();
		} catch (Exception e) {
			e.printStackTrace();test.log(LogStatus.ERROR, e.getMessage());
			return null;
		}
	}
	
	public static Set<String> getAllWindowID()
	{
		try {
			return driver.getWindowHandles();
		} catch (Exception e) {
			e.printStackTrace();test.log(LogStatus.ERROR, e.getMessage());
			return null;
		}
	}
	
	public static void windowMax()
	{
		try {
			driver.manage().window().maximize();
			test.log(LogStatus.INFO, "User Maximize Window");
		} catch (Exception e) {
			e.printStackTrace();test.log(LogStatus.ERROR, e.getMessage());
		}
	}
	public static void windowMin()
	{
		try {
			driver.manage().window().minimize();
			test.log(LogStatus.INFO, "User Minimize Window");
		} catch (Exception e) {
			e.printStackTrace();test.log(LogStatus.ERROR, e.getMessage());
		}
	}
	public static void windowFullScreen()
	{
		try {
			driver.manage().window().fullscreen();
			test.log(LogStatus.INFO, "User Fullscreen Window");
		} catch (Exception e) {
			e.printStackTrace();test.log(LogStatus.ERROR, e.getMessage());
		}
	}
	public static void browserClose()
	{
		try {
			driver.close();
			test.log(LogStatus.INFO, "User closed Window");
		} catch (Exception e) {
			e.printStackTrace();test.log(LogStatus.ERROR, e.getMessage());
		}
	}
	public static void browserQuit()
	{
		try {
			driver.quit();
			test.log(LogStatus.INFO, "User Quit Window");
		} catch (Exception e) {
			e.printStackTrace();test.log(LogStatus.ERROR, e.getMessage());
		}
	}
	
	public static void actionDoubleClick(String fieldName)
	{
		try {
			Actions action = new Actions(driver);
			WebElement element = driver.findElement(By.xpath(readXpath(fieldName)));
			action.doubleClick(element).build().perform();
		} catch (Exception e) {
			e.printStackTrace();test.log(LogStatus.ERROR, e.getMessage());
		}
	}
	public static void actionClick(String fieldName)
	{
		try {
			Actions action = new Actions(driver);
			WebElement element = driver.findElement(By.xpath(readXpath(fieldName)));
			action.click(element).build().perform();
		} catch (Exception e) {
			e.printStackTrace();test.log(LogStatus.ERROR, e.getMessage());
		}
	}
	public static void actionRightClick(String fieldName)
	{
		try {
			Actions action = new Actions(driver);
			WebElement element = driver.findElement(By.xpath(readXpath(fieldName)));
			action.contextClick(element).build().perform();
		} catch (Exception e) {
			e.printStackTrace();test.log(LogStatus.ERROR, e.getMessage());
		}
	}
	
	public static void actionMouseHover(String fieldName)
	{
		try {
			Actions action = new Actions(driver);
			WebElement element = driver.findElement(By.xpath(readXpath(fieldName)));
			action.moveToElement(element).build().perform();
		} catch (Exception e) {
			e.printStackTrace();test.log(LogStatus.ERROR, e.getMessage());
		}
	}
	
	public static void actionDragAndDrop(String srcXpathValue,String desXpathValue)
	{
		try {
			Actions action = new Actions(driver);
			WebElement srcElement = driver.findElement(By.xpath(srcXpathValue));
			WebElement desElement = driver.findElement(By.xpath(desXpathValue));		
			action.dragAndDrop(srcElement,desElement).build().perform();
		} catch (Exception e) {
			e.printStackTrace();test.log(LogStatus.ERROR, e.getMessage());
		}
	}
	
	public static void screenShot(String fileName)
	{
		try {
			File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			File des = new File(".\\src\\test\\resources\\screenshot\\"+fileName+".png");
			FileUtils.copyFile(src, des);
		} catch (Exception e) {
			e.printStackTrace();
			test.log(LogStatus.ERROR, e.getMessage());
		} 
	}
	public static void passScreenShot(String fileName)
	{
		try {
			File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			File des = new File(".\\src\\test\\resources\\screenshot\\pass\\"+fileName+".png");
			FileUtils.copyFile(src, des);
			test.log(LogStatus.PASS, test.addScreenCapture(des.getAbsolutePath()));
		} catch (Exception e) {
			e.printStackTrace();
			test.log(LogStatus.ERROR, e.getMessage());
		} 
	}
	public static void failScreenShot(String fileName)
	{
		try {
			File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			File des = new File(".\\src\\test\\resources\\screenshot\\fail\\"+fileName+".png");
			FileUtils.copyFile(src, des);
			test.log(LogStatus.FAIL, test.addScreenCapture(des.getAbsolutePath()));
		} catch (Exception e) {
			e.printStackTrace();
			test.log(LogStatus.ERROR, e.getMessage());
		} 
	}
	
	public static void reportStart(String fileName)
	{
		report = new ExtentReports(".\\src\\test\\resources\\report\\"+fileName+".html");
	}
	
	public static void reportEnd()
	{
		report.flush();
	}
	
	public static void testCaseStart(String testCaseId,String testDescription)
	{
		test = report.startTest(testCaseId,testDescription);
	}
	
	public static void testCaseEnd()
	{
		report.endTest(test);
	}
	
	public static String readXpath(String fieldName)
	{
		try {
			File src = new File(".\\src\\test\\resources\\TestDataSheet.xlsx");
			FileInputStream ip= new FileInputStream(src);
			XSSFWorkbook wb = new XSSFWorkbook(ip);
			XSSFSheet sh = wb.getSheetAt(0);
			DataFormatter format = new DataFormatter();		
			for(int i=1;i<=sh.getLastRowNum();i++)
			{
			if(format.formatCellValue(sh.getRow(i).getCell(0)).equals(fieldName))
			{
				return(format.formatCellValue(sh.getRow(i).getCell(1)));				
			}				
			}	
		
		}  catch (Exception e) {
			e.printStackTrace();
		}
		return null;	
	}
	
	
	public static String readDataValue(String fieldName)
	{
		try {
			File src = new File(".\\src\\test\\resources\\TestDataSheet.xlsx");
			FileInputStream ip= new FileInputStream(src);
			XSSFWorkbook wb = new XSSFWorkbook(ip);
			XSSFSheet sh = wb.getSheetAt(0);
			DataFormatter format = new DataFormatter();		
			for(int i=1;i<=sh.getLastRowNum();i++)
			{
			if(format.formatCellValue(sh.getRow(i).getCell(0)).equals(fieldName))
			{
				return(format.formatCellValue(sh.getRow(i).getCell(2)));				
			}				
			}	
		
		}  catch (Exception e) {
			e.printStackTrace();
		}
		return null;	
	}
	
	
	
}
