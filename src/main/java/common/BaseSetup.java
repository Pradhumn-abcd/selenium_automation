package common;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import excel.learning.map.ReadExcel;
import excel.learning.map.*;
import pages.LoginPage;

public class BaseSetup {
	public static WebDriver driver;

	@BeforeSuite
	public void setUp() throws Exception {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://opensource-demo.orangehrmlive.com/");
		Thread.sleep(5000);
	}

	@BeforeTest
	public void setUpLogin() throws Exception {
		LoginPage loginPage = new LoginPage();
		loginPage.login(ReadExcel3.getCellValue("Login",1,0),ReadExcel3.getCellValue("Login",1,1));
	}
	

//	@BeforeMethod
//	public boolean safeIsDisplay(String locator) throws Exception {
//		Thread.sleep(5000);
//		return driver.findElement(By.xpath(locator)).isDisplayed();	
//
//	}
//
//	@AfterMethod
//	public void safeTakeScreenshot(String screenshotName) throws IOException {
//		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
//		File src = takesScreenshot.getScreenshotAs(OutputType.FILE);
//		File des = new File(screenshotName + ".png");
//		FileHandler.copy(src, des);
//	}

	@AfterSuite
	public void close() {
		driver.quit();

	}
}
