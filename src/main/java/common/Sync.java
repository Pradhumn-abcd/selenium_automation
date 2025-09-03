package common;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Sync class - handles all Selenium wait utilities.
 * Supports implicit, explicit, and fluent waits.
 */
public class Sync extends Constant {
    
    WebDriver driver;

    public Sync() {
        this.driver = BaseSetup.driver;
    }

    /**
     * Global implicit wait for all elements
     * @param seconds Duration in seconds
     */
    public void safeImplicitWait(int seconds) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));
    }

    /**
     * Explicit wait for element visibility (using String XPath locator)
     * @param locator XPath locator string
     * @param seconds Timeout in seconds
     */
    public void safeExplicitWait(String locator, int seconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
    }
    
    public WebElement waitForClickable(By locator) {
        return new WebDriverWait(driver, Duration.ofSeconds(NOWAIT))
                .until(ExpectedConditions.elementToBeClickable(locator));
    }

    public WebElement waitForVisible(By locator) {
        return new WebDriverWait(driver, Duration.ofSeconds(NOWAIT))
                .until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    /**
     * Fluent wait for element visibility (using String XPath locator)
     * @param locator XPath locator string
     * @param maxTimeOutSeconds Max timeout in seconds
     * @param pollingEverySeconds Polling interval in seconds
     */
    public void safeFluentWait(String locator, int maxTimeOutSeconds, int pollingEverySeconds) {
        FluentWait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(maxTimeOutSeconds))
                .pollingEvery(Duration.ofSeconds(pollingEverySeconds))
                .ignoring(NoSuchElementException.class);

        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
    }
}
