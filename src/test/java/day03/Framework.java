package day03;

import java.io.File;
import java.util.Set;
import org.apache.commons.io.FileUtils;
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

public class Framework {
	public static WebDriver driver;
	
	public static void browser(String browserValue)
	{
		try {
			switch (browserValue) {
			case "Chrome":
				driver = new ChromeDriver();
				break;
			case "FireFox":
				driver = new FirefoxDriver();
				break;
			case "IE":
				driver = new InternetExplorerDriver();
				break;
			case "Edge":
				driver = new EdgeDriver();
				break;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public static void application(String url)
	{
		try {
			driver.get(url);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void typeIn(String xpathValue,String dataValue)
	{
		try {
			driver.findElement(By.xpath(xpathValue)).sendKeys(dataValue);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void clickIn(String xpathValue)
	{
		try {
			driver.findElement(By.xpath(xpathValue)).click();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void clearAll(String xpathValue)
	{
		try {
			driver.findElement(By.xpath(xpathValue)).clear();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void selectDropDownByValue(String xpathValue,String dataValue)
	{
		try {
			Select dropdown = new Select(driver.findElement(By.xpath(xpathValue)));
			dropdown.selectByValue(dataValue);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void selectDropDownByText(String xpathValue,String dataValue)
	{
		try {
			Select dropdown = new Select(driver.findElement(By.xpath(xpathValue)));
			dropdown.selectByVisibleText(dataValue);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void selectDropDownByIndex(String xpathValue,int dataValue)
	{
		try {
			Select dropdown = new Select(driver.findElement(By.xpath(xpathValue)));
			dropdown.selectByIndex(dataValue);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public static void alertOk()
	{
		try {
			driver.switchTo().alert().accept();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void alertCancel()
	{
		try {
			driver.switchTo().alert().dismiss();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void alertTypeIn(String dataValue)
	{
		try {
			driver.switchTo().alert().sendKeys(dataValue);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void switchToframe(String frameIdName)
	{
		try {
			driver.switchTo().frame(frameIdName);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void switchBackFromframe()
	{
		try {
			driver.switchTo().defaultContent();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void switchToWindow(String windowId)
	{
		try {
			driver.switchTo().window(windowId);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static String getCurrentWindowID()
	{
		return driver.getWindowHandle();
	}
	
	public static Set<String> getAllWindowID()
	{
		return driver.getWindowHandles();
	}
	
	public static void windowMax()
	{
		driver.manage().window().maximize();
	}
	public static void windowMin()
	{
		driver.manage().window().minimize();
	}
	public static void windowFullScreen()
	{
		driver.manage().window().fullscreen();
	}
	public static void browserClose()
	{
		driver.close();
	}
	public static void browserQuit()
	{
		driver.quit();
	}
	
	public static void actionDoubleClick(String xpathValue)
	{
		try {
			Actions action = new Actions(driver);
			WebElement element = driver.findElement(By.xpath(xpathValue));
			action.doubleClick(element).build().perform();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void actionClick(String xpathValue)
	{
		try {
			Actions action = new Actions(driver);
			WebElement element = driver.findElement(By.xpath(xpathValue));
			action.click(element).build().perform();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void actionRightClick(String xpathValue)
	{
		try {
			Actions action = new Actions(driver);
			WebElement element = driver.findElement(By.xpath(xpathValue));
			action.contextClick(element).build().perform();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void actionMouseHover(String xpathValue)
	{
		try {
			Actions action = new Actions(driver);
			WebElement element = driver.findElement(By.xpath(xpathValue));
			action.moveToElement(element).build().perform();
		} catch (Exception e) {
			e.printStackTrace();
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
			e.printStackTrace();
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
		} 
	}

}
