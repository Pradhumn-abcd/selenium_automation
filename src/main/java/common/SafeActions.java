package common;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;

/**
 * Utility class that provides safe wrappers for common Selenium actions.
 * Helps improve framework reusability and maintainability.
 */
public class SafeActions extends Sync {

    // Shared WebDriver instance
    static WebDriver driver;

    /**
     * Constructor initializes driver from BaseSetup.
     */
    public SafeActions() {
        this.driver = BaseSetup.driver;
    }

    /**
     * Safely clicks an element using XPath.
     * 
     * @param locator XPath locator of the element
     */
    public void safeClick(String xpath) throws Exception {
        safeClick(By.xpath(xpath));
    }
    public void safeClick(By locator) throws Exception {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
        element.click();
    }
    
    /**
     * Safely types text into an input field using XPath.
     * 
     * @param locator XPath locator of the input field
     * @param text    Text to enter
     */
    public void safeType(By locator, String value) throws Exception {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        element.clear();
        element.sendKeys(value);
    }

    public void safeType(String xpath, String value) throws Exception {
        safeType(By.xpath(xpath), value);
    }
    
    /**
     * Verifies if an element is displayed on the page.
     * 
     * @param locator XPath locator of the element
     * @return true if element is visible, false otherwise
     */
    public boolean safeIsDisplay(String locator) {
        return driver.findElement(By.xpath(locator)).isDisplayed();
    }

    /**
     * Captures a screenshot for the given test result.
     * 
     * @param result ITestResult instance from TestNG
     * @throws Exception if screenshot cannot be saved
     */
    
    public void captureScreenshot(ITestResult result) throws Exception {
        if (ITestResult.FAILURE == result.getStatus()) {
            // Take screenshot
            TakesScreenshot ts = (TakesScreenshot) driver;
            File src = ts.getScreenshotAs(OutputType.FILE);

            // Destination path (only test name)
            String destPath = System.getProperty("user.dir") + "/screenshots/" 
                              + result.getName() + ".png";

            // Save screenshot
            FileHandler.copy(src, new File(destPath));

            System.out.println("📸 Screenshot saved at: " + destPath);
        }
    }

    /**
     * Scrolls vertically by the given number of pixels.
     * 
     * @param pixel Number of pixels to scroll
     * @throws Exception if JavaScript execution fails
     */
    public void scrollUpDown(int pixel) throws Exception {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0," + pixel + ")");
        Thread.sleep(1000);
    }


    public void safeClear(String xpath) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(NORMALWAIT));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
        element.clear();
    }
    
    
    /**
     * Selects an option from a dropdown by index.
     * 
     * @param dropdownElement The dropdown WebElement
     * @param index           Index of the option to select
     */
    public void selectDropdownByIndex(WebElement dropdownElement, int index) {
        Select select = new Select(dropdownElement);
        select.selectByIndex(index);
    }

    /**
     * Asserts that the text of a WebElement matches the expected value.
     * 
     * @param element  WebElement to check
     * @param expected Expected text
     * @param message  Assertion message
     */
    public void assertTextEquals(WebElement element, String expected, String message) {
        Assert.assertEquals(element.getText().trim(), expected, message);
    }

    /**
     * Uploads a file using Robot class by simulating CTRL+V and ENTER.
     * 
     * @param filePath Full path of the file to upload
     * @throws Exception if Robot fails
     */
    public void fileUpload(String filePath) throws Exception {
        Robot robot = new Robot();

        // Copy file path to clipboard
        StringSelection selection = new StringSelection(filePath);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null);

        // Press CTRL+V to paste path
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);

        // Press ENTER
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
    }
}
