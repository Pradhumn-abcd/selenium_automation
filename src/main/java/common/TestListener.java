package common;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {

  
    public void onTestStart(ITestResult result) {
        System.out.println("**********************************************************************");
    }

    
    public void onTestSuccess(ITestResult result) {
        System.out.println("No need to take the screenshot");
    }

    
    public void onTestFailure(ITestResult result) {
        System.out.println("Test Failed: " + result.getName());
    }

    
    public void onTestSkipped(ITestResult result) {
        System.out.println("Execute in case of skip.");
    }

}
