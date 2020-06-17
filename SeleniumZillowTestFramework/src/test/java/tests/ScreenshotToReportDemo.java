package tests;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import utils.ScreenshotGrabber;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ScreenshotToReportDemo {
	static WebDriver driver;
	@BeforeSuite
	public void setup(){
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();}

	@BeforeMethod
	public void beforeEachMethod(){
		driver.get("https://google.com");
	}

	//Test case 1
	
	@Test(priority=1)
	public void testForcars() throws Exception {
		Reporter.log("Test case 1. Confirm google returns results for \'Chevrolet cars\'<hr>");
		Reporter.log("Step 1. Run search for \'Chevrolet cars\'");
		driver.findElement(By.name("q")).sendKeys("Chevrolet cars");
		ScreenshotGrabber.reportScreenshot(driver);

		driver.findElement(By.name("q")).sendKeys(Keys.RETURN);

		//Wait for the results to appear
		Thread.sleep(2000);

		//Assert that results were returned as expected.
		Assert.assertTrue(driver.findElement(By.partialLinkText("Chevrolet")).isDisplayed());
		Reporter.log("Result: Results found, as expected.");
		ScreenshotGrabber.reportScreenshot(driver);
		
	}
	//Test case 2.
	@Test(priority=2)
	public void testForTrucks() throws Exception {
		Reporter.log("Test case 2. Confirm google returns results for \'Chevrolet trucks\'<hr>");
		Reporter.log("Step 1. Run search for \'Chevrolet trucks\'");
		driver.findElement(By.name("q")).sendKeys("Chevrolet trucks");
		ScreenshotGrabber.reportScreenshot(driver);

		driver.findElement(By.name("q")).sendKeys(Keys.RETURN);

		//Wait for the results to appear
		Thread.sleep(2000);
		
		//Assert that results were returned as expected.
		Assert.assertTrue(driver.findElement(By.partialLinkText("Chevrolet")).isDisplayed());
		Reporter.log("Result: Results found, as expected.");
		ScreenshotGrabber.reportScreenshot(driver);
/*
		Assert.assertFalse(driver.findElement(By.partialLinkText("truck")).isDisplayed(),"Results NOT found. Test FAILS.");
		//Reporter.log("Results NOT found, as expected.");
		takeScreenshot();
		 	
		if(driver.findElement(By.partialLinkText("truuuuuck")).isDisplayed()){
			//Assert.assertTrue(true, "Results found, as expected."); 
			Reporter.log("Results found, as expected.");
			takeScreenshot();
		}
		else{
			//Assert.assertTrue(false,"Results NOT found, test FAILS.");
			//Reporter.log("Results NOT found, test FAILS.");
			takeScreenshot();
		}*/
	}

	@AfterSuite
	public void endOfSuite(){

		System.out.println("I am the end of suite");
		driver.quit();
	}
/*
	public static void takeScreenshot() throws Exception {
		String timeStamp;
		File screenShotName;
		String workingDir=System.getProperty("user.dir");
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		//The below method will save the screen shot in d drive with name "screenshot.png"
		timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime()); 
		screenShotName = new File(workingDir+"/screenshots/"+timeStamp+".png");
		FileUtils.copyFile(scrFile, screenShotName);

		String filePath = screenShotName.toString();
		String path = "<img src='"+filePath+"'/>";
		Reporter.log(path);

	}*/
}
