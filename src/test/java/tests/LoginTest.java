package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import common.BaseSetup;
import common.ConfigManager;
import pages.LoginPage;

public class LoginTest extends BaseSetup {

    @Test
    public void testValidLogin() throws Exception {
        LoginPage loginPage = new LoginPage();
        loginPage.login(ConfigManager.getKeyValue("USERNAME"), ConfigManager.getKeyValue("PASSWORD"));
        
//        Assert.assertTrue(driver.getPageSource().contains("Dashboard"),
//                "Dashboard should be visible after login");
    }
}
