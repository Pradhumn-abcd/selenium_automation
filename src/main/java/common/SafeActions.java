package common;

import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;





public class SafeActions extends Sync {
     static WebDriver driver;

    public SafeActions() {
        this.driver = BaseSetup.driver;
    }

    public void safeClick(String locator) throws Exception {
        driver.findElement(By.xpath(locator)).click();
        Thread.sleep(5000);
    }

    public void safeType(String locator, String text) throws Exception {
        driver.findElement(By.xpath(locator)).sendKeys(text);
        Thread.sleep(5000);
    }
    
    public boolean safeIsDisplay(String locator) throws Exception {
    	Thread.sleep(5000);
		return driver.findElement(By.xpath(locator)).isDisplayed();		
	}
    
    public void scrollUpDown(int pixel)throws Exception{
    	JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
    	javascriptExecutor .executeScript("Window.scroll(0, 300)");
    	Thread.sleep(5000);
    }
    
    public void selectDropdownByIndex(WebElement dropdownElement, int index) {
        Select select = new Select(dropdownElement);
        select.selectByIndex(index);
    }
    public void assertTextEquals(WebElement element, String expected, String message) {
        Assert.assertEquals(element.getText().trim(), expected, message);
    }

    
    public void fileUpload(String filePath) throws Exception {
        Robot robot = new Robot();

        // Copy file path to clipboard
        StringSelection selection = new StringSelection(filePath);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null);

       
        // Press CTRL + V
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);

        

        // Press ENTER
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
    } 
    
    
    
    
}