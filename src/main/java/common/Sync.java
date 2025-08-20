package common;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Sync extends Constant{
	WebDriver driver;
	
	 public Sync() {
	 this.driver = BaseSetup.driver;
	 }
	 
	 public void safeImplicitWait(int second)
		{
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));//Gobal wait for all elements
		}
	 
	 public void safeExplicitWait(By locator, int seconds) {
		    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
		    wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		}
	        
	 public void safeFluentWait(String locators, int maxTimeOutSeconds, int pollingEverySeconds)
	 {
		 FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(maxTimeOutSeconds))
				.pollingEvery(Duration.ofSeconds(pollingEverySeconds))
				.ignoring(NoSuchElementException.class);
		 
		 WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locators)));
		 
		 
	 }
}
	        

