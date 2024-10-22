package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages.GoogleSearchPage;

public class GoogleSearchTest {
	
	private static WebDriver driver;

	public static void main(String[] args) {
		//New comment on 10/22 @ 1221.

		WebDriverManager.chromedriver().driverVersion("2.36").setup();
		driver=new ChromeDriver();
		
		//WebDriverManager.firefoxdriver().setup();
		//WebDriver driver=new FirefoxDriver();
		
		//WebDriverManager.iedriver().setup();
		//WebDriver driver=new InternetExplorerDriver();

		driver.get("https://google.com");
		
		//--------------------------------------
		
		//Populate the textbox like so...
		GoogleSearchPage.textbox_search(driver).sendKeys("How to program");
		
		//Click Tab to collapse search results.
		GoogleSearchPage.textbox_search(driver).sendKeys(Keys.RETURN); 
		
		//Click the Search button.
		//GoogleSearchPage.button_search(driver).click();
		//driver.findElement(By.name("btnK")).click();
		//Add a comment to commit and push.

		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		driver.close();
		driver.quit();

	}

}
