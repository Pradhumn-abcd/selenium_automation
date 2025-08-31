package common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * ProductUtility
 * Utility methods that build dynamic XPath locators by visible text/placeholder.
 */
public class ProductUtility extends SafeActions {

    public void clickOnLeftPanelTab(String tabName) throws Exception {
        String locator = "//span[text()='" + tabName + "']";
        safeClick(locator);
    }

//    public boolean validateDashboardVisibility(String dashboardName) {
//        String locator = "//h6[text()='" + dashboardName + "']";
//        return isElementPresent(locator); // use SafeActions helper
//    }

    public void clickOnButton(String buttonName) throws Exception {
        String locator = "//button[normalize-space()='" + buttonName + "']";
        safeClick(locator);
    }
    
  
    /**
     * Clicks the dropdown field associated with a given label text.
     *
     * @param label the visible text of the label (e.g., "User Role")
     * @throws Exception if the element is not found or interaction fails
     */
    public void clickDropdownByLabel(String label) throws Exception {
        // Locate dropdown using label text and following div
        String locator = "//label[text()='" + label + "']/following::div[contains(@class,'oxd-select-text')][1]";
        safeClick(locator);
        
    }
    
    
    public void selectDropdownOption(String optionText) throws Exception {
        String locator = "//div[@role='option' and normalize-space()='" + optionText + "']";
        safeClick(locator); 
    }
    

    /** Enter text into an input by its placeholder attribute. */
    public void enterInput(String placeholder, String value) throws Exception {
        By locator = By.xpath("//input[@placeholder='" + placeholder + "']");
        safeType(locator, value);
    }
    
    public void enterUserInfo(String lableName, String value) throws Exception
    {
    	String locator = "//input[@class='oxd-input oxd-input--active'" + lableName + "']";
    	safeType(locator, value);
    }
    
    
    
    public void safeTypeByLabel(String labelName, String text) {
        String locator = "//label[normalize-space()='" + labelName + "']/following::input[1]";
        WebElement element = driver.findElement(By.xpath(locator));
        element.sendKeys(text);
    }
    
    
    
    

    // If you had the old 1-arg method, remove it to avoid confusion:
    // public void enterInput(String para) { ... }  <-- delete this
}
