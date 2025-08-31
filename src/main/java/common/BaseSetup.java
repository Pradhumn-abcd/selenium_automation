package common;

import java.lang.reflect.Method;
import java.time.Duration;

import org.testng.Assert;
import org.testng.ITestResult;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import pages.LoginPage;

public class BaseSetup {

    // WebDriver instance (shared across all test classes)
    public static WebDriver driver;

    // ExtentReports instance for test reporting
     static ExtentReports extentReports;

    // ExtentTest instance for logging test steps
     static ExtentTest extentTest;

    /**
     * @BeforeSuite
     * Runs once before the entire test suite starts.
     */
    @BeforeSuite
    public void setUp() throws Exception {

        // Select browser from ConfigManager property file
        switch (ConfigManager.getKeyValue("BROWSERNAME").toUpperCase()) {

            case "CHROME": {
                System.out.println("Launching Chrome browser");

                if (ConfigManager.getKeyValue("HEADLESSMODE").equalsIgnoreCase("headless")) {
                    ChromeOptions chromeOptions = new ChromeOptions();
                    chromeOptions.addArguments("--headless=new"); // modern headless arg
                    driver = new ChromeDriver(chromeOptions);
                } else {
                    driver = new ChromeDriver();
                }
                break;
            }

            case "FF": {
                driver = new FirefoxDriver();
                System.out.println("Launching Firefox browser");
                break;
            }

            case "IE": {
                // IE driver setup (deprecated in Selenium 4+)
                throw new UnsupportedOperationException("IE is not supported. Use Edge instead.");
            }

            case "SAFARI": {
                // Safari works only on macOS
                System.out.println("Launching Safari browser");
                // driver = new SafariDriver(); // uncomment if Safari needed
                break;
            }

            default: {
                throw new IllegalArgumentException("Please select a valid browser: CHROME, IE, FF, SAFARI");
            }
        }

        // Browser window settings
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // Select environment from ConfigManager property file
        String environment = ConfigManager.getKeyValue("ENVIORMENT").toUpperCase();
        switch (environment) {
            case "PROD":
                driver.get(ConfigManager.getKeyValue("PROD"));
                break;
            case "STAGING":
                driver.get(ConfigManager.getKeyValue("STAGING"));
                break;
            case "DEVELOPMENT":
                driver.get(ConfigManager.getKeyValue("DEVELOPMENT"));
                break;
            default:
                throw new IllegalArgumentException("Invalid environment! Please select PROD, STAGING, or DEVELOPMENT.");
        }

        // Initialize Extent Reports
        ExtentSparkReporter extentSparkReporter = new ExtentSparkReporter("Automation.html");
        extentSparkReporter.config().setTheme(Theme.DARK);
        extentSparkReporter.config().setDocumentTitle("HRM");
        extentSparkReporter.config().setReportName("OrangeHRM");

        extentReports = new ExtentReports();
        extentReports.attachReporter(extentSparkReporter);
        extentReports.setSystemInfo("ENV", environment);
        extentReports.setSystemInfo("SUITE", "SMOKE");
        extentReports.setSystemInfo("USERNAME", "MAP");
    }

    /**
     * @BeforeMethod
     * Creates a new ExtentTest node for the current test case.
     */
    @BeforeMethod
    public void bm(Method method) {
        extentTest = extentReports.createTest(method.getName());
    }

    /**
     * @AfterMethod
     * Captures screenshot after every test execution.
     */
    @AfterMethod
    public void captureScreenshot(ITestResult result)
    {
    	if (result.getStatus()==ITestResult.FAILURE)
    	{
    		System.out.println("Test Failed:" + result.getName());
    		captureScreenshot(result);
    	}
    	else if (result.getStatus()==ITestResult.SKIP)
    	{
    		System.out.println("Test Skiped:" + result.getName());
    	}
    	else if (result.getStatus()==ITestResult.SUCCESS)
    	{
    		System.out.println("Test Passes:" + result.getName());
    	}
    	
    }

    /**
     * @BeforeTest
     * Handles application login using credentials from config.
     */
    @BeforeTest
    public void setUpLogin() throws Exception {
        LoginPage loginPage = new LoginPage();
        loginPage.login(ConfigManager.getKeyValue("USERNAME"), ConfigManager.getKeyValue("PASSWORD"));

      //  Assert.assertTrue(driver.getPageSource().contains("Dashboard"),"Dashboard should be visible after login");
        // Avoid Thread.sleep(), prefer explicit waits
        Thread.sleep(5000);
    }

    /**
     * @AfterSuite
     * Runs once after the entire test suite completes.
     */
    @AfterSuite
    public void close() {
        if (driver != null) {
            driver.quit();
        }
        {
            extentReports.flush();
        }
    }

    // ------------------ Logging helper methods ------------------ //

    public static void infoLog(String steps) {
        extentTest.info(steps);
    }

    public static void passLog(String steps) {
        extentTest.pass(steps);
    }

    public static void warningLog(String steps) {
        extentTest.warning(steps);
    }

    public static void failLog(String steps) {
        extentTest.fail(steps);
    }
}
