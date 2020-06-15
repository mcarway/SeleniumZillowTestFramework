package listeners;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages.GoogleSearchPage;

@Listeners(listeners.TestNGListeners.class)
public class TestNGListenerDemo {
	private static WebDriver driver;
	
	@Test
	public void Test1() {
		System.out.println("I am inside test1");
	}
	@Test
	public void Test2() {
		WebDriverManager.chromedriver().driverVersion("2.36").setup();
		driver=new ChromeDriver();

		System.out.println("I am inside test2");
		driver.get("https://google.com");
		
		//Populate the textbox like so...
		GoogleSearchPage.textbox_search(driver).sendKeys("How to program");
		GoogleSearchPage.textbox_search(driver).sendKeys(Keys.RETURN);
		driver.close();
	}
	@Test
	public void Test3() {
		System.out.println("I am inside test3");
	}

}
