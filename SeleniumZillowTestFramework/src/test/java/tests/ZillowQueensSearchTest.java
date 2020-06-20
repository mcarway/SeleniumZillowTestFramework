package tests;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages.ZillowSearchPageObjects;
import utils.*;

public class ZillowQueensSearchTest {

	private static WebDriver driver=null;
	ZillowSearchPageObjects searchPageObj=null;
	private String rentResults="";
	FileWriter files;
	PrintWriter newLine;
	String results;
	Timestamp timeStamp = new Timestamp(System.currentTimeMillis());
    

	@BeforeClass
	public void setup() throws IOException {
		//WebDriverManager.firefoxdriver().setup();
		//driver=new FirefoxDriver();
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		//WebDriverManager.chromedriver().driverVersion("2.36").setup();
		searchPageObj = new ZillowSearchPageObjects(driver);
		//driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		String curDirectory=System.getProperty("user.dir");
		files = new FileWriter(curDirectory+"/txtFiles/results.txt", true); 
		newLine = new PrintWriter(files);
		results="\n\nThis run date and time: "+timeStamp;
		results+="\n----Queens----";

		newLine.print(results);
		//newLine.flush();


	}

	@Test
	public void ZillowSearchQueens() throws Exception {


		driver.get("https://www.realtor.com/rentals");
		
		//Confirm page title.
		Assert.assertEquals(driver.getTitle(), "Apartments for Rent, Condos and Home Rentals | Rental Home Property Search | realtor.com®", "The title on page at "+ driver.getCurrentUrl() + " is incorrect.");

		//driver.navigate().refresh();
		searchPageObj.clearSearchText();
		searchPageObj.setSearchText("Queens, NY");

		//Pause to let the search-ahead catch up.
		try { 
			Thread.sleep(5000);  
		}
		catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		searchPageObj.clickSearchButton();

		results="\nQueens all: "+searchPageObj.getResultCount();

		//Check the title to confirm we're on the right page.
		Assert.assertEquals(driver.getCurrentUrl(), "https://www.realtor.com/apartments/Queens_NY", "You're on the wrong page.");

		newLine.print(results);
		//newLine.flush();
	}


	@Test
	public void ZillowSearchAstoria() throws Exception {

		driver.get("https://www.realtor.com/rentals");
		////driver.navigate().refresh();
		searchPageObj.clearSearchText();
		searchPageObj.setSearchText("Astoria, NY");
		
		//Pause to let the search ahead catch up.
		try { 
			Thread.sleep(5000);  
		}
		catch (InterruptedException e) {
			e.printStackTrace();
		}

		searchPageObj.clickSearchButton();
		//driver.navigate().refresh();
		results="\nAstoria: "+searchPageObj.getResultCount();
		newLine.print(results);
		//newLine.flush();
	}
	
	@Test 
	public void ZillowSearchElmhurst() throws Exception {

		driver.get("https://www.realtor.com/rentals");
		////driver.navigate().refresh();
		searchPageObj.clearSearchText();
		searchPageObj.setSearchText("Elmhurst, NY");

		//Pause for 3 seconds to let the search ahead to catch up.
		try { 
			Thread.sleep(5000);  
		}
		catch (InterruptedException e) {
			e.printStackTrace();
		}

		searchPageObj.clickSearchButton();
		//driver.navigate().refresh();
		results="\nElmhurst: "+searchPageObj.getResultCount();
		newLine.print(results);
		//newLine.flush();
	}


	@Test
	public void ZillowSearchJaxHeights() throws Exception {

		driver.get("https://www.realtor.com/rentals");
		////driver.navigate().refresh();
		searchPageObj.clearSearchText();
		searchPageObj.setSearchText("Jackson Heights, NY");

		//Pause to let the search ahead catch up.
		try { 
			Thread.sleep(5000);  
		}
		catch (InterruptedException e) {
			e.printStackTrace();
		}

		searchPageObj.clickSearchButton();

		results="\nJackson Heights: "+searchPageObj.getResultCount();
		newLine.print(results);
		//newLine.flush();
	}


	@Test
	public void ZillowSearchSunnyside() throws Exception {

		driver.get("https://www.realtor.com/rentals");
		////driver.navigate().refresh();
		searchPageObj.clearSearchText();
		searchPageObj.setSearchText("Sunnyside, NY");

		//Pause for 3 seconds to let the search ahead to catch up.
		try { 
			Thread.sleep(5000);  
		}
		catch (InterruptedException e) {
			e.printStackTrace();
		}

		searchPageObj.clickSearchButton();

		results="\nSunnyside: "+searchPageObj.getResultCount();
		newLine.print(results);
		//newLine.flush();
	}

	@Test
	public void ZillowSearchWoodside() throws Exception {

		driver.get("https://www.realtor.com/rentals");
		////driver.navigate().refresh();
		searchPageObj.clearSearchText();
		searchPageObj.setSearchText("Woodside, NY");

		//Pause for 3 seconds to let the search ahead to catch up.
		try { 
			Thread.sleep(5000);  
		}
		catch (InterruptedException e) {
			e.printStackTrace();
		}

		searchPageObj.clickSearchButton();

		results="\nWoodside: "+searchPageObj.getResultCount();
		newLine.print(results);
		//newLine.flush();
	}
/*
	@Test(priority=7) 
	public void ZillowSearchLICity() throws Exception {

		driver.get("https://www.realtor.com/rentals");
		////driver.navigate().refresh();
		searchPageObj.clearSearchText();
		searchPageObj.setSearchText("Long Island City, NY");

		//Pause for 3 seconds to let the search ahead to catch up.
		try { 
			Thread.sleep(5000);  
		}
		catch (InterruptedException e) {
			e.printStackTrace();
		}

		searchPageObj.clickSearchButton();

		results="\nLong Island City: "+searchPageObj.getResultCount();
		newLine.print(results);
		newLine.flush();
	}
*/
	@AfterClass
	public void tearDown() throws IOException {
		System.out.println(rentResults);
		newLine.flush();
		newLine.close();
		driver.close();
		//killWebDriver.kill();
		//driver.quit();
	}
}


