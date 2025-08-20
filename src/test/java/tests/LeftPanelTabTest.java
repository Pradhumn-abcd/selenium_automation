package tests;

import org.testng.annotations.Test;
import common.BaseSetup;
import pages.LeftPanelPage;

public class LeftPanelTabTest extends BaseSetup {

    

    @Test
    public void leftPanelTab() throws Exception {
        // Call method on the object, with correct argument (pass locator)
    	
    	LeftPanelPage leftpanelpage = new LeftPanelPage();
    	
    	leftpanelpage.adminTabClick();
    	
    	
    	
    	
    }
}
