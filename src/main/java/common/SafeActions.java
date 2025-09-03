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
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Utility class that provides safe wrappers for common Selenium actions.
 * Helps improve framework reusability and maintainability.
 */
public class SafeActions extends Sync {

    // Shared WebDriver instance
    static WebDriver driver;
    WebDriverWait wait;
    
    private static final Logger logger = LogManager.getLogger(SafeActions.class);
    
    
    /**
     * Constructor initializes driver from BaseSetup.
     */
    public SafeActions() {
        this.driver = BaseSetup.driver;
        new WebDriverWait(driver, Duration.ofSeconds(NOWAIT));
        logger.info("SafeActions initialized with WebDriver");
    }

    /**
     * Safely clicks an element using XPath.
     * 
     * @param locator XPath locator of the element
     */
 // main implementation (By based)
    public void safeClick(By locator) {
        WebElement element = waitForClickable(locator);
        element.click();
        logger.info("Clicked on element: {}", locator);
    }
    

    // Overload 2: Accepts String (XPath)
    public void safeClick(String xpath) {
        safeClick(By.xpath(xpath)); // calls By-based version, no recursion back
    }
    
    /**
     * Safely types text into an input field using XPath.
     * 
     * @param locator XPath locator of the input field
     * @param text    Text to enter
     */
    public void safeType(By locator, String value) throws Exception {
        logger.info("Typing '{}' into element: {}", value, locator);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        element.clear();
        element.sendKeys(value);
        logger.info("Text entered successfully: {}", value);

    }

    public void safeType(String xpath, String value) throws Exception {
        logger.info("Typing '{}' into element with xpath: {}", value, xpath);
        safeType(By.xpath(xpath), value);
    }
    
    /**
     * Verifies if an element is displayed on the page.
     * 
     * @param locator XPath locator of the element
     * @return true if element is visible, false otherwise
     */
    public boolean safeIsDisplay(String locator) {
        logger.info("Element with xpath '{}' displayed: {}", locator);

        return driver.findElement(By.xpath(locator)).isDisplayed();
    }

    //.................................Assertion................................................//
    
 // Check element is displayed
    public void assertElementDisplayed(String locator) {
        logger.info("Asserting element is displayed: {}", locator);

        Assert.assertTrue(driver.findElement(By.xpath(locator)).isDisplayed(),
                "Element is not displayed: " + locator);
        logger.info("Assertion passed for element display: {}", locator);

    }

    // Check element has expected text
    public void assertElementText(String locator, String expectedText) {
        String actual = driver.findElement(By.xpath(locator)).getText().trim();
        logger.info("Asserting text for element '{}'. Expected: '{}', Actual: '{}'", locator, expectedText, actual);
        Assert.assertEquals(actual, expectedText, 
                "Text mismatch for element: " + locator);
    }

    // Check input field value
    public void assertElementValue(String locator, String expectedValue) {
        String actual = driver.findElement(By.xpath(locator)).getAttribute("value").trim();
        logger.info("Asserting value for element '{}'. Expected: '{}', Actual: '{}'", locator, expectedValue, actual);
        Assert.assertEquals(actual, expectedValue, 
                "Input value mismatch for: " + locator);
    }

    // Check page title
    public void assertPageTitle(String expectedTitle) {
        String actual = driver.getTitle();
        logger.info("Asserting page title. Expected: '{}', Actual: '{}'", expectedTitle, actual);
        Assert.assertEquals(actual, expectedTitle, 
                "Page title mismatch");
    }
    
    
    
    
    
    
    

    /**
     * Captures a screenshot for the given test result.
     * 
     * @param result ITestResult instance from TestNG
     * @throws Exception if screenshot cannot be saved
     */
    
    public void captureScreenshot(ITestResult result) throws Exception {
        if (ITestResult.FAILURE == result.getStatus()) {
        	logger.error("Test '{}' failed. Capturing screenshot...", result.getName());
            // Take screenshot
            TakesScreenshot ts = (TakesScreenshot) driver;
            File src = ts.getScreenshotAs(OutputType.FILE);

            // Destination path (only test name)
            String destPath = System.getProperty("user.dir") + "/screenshots/" 
                              + result.getName() + ".png";

            // Save screenshot
            FileHandler.copy(src, new File(destPath));
            logger.info("📸 Screenshot saved at: {}", destPath);

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
        logger.info("Scrolling vertically by {} pixels", pixel);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0," + pixel + ")");
        Thread.sleep(1000);
    }


    public void safeClear(String xpath) {
        logger.info("Clearing input field with xpath: {}", xpath);
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
        logger.info("Selecting index '{}' from dropdown: {}", index, dropdownElement);
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
        logger.info("Asserting element text. Expected: '{}', Actual: '{}'", expected, element.getText().trim());

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
