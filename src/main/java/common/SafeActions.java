package common;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
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

    // Shared WebDriver instance from BaseSetup
    protected static WebDriver driver;
    protected WebDriverWait wait;

    private static final Logger logger = LogManager.getLogger(SafeActions.class);

    /**
     * Constructor initializes driver from BaseSetup.
     */
    public SafeActions() {
        driver = BaseSetup.driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(NORMALWAIT));
        logger.info("SafeActions initialized with WebDriver");
    }

    /**
     * Pause execution for given milliseconds.
     */
    public void pause(int millis) {
        try {
            Thread.sleep(millis);
            logger.info("Paused for {} ms", millis);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt(); // restore interrupt
            logger.error("Pause interrupted", e);
        }
    }

    // ======================= Safe Click ======================= //

    /** Safely clicks an element using By locator. */
    public void safeClick(By locator) {
        try {
            WebElement element = waitForClickable(locator);
            element.click();
            logger.info("Clicked on element: {}", locator);
        } catch (Exception e) {
            logger.error("Failed to click element: {}", locator);
            
        }
    }

    /** Overloaded: Safely clicks an element using XPath string. */
    public void safeClick(String xpath) {
        safeClick(By.xpath(xpath));
    }

    // ======================= Safe Type ======================= //

    /** Safely types text into input field using By locator. */
    public void safeType(By locator, String value) {
        try {
            logger.info("Typing '{}' into element: {}", value, locator);
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            element.clear();
            element.sendKeys(value);
            logger.info("Text entered successfully: {}", value);
        } catch (Exception e) {
            logger.error("Failed to type into element: {}", locator, e);
            
        }
    }

    /** Overloaded: Safely types text into input field using XPath string. */
    public void safeType(String xpath, String value) {
        safeType(By.xpath(xpath), value);
    }

    // ======================= Assertions ======================= //

    /** Verifies if element is displayed on page. */
    public boolean safeIsDisplay(String locator) {
        boolean displayed = driver.findElement(By.xpath(locator)).isDisplayed();
        logger.info("Element with xpath '{}' displayed: {}", locator, displayed);
        return displayed;
    }

    /** Asserts element is displayed. */
    public void assertElementDisplayed(String locator) {
        boolean displayed = driver.findElement(By.xpath(locator)).isDisplayed();
        Assert.assertTrue(displayed, "Element is not displayed: " + locator);
        logger.info("Assertion passed: element '{}' is displayed", locator);
    }

    /** Asserts element has expected text. */
    public void assertElementText(String locator, String expectedText) {
        String actual = driver.findElement(By.xpath(locator)).getText().trim();
        logger.info("Asserting text for element '{}'. Expected: '{}', Actual: '{}'",
                locator, expectedText, actual);
        Assert.assertEquals(actual, expectedText, "Text mismatch for element: " + locator);
    }

    /** Asserts input field value matches expected value. */
    public void assertElementValue(String locator, String expectedValue) {
        String actual = driver.findElement(By.xpath(locator)).getAttribute("value").trim();
        logger.info("Asserting value for element '{}'. Expected: '{}', Actual: '{}'",
                locator, expectedValue, actual);
        Assert.assertEquals(actual, expectedValue, "Input value mismatch for: " + locator);
    }

    /** Asserts page title matches expected title. */
    public void assertPageTitle(String expectedTitle) {
        String actual = driver.getTitle();
        logger.info("Asserting page title. Expected: '{}', Actual: '{}'", expectedTitle, actual);
        Assert.assertEquals(actual, expectedTitle, "Page title mismatch");
    }

    /** Asserts element text equals expected text. */
    public void assertTextEquals(WebElement element, String expected, String message) {
        logger.info("Asserting element text. Expected: '{}', Actual: '{}'", expected, element.getText().trim());
        Assert.assertEquals(element.getText().trim(), expected, message);
    }

    // ======================= Dropdown ======================= //

    /** Selects dropdown option by index. */
    public void selectDropdownByIndex(WebElement dropdownElement, int index) {
        logger.info("Selecting index '{}' from dropdown: {}", index, dropdownElement);
        Select select = new Select(dropdownElement);
        select.selectByIndex(index);
    }

    // ======================= Misc Actions ======================= //

    /** Clears input field using XPath. */
    public void safeClear(String xpath) {
        logger.info("Clearing input field with xpath: {}", xpath);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
        element.clear();
    }

    /** Scrolls vertically by given pixels. */
    public void scrollUpDown(int pixel) {
        logger.info("Scrolling vertically by {} pixels", pixel);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0," + pixel + ")");
        pause(1000); // using pause wrapper
    }

    /** Uploads file using Robot class. */
    public void fileUpload(String filePath) throws Exception {
        Robot robot = new Robot();

        StringSelection selection = new StringSelection(filePath);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null);

        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);

        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);

        logger.info("File uploaded successfully: {}", filePath);
    }

    // ======================= Screenshot ======================= //

    /**
     * Captures screenshot on test failure.
     */
    public void captureScreenshotMethods(ITestResult result) throws Exception {
        if (ITestResult.FAILURE == result.getStatus()) {
            logger.error("Test '{}' failed. Capturing screenshot...", result.getName());

            TakesScreenshot ts = (TakesScreenshot) driver;
            File src = ts.getScreenshotAs(OutputType.FILE);

            String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));
            String destPath = System.getProperty("user.dir") + "/screenshots/"
                    + result.getName() + "_" + timestamp + ".png";

            FileHandler.copy(src, new File(destPath));
            logger.info("📸 Screenshot saved at: {}", destPath);
        }
    }
}
