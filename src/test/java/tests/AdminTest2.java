package tests;

import common.BaseSetup;
import common.TestDataStore;
import common.UtilityMethods;
import pages.AdminPage2;
import pages.LeftPanelPage;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 * Test Class for Admin Module
 * 
 * Covers CRUD operations (Create, Search, Update, Delete) for Admin Users in
 * OrangeHRM application.
 * 
 * Uses Page Object Model (POM) with SafeActions wrapper, ExtentReports for
 * logging, and TestNG for execution.
 */
public class AdminTest2 extends BaseSetup {

	// Page Object references
	private AdminPage2 adminpage;
	private LeftPanelPage leftPanelPage;

	// Employee hint text used for search in auto-complete
	private static final String EMPLOYEE_HINT = "T";

	/**
	 * Initialize page objects before every test.
	 */
	@BeforeMethod
	public void initPages() {
		adminpage = new AdminPage2();
		leftPanelPage = new LeftPanelPage();
	}

	/**
	 * Test Case 1: Create a new Admin User.
	 * 
	 * Steps: 1. Navigate to Admin tab 2. Click "Add" button 3. Select User Role =
	 * Admin 4. Enter Employee name (auto-complete) 5. Select Status = Enabled 6.
	 * Enter Username and Password 7. Save user
	 * 
	 * Validation: - Success banner/toast should appear
	 */
	@Test(priority = 1, groups = { "smoke", "regression" })
	public void createAdminUser() throws Exception {
		leftPanelPage.adminTabClick();

		// Generate random test data
		String randomUsername = "User" + UtilityMethods.generateRandomString(5);
		String randomPassword = "Pass@" + UtilityMethods.generateRandomString(8);

		// Store data for reuse across tests
		TestDataStore.createdUsername = randomUsername;
		TestDataStore.createdPassword = randomPassword;

		// Perform user creation flow
		adminpage.clickAddButton();
		adminpage.userRoleDropdown();
		adminpage.selectAdminOption();
		adminpage.typeEmployeeName(EMPLOYEE_HINT);
		adminpage.clickStatusDropdown();
		adminpage.selectEnableStatus();
		adminpage.typeUsername(randomUsername);
		adminpage.typePassword(randomPassword);
		adminpage.typeConfirmPassword(randomPassword);
		adminpage.clickSaveButton();

		// Assert success
		Assert.assertTrue(adminpage.isUserCreationSuccess(), "User creation did not show success confirmation!");
	}

	/**
	 * Test Case 2: Search the newly created user.
	 * 
	 * Precondition: - User should already be created (depends on createAdminUser)
	 * 
	 * Steps: 1. Navigate to Admin tab 2. Enter Username in Search field 3. Click
	 * Search
	 * 
	 * Validation: - User should appear in search results grid
	 */
	@Test(priority = 2, groups = { "smoke" }, dependsOnMethods = "createAdminUser")

	public void searchUserFunctionality() throws Exception {
		String userToSearch = TestDataStore.createdUsername;

		leftPanelPage.adminTabClick(); // Ensure correct page
		adminpage.enterUserNameInField(userToSearch);
		adminpage.clickOnSearchButton();

		Assert.assertTrue(adminpage.isUserPresent(userToSearch), "User not found in search results!");
	}

	/**
	 * Test Case 3: Update existing user details (disabled by default).
	 * 
	 * Precondition: - User should already exist in grid
	 * 
	 * Steps: 1. Navigate to Admin tab 2. Click Edit button 3. Update Username 4.
	 * Save changes
	 * 
	 * Validation: - Success banner should appear - Grid should show updated
	 * username
	 */
	@Test(priority = 3, groups = { "regression" }, dependsOnMethods = "searchUserFunctionality", enabled = false)
	@Parameters({ "environment" })
	public void updateUserFunctionality() throws Exception {
		String newUsername = TestDataStore.createdUsername + "_upd";

		leftPanelPage.adminTabClick();
		adminpage.clickOnEditButton();
		adminpage.updateUserName(newUsername);
		adminpage.clickOnSaveButtonAfterEdit();

		Assert.assertTrue(adminpage.isUserCreationSuccess(), "Update did not show success confirmation!");
		Assert.assertTrue(adminpage.isUserPresent(newUsername), "Updated user not found in grid!");

		// Propagate updated username for future tests
		TestDataStore.createdUsername = newUsername;
	}

	/**
	 * Test Case 4: Delete a user (disabled by default).
	 * 
	 * Steps: 1. Navigate to Admin tab 2. Search the user 3. Click Delete icon 4.
	 * Confirm deletion
	 * 
	 * Validation: - User should not appear in grid after deletion
	 */
//    @Test(priority = 4, dependsOnMethods = "searchUserFunctionality", enabled = false)
//    public void deleteUserFunctionality() throws Exception {
//        String userToDelete = TestDataStore.createdUsername;
//
//        leftPanelPage.adminTabClick();
//        adminpage.enterUserNameForDelete(userToDelete);
//        adminpage.clickOnSearchButtonDel();
//        adminpage.clickOnDeleteButton();
//        adminpage.confirmDeleteUser();
//
//        Assert.assertFalse(
//            adminpage.isUserPresent(userToDelete),
//            "User still present after deletion!"
//        );
//    }
}
