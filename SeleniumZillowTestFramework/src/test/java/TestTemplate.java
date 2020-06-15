import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestTemplate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().driverVersion("2.36").setup();
		WebDriver driver=new ChromeDriver();
		
		//WebDriverManager.firefoxdriver().setup();
		//WebDriver driver=new FirefoxDriver();
		
		//WebDriverManager.iedriver().setup();
		//WebDriver driver=new InternetExplorerDriver();

		driver.get("https://google.com");
		
		//Create a WebElement variable to control the page, like so...
		WebElement textBox = driver.findElement(By.name("q"));
		textBox.sendKeys("How do I program in Selenium");
			
		//Or... simply append the command to the end of the driver class.function. This line clicks the Escape button to collapse the search dropdown in order to expose the search button so we can click it, in the next line.
		driver.findElement(By.name("q")).sendKeys(Keys.ESCAPE);
		
		//Click the Search button.
		driver.findElement(By.name("btnK")).click();
		
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
