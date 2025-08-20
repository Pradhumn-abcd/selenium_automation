package pages;

import org.testng.Reporter;

import common.SafeActions;

public class LeftPanelPage extends SafeActions{

	
	
	
	
	String adminTab = "//span[text()='Admin']";
	String adminVisibility = "//h6[text()='Admin']";
	String pimTab = "//span[text()='PIM']";
	String pimVisibility= "//h6[text()='PIM']";
	String leaveTab = "//span[text()='Leave']";
	String leaveVisibility = "//h6[text()='Admin']";
	String timeTab = "//span[text()='Time']";		
	String timeVisiblity = "//h6[text()='Time']";
			
	
	public void adminTabClick() throws Exception {
		safeClick (adminTab);
		Reporter.log(adminTab +" tab clicked successfully.");
		Thread.sleep(3000);	
	}
	
	public boolean validateAdminPageVisibility(String headerName) throws Exception
	{
		return safeIsDisplay(adminVisibility);
	}

	
	public void pimTabClick() throws Exception
	{
		safeClick(pimTab);
		Reporter.log(pimTab +" tab clicked successfully.");
		Thread.sleep(10000);
		
	}

	
		
		
}
