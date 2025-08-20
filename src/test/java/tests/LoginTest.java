package tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;



public class LoginTest {
	
	
	@BeforeSuite
	public void beforSuite()
	{
		System.out.println("Before Suit start");
	}
	
	
	
	@BeforeTest
	public void beforeTest()
	{
		System.out.println("Before test start");
	}
	
	@BeforeClass
	public void beforeClass()
	{
		System.out.println("before test complete");
	}
	
	@AfterClass
	public void afterClass()
	{
		System.out.println("After test complete");
	}
	 @BeforeMethod
	    public void beforeMethod() {
	        System.out.println("Before Method starts");
	}
	
	 @Test(priority = 1)
	    public void testCase1() {
	        System.out.println("Test Case 1");
	    }
	 
	 @Test(priority = 2)
	    public void testCase2() {
	        System.out.println("Test Case 2 ");
	    }
	 
	 
	 
	@AfterMethod
	public void afterMethod()
	{
		System.out.println("After Method end");
	}
	
	
	
	
	 
	 
	
	@AfterTest
	public void AfterTest()
	{
		System.out.println("After Test complete");
	}
	
	
	
	
	@AfterSuite
	public void afterSuite()
	{
		System.out.println("After Suit complete");
	}
	
	
}
