package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class searchResultsTest {
	public static WebDriver driver=null;
	public static WebElement whatisit;
	public static WebElement whatisit2;

	public static void main(String[] args) {
		testResults();
	}
	public static void testResults() {
		WebDriverManager.firefoxdriver().setup();
		driver=new FirefoxDriver();
		WebDriverWait wait = new WebDriverWait(driver,30);

		driver.get("https://realtor.com/rentals");
		driver.findElement(By.className("rdc-input")).sendKeys("Queens, NY");
		driver.findElement(By.className("rdc-input")).sendKeys(Keys.RETURN);
		
		wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("srp-header")));
		

		if(driver.findElements(By.xpath("//div[@id='srp-list']/div/span")).size() != 0){
			System.out.println("Xpath worked.");
		}else{
			System.out.println("Xpath failed.");
		}	
		if(driver.findElements(By.cssSelector("#search-result-count")).size() != 0){
			System.out.println("css worked.");
		}else{
			System.out.println("css failed.");
		}	

		//whatisit=driver.findElement(By.xpath("//div[@id='srp-list']/div/span"));
		//whatisit2=driver.findElement(By.cssSelector("#search-result-count"));
		
		//System.out.println("Element 1: "+ whatisit + " \nElement2: "+ whatisit2);
		
		driver.quit();
	}
}
