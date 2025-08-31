package common;

import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestResult;

public class IInvokeMethodListExample implements IInvokedMethodListener{

	
	
	 public void beforeInvocation(IInvokedMethod method, ITestResult testResult) {
		   System.out.println("***************beforeInvocation***********************");
		  }

		  public void afterInvocation(IInvokedMethod method, ITestResult testResult) {
			  System.out.println("***************afterInvocation***********************");
		  }
	
}
