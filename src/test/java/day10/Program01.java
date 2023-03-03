package day10;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Program01 {

	public static void main(String[] args) {
		WebDriver driver;
		driver = new ChromeDriver();
		driver.get("https://accounts.google.com/signup");
		
		WebElement fn = driver.findElement(By.name("firstName"));
		
		System.out.println(fn.isDisplayed());
		
		if(fn.isDisplayed())
		{
			fn.sendKeys("FirstName");
			
		}
		else
		{
			System.out.println("First Name is not displayed");
		}

	}

}
