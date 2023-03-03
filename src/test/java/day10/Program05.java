package day10;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Program05 {

	public static void main(String[] args) {
		WebDriver driver;
		driver = new ChromeDriver();
		driver.get("https://accounts.google.com/signup");
		
		WebElement fn = driver.findElement(By.name("firstName"));
	
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("firstName")));
		wait.until(ExpectedConditions.visibilityOf(fn));
		fn.sendKeys("Test");

	}

}
