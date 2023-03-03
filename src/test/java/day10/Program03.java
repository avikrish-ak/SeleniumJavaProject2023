package day10;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Program03 {

	public static void main(String[] args) {
		WebDriver driver;
		driver = new ChromeDriver();
		driver.get("https://accounts.google.com/signup");
		
		WebElement fn = driver.findElement(By.xpath("//input[@type='checkbox']"));
		
		fn.click();
		
		System.out.println(fn.isSelected());
		
		if(fn.isSelected())
		{
			System.out.println("Checked");
			
		}
		else
		{
			System.out.println("Un-Checked");
		}

	}

}
