package pages;

import org.openqa.selenium.By;
import common.ProductUtility;
import common.SafeActions;

public class LoginPage extends ProductUtility {

	   private By usernameField = By.xpath("//input[@placeholder='Username']");
	    private By passwordField = By.xpath("//input[@placeholder='Password']");
	    private By loginButton   = By.xpath("//button[normalize-space()='Login']");
	    private By dashboardTitle = By.xpath("//h1[contains(text(),'Dashboard')]");

	    public void login(String username, String password) throws Exception {
	        safeType(usernameField, username);
	        safeType(passwordField, password);
	        safeClick(loginButton);
	     
	    }
	}