package tests;

import common.BaseSetup;
import common.TestDataStore;
import common.UtilityMethods;
import pages.AdminPage2;
import pages.LeftPanelPage;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class AdminTest2 extends BaseSetup {

    @Test(priority = 1, groups = {"smoke", "regression"})
    @Parameters({"environment"})
    public void createAdminUser() throws Exception {
        LeftPanelPage leftPanelPage = new LeftPanelPage();
        leftPanelPage.adminTabClick();
        
        String randomUsername = "User" + UtilityMethods.generateRandomString(5);
        String randomPassword = "Pass@1" + UtilityMethods.generateRandomString(8);
        
        // store in TestDataStore for reuse
        TestDataStore.createdUsername = randomUsername;
        TestDataStore.createdPassword = randomPassword;
        
        
        String userPassword = TestDataStore.createdPassword;
        
        AdminPage2 adminpage = new AdminPage2();
        adminpage.clickAddButton();
        adminpage.userRoleDropdown();
        adminpage.selectAdminOption();
        adminpage.typeEmployeeName("T"); // must exist in system
        adminpage.clickStatusDropdown();
        adminpage.selectEnablestatus();
        adminpage.typeUsername(randomUsername);
        adminpage.typePassword(randomPassword);
        adminpage.typeConfirmPassword(userPassword);
        adminpage.clickSaveButton();
    }

    @Test(priority = 2, groups = {"smoke"})
    @Parameters({"environment"})
    public void searchUserFunctionality() throws Exception{
    	String userToSearch = TestDataStore.createdUsername;
    	AdminPage2 adminpage = new AdminPage2();
        adminpage.enterUserNameInField(userToSearch);
        adminpage.clickOnSearchButton();
    }

    @Test(priority = 3, groups = {"regression"})
    @Parameters({"environment"})
    public void updateUserFunctionality() throws Exception {
    	String userToUpdate = TestDataStore.createdUsername;
        AdminPage2 adminpage = new AdminPage2();
        adminpage.clickOnEditButton();
        adminpage.updateUserName(userToUpdate);
       adminpage.clickOnSaveButtonAfterEdit();
    }

//    @Test(priority = 4)
//    public void deleteUserFunctionality() throws Exception {
//    	String userToDelete = TestDataStore.createdUsername;
//        AdminPage2 adminpage = new AdminPage2();
//        adminpage.enterUserNameFordelete(userToDelete);
//        adminpage.clickOnSearchButtonDel();
//        adminpage.clickOnDeleteButton();
//       adminpage.confirmDeleteUser();
//   }
}
