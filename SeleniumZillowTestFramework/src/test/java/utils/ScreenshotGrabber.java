package utils;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ScreenshotGrabber {
	//public static WebDriver driver;

	public static void takeScreenshot(WebDriver driver, String page) {
		WebDriverManager.chromedriver().driverVersion("2.36").setup();
		String curDirectory=System.getProperty("user.dir");
		try {
			File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileHandler.copy(scrFile, new File(curDirectory+"/screenshots/"+ page +".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
