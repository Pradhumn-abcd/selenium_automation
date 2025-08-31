package pages;

import common.SafeActions;
import common.Sync;
import org.testng.Reporter;

/**
 * Page Object Model (POM) for the Admin Page.
 * 
 * This class provides methods to perform CRUD operations 
 * (Create, Search, Update, Delete) on Users from the Admin module.
 * 
 * All actions use SafeActions wrapper and Sync explicit waits 
 * for stable execution.
 */
public class AdminPage2 extends SafeActions {

     Sync sync = new Sync(); // Sync utility for waits

    /* ----------------------------
     * Locators - Create User
     * ---------------------------- */
    
     String addButton = "//button[@class='oxd-button oxd-button--medium oxd-button--secondary']";
     String userRoleDropdown = "(//i[@class='oxd-icon bi-caret-down-fill oxd-select-text--arrow'])[1]";
     String selectAdmin = "//div[@class='oxd-select-option']//span[text()='Admin']";
     String employeeNameField = "//input[@placeholder='Type for hints...']";
     String employeeNameOption = "(//div[@class='oxd-autocomplete-option'])[1]";
     String statusDropdown = "(//div[contains(@class,'oxd-select-text--after')])[2]";
     String selectStatus = "//span[text()='Enabled']";
     String usernameField = "//label[text()='Username']/../following-sibling::div/input";
     String passwordField = "(//input[@type='password'])[1]";
     String confirmPasswordField = "(//input[@type='password'])[2]";
     String saveButton = "//button[@type='submit']";



    /* ----------------------------
     * Locators - Search User
     * ---------------------------- */
     String searchByUsername = "(//input[@class='oxd-input oxd-input--active'])[2]";
     String searchButton = "//button[@type='submit']";

    /* ----------------------------
     * Locators - Update User
     * ---------------------------- */
     String editButton = "//i[@class='oxd-icon bi-pencil-fill']";
     String editUsernameField = "//*[@id='app']/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[4]/div/div[2]/input";
     String saveEditedUserButton = "//button[@type='submit']";

    /* ----------------------------
     * Locators - Delete User
     * ---------------------------- */
     String searchByUsernameDel = "(//input[@class='oxd-input oxd-input--active'])[2]";
     String searchButtonDel = "//button[@type='submit']";
     String deleteButton = "//button[@class='oxd-icon-button oxd-table-cell-action-space']//preceding::i[@class='oxd-icon bi-trash'][1]";
     String confirmDeleteButton = "//button[@type='button' and @class='oxd-button oxd-button--medium oxd-button--label-danger orangehrm-button-margin']";

    /* =============================
     * Methods - Create User
     * ============================= */

    /**
     * Clicks on Add button to create a new user.
     * @throws Exception 
     */
     public void clickAddButton() throws Exception {
         sync.safeExplicitWait(addButton, NOWAIT);
         safeClick(addButton);
         Reporter.log("Clicked Add button", true);
     }

     public void userRoleDropdown() throws Exception {
         sync.safeExplicitWait(userRoleDropdown, NOWAIT);
         safeClick(userRoleDropdown);
         Reporter.log("Opened User Role dropdown", true);
         Thread.sleep(2000);
     }

     public void selectAdminOption() throws Exception {
         sync.safeExplicitWait(selectAdmin, NOWAIT);
         safeClick(selectAdmin);
         Reporter.log("Selected Admin role", true);
         Thread.sleep(2000);
     }

     public void typeEmployeeName(String name) throws Exception {
         sync.safeExplicitWait(employeeNameField, NOWAIT);
         safeType(employeeNameField, name);
         Thread.sleep(4000);
         sync.safeExplicitWait(employeeNameOption, 10);
         safeClick(employeeNameOption);
         Reporter.log("Entered Employee: " + name, true);
         Thread.sleep(2000);
     }

     public void clickStatusDropdown() throws Exception {
         sync.safeExplicitWait(statusDropdown, NOWAIT);
         safeClick(statusDropdown);
         Reporter.log("Opened Status dropdown", true);
         Thread.sleep(2000);
     }

     public void selectEnablestatus() throws Exception {
         sync.safeExplicitWait(selectStatus, NOWAIT);
         safeClick(selectStatus);
         Reporter.log("Selected Enabled status", true);
         Thread.sleep(2000);
     }

     public void typeUsername(String username) throws Exception {
         sync.safeExplicitWait(usernameField, NOWAIT);
         safeType(usernameField, username);
         Reporter.log("Entered Username: " + username, true);
         Thread.sleep(2000);
     }

     public void typePassword(String password) throws Exception {
         sync.safeExplicitWait(passwordField, NOWAIT);
         safeType(passwordField, password);
         Reporter.log("Entered Password", true);
         Thread.sleep(2000);
     }

     public void typeConfirmPassword(String confirmPassword) throws Exception {
         sync.safeExplicitWait(confirmPasswordField, NOWAIT);
         safeType(confirmPasswordField, confirmPassword);
         Reporter.log("Entered Confirm Password", true);
         Thread.sleep(2000);
     }

     public void clickSaveButton() throws Exception {
         sync.safeExplicitWait(saveButton, NOWAIT);
         
         safeClick(saveButton);
         Reporter.log("Clicked Save", true);
         sync.safeExplicitWait(saveButton, NOWAIT);
         Thread.sleep(5000);
     
     
     }


    /* =============================
     * Methods - Search User
     * ============================= */

    /**
     * Enters a username in Search field.
     */
    public void enterUserNameInField(String username) throws Exception {
        sync.safeExplicitWait(searchByUsername, NOWAIT);
        safeType(searchByUsername, username);
        Reporter.log("Entered Username in search field", true);
        Thread.sleep(2000);
    }

    /**
     * Clicks on Search button to perform search.
     */
    public void clickOnSearchButton() throws Exception {
        sync.safeExplicitWait(searchButton, NOWAIT);
        safeClick(searchButton);
        Reporter.log("Clicked on Search button", true);
        Thread.sleep(2000);
    }

    /* =============================
     * Methods - Update User
     * ============================= */

    /**
     * Clicks on Edit button for a user.
     */
    public void clickOnEditButton() throws Exception {
        sync.safeExplicitWait(editButton, NOWAIT);
        scrollUpDown(200);
        safeClick(editButton);
        Reporter.log("Clicked on Edit button", true);
        Thread.sleep(2000);

    }

    /**
     * Updates username in the edit form.
     */
    public void updateUserName(String newUsername) throws Exception {
        sync.safeExplicitWait(editUsernameField, NOWAIT);
        safeType(editUsernameField, newUsername);
        Reporter.log("Updated Username to: " + newUsername, true);
        Thread.sleep(2000);

    }

    /**
     * Clicks Save button after updating user.
     */
    public void clickOnSaveButtonAfterEdit() throws Exception {
        sync.safeExplicitWait(saveEditedUserButton, NOWAIT);
        safeClick(saveEditedUserButton);
        Reporter.log("Clicked on Save button after update", true);
        Thread.sleep(5000);

    }

    /* =============================
     * Methods - Delete User
     * ============================= */

    public void enterUserNameFordelete(String username) throws Exception {
        sync.safeExplicitWait(searchByUsernameDel, NOWAIT);
        safeType(searchByUsernameDel, username);
        Reporter.log("Entered Username in search field", true);
        Thread.sleep(5000);
    }
    
    public void clickOnSearchButtonDel() throws Exception {
        sync.safeExplicitWait(searchButtonDel, NOWAIT);
        safeClick(searchButtonDel);
        Reporter.log("Clicked on Search button", true);
        Thread.sleep(5000);
    }
    
    
    
    /**
     * Clicks Delete button for a user.
     */
    public void clickOnDeleteButton() throws Exception {
    	sync.safeExplicitWait(deleteButton, NOWAIT);
    	 scrollUpDown(200);
    	safeClick(deleteButton);
//        Reporter.log("Clicked on Delete button", true);
        Thread.sleep(5000);
    }

    /**
     * Confirms delete action for a user.
     */
    public void confirmDeleteUser() throws Exception {
        sync.safeExplicitWait(confirmDeleteButton, NOWAIT);
        safeClick(confirmDeleteButton);
       // Reporter.log("Confirmed User Deletion", true);
        Thread.sleep(5000);
    }
}
