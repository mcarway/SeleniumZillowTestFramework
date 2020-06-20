package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ZillowSearchPageObjects {
	
	WebDriver driver=null;
	WebDriverWait wait;
	//By textbox_search = By.name("q");
	//By search_button = By.name("btnK");
	By forRentLink = By.linkText("Rent");
	By searchBox = By.className("rdc-input");
	By searchButton = By.className("rdc-btn rdc-btn-brand search-btn");
	//By resultCount = By.xpath("//div[@id='srp-list']/div/span");
	By resultCount=By.cssSelector("#search-result-count");
	By waitField=By.cssSelector("#search-result-count");

	String resultNum;
	WebElement myElement;
	WebElement myElement2;

	//This is a constructor that assigns the passed-in driver value to the local driver variable.
	public ZillowSearchPageObjects(WebDriver driver) {
		this.driver = driver;
	}

	public void setSearchText(String text) {
		wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(searchBox));

		driver.findElement(searchBox).sendKeys(text);
		
	}

	public void clearSearchText() {
		driver.findElement(searchBox).clear();
		//driver.findElement(textbox_search).sendKeys(text);
		//driver.findElement(textbox_search).sendKeys(Keys.ESCAPE);
		
	}

	public void clickSearchButton() {
		driver.findElement(searchBox).sendKeys(Keys.RETURN);
		//driver.findElement(searchButton).click();

	}
	
	public void clickForRent() {
		driver.findElement(forRentLink).click();
	}
	
	public String getResultCount() {
		
		wait = new WebDriverWait(driver,40);
		wait.until(ExpectedConditions.visibilityOfElementLocated(waitField));
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='srp-list']/div/span")));
		if(driver.findElements(By.cssSelector("#search-result-count")).size() != 0){ //works
			resultNum=driver.findElement(By.cssSelector("#search-result-count")).getText();
			System.out.println("css used.");
		}else if (driver.findElements(By.xpath("//span[@id='search-result-count']")).size() != 0){ //works
			resultNum=driver.findElement(By.xpath("//span[@id='search-result-count']")).getText();
			System.out.println("span used.");
		}else if (driver.findElements(By.xpath("/html[1]/body[1]/div[5]/div[2]/div[1]/div[1]/div[2]/section[1]/div[2]/div[1]/span[1]")).size() != 0){ //works
			resultNum=driver.findElement(By.xpath("/html[1]/body[1]/div[5]/div[2]/div[1]/div[1]/div[2]/section[1]/div[2]/div[1]/span[1]")).getText();
			System.out.println("span used.");
		}	
		/*
		if (driver.findElements(By.xpath("/html[1]/body[1]/div[5]/div[2]/div[1]/div[1]/div[2]/section[1]/div[2]/div[1]/span[1]")).size() != 0){
			Integer intSize=driver.findElements(By.xpath("/html[1]/body[1]/div[5]/div[2]/div[1]/div[1]/div[2]/section[1]/div[2]/div[1]/span[1]")).size();
			resultNum=driver.findElement(By.xpath("/html[1]/body[1]/div[5]/div[2]/div[1]/div[1]/div[2]/section[1]/div[2]/div[1]/span[1]")).getText();
			System.out.println(intSize);
			System.out.println("css used");
		}*/


//		resultNum=driver.findElement(resultCount).getText();
		//resultNum=driver.findElement(By.xpath("//div[@id='srp-list']/div/span")).getText();

		return resultNum;
	}

}

