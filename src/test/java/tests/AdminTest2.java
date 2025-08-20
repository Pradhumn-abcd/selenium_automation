package tests;

import common.BaseSetup;
import pages.AdminPage2;
import pages.LeftPanelPage;
import org.testng.annotations.Test;

public class AdminTest2 extends BaseSetup {

    @Test(priority = 1)
    public void createAdminUser() throws Exception {
        LeftPanelPage leftPanelPage = new LeftPanelPage();
        leftPanelPage.adminTabClick();
        AdminPage2 adminpage = new AdminPage2();

        adminpage.clickAddButton();
        adminpage.clickUserRoleDropdown();
        adminpage.selectAdminOption();
        adminpage.typeEmployeeName("Test");
        adminpage.clickStatusDropdown();
        adminpage.selectEnablestatus();
        adminpage.typeUsername("JohnqAdmin");
        adminpage.typePassword("Password123");
        adminpage.typeConfirmPassword("Password123");
        adminpage.clickSaveButton();
    }

    @Test(priority = 2)
    public void searchUserFunctionality() throws Exception {
        AdminPage2 adminpage = new AdminPage2();
        adminpage.enterUserNameInField("JohnqAdmina");
        adminpage.clickOnSearchButton();
    }

    @Test(priority = 3)
    public void updateUserFunctionality() throws Exception {
        AdminPage2 adminpage = new AdminPage2();
        adminpage.UpdateUserFunctionality();
        adminpage.enterUserName("a");
        adminpage.clickOnSaveButtonR();
    }

    @Test(priority = 4)
    public void deleteUserFunctionality() throws Exception {
        AdminPage2 adminpage = new AdminPage2();
        adminpage.searchUserFromUsername("JohnqAdminaa");
        adminpage.clkOnSearchButton();
        adminpage.deleteButtonClick();
        adminpage.confirmDeleteUser();
    }
}
