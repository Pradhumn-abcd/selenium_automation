package common;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportExample {

	public static void main(String[] args) {
	
		ExtentSparkReporter extentSparkReporter=new ExtentSparkReporter("Automation.html");
		
		ExtentReports extentReports=new ExtentReports();
		
		extentReports.attachReporter(extentSparkReporter);
		
		ExtentTest extentTest=extentReports.createTest("verify add user fun.");
		extentTest.info("Clicked on admin tab.");
		extentTest.pass("Admin clicked successfully");
		
		
		ExtentTest extentTest2=extentReports.createTest("verify search user fun.");
		extentTest.info("Clicked on admin tab.");
		extentTest.fail("Admin clicked successfully");
		
		
		extentReports.flush();
	
		
		

	}

}
