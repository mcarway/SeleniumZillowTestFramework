package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExcelDataProvider {
	
	private static WebDriver driver=null;
	
	@BeforeTest
	public void setUpTest(){
		WebDriverManager.chromedriver().driverVersion("2.36").setup();
		driver=new ChromeDriver();

		//WebDriverManager.firefoxdriver().setup();
		//driver=new FirefoxDriver();

	}
	

	
	@Test(dataProvider="test1Data")
	public void test1(String username, String password) throws InterruptedException {
		driver.get("https://www.netflix.com");
		//driver.findElement(By.className("authLinks redButton")).click();
		driver.findElement(By.linkText("Sign In")).click();
		
		driver.findElement(By.name("userLoginId")).sendKeys(username);
		driver.findElement(By.name("password")).sendKeys(password);
		Thread.sleep(3000);
		
		//driver.close();
		//driver.quit();
		//System.out.println("Username: "+username + " Password: "+password);
	}
	
	@DataProvider(name="test1Data")
	public Object[][] getData() {
		Object data[][] = testData("C:/Users/Mark/eclipse-workspace/SeleniumJavaFramework/excel/data.xls","Sheet1");
		return data;
	}
	
	public static Object[][] testData(String excelPath, String sheetName) {
		ExcelUtils excel=new ExcelUtils(excelPath, sheetName);
		int rowCount=excel.getRowcount();
		int colCount=excel.getColcount();
		Object data[][]=new Object[rowCount-1][colCount];
		
		for(int i=1; i<rowCount; i++) {
			for (int j=0; j<colCount; j++) {
				String cellData=excel.getCellDataString(i, j);
				data[i-1][j]=cellData;
				System.out.println(cellData);
			}
		}
		return data;
		
	}
	

}
