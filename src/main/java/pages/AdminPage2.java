package pages;

import common.SafeActions;
import common.Sync;
import org.testng.Reporter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Page Object Model (POM) for the Admin Page.
 * Provides methods to perform CRUD operations 
 * (Create, Search, Update, Delete) on Users from the Admin module.
 */
public class AdminPage2 extends SafeActions {

    private static Logger logger = LogManager.getLogger(AdminPage2.class);
     Sync sync = new Sync();

    /* ----------------------------
     * Locators - Create User
     * ---------------------------- */
    private  String addButton = "//button[text()=' Add ']";
    private  String userRoleDropdown = "(//i[@class='oxd-icon bi-caret-down-fill oxd-select-text--arrow'])[1]";
    private  String selectAdmin = "(//div[@class='oxd-select-option'])[2]";
    private  String employeeNameField = "//input[@placeholder='Type for hints...']";
    private  String employeeNameOption = "(//div[@class='oxd-autocomplete-option'])[1]";
    private  String statusDropdown = "(//div[contains(@class,'oxd-select-text--after')])[2]";
    private  String selectStatus = "//span[text()='Enabled']";
    private  String usernameField = "//label[text()='Username']/../following-sibling::div/input";
    private  String passwordField = "(//input[@type='password'])[1]";
    private  String confirmPasswordField = "(//input[@type='password'])[2]";
    private String saveButton = "//button[@type='submit']";

    /* ----------------------------
     * Locators - Search User
     * ---------------------------- */
    private  String searchByUsername = "(//input[@class='oxd-input oxd-input--active'])[2]";
    private  String searchButton = "//button[@type='submit']";

    /* ----------------------------
     * Locators - Update User
     * ---------------------------- */
    private  String editButton = "//i[@class='oxd-icon bi-pencil-fill']";
    private  String editUsernameField = "//*[@id='app']/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[4]/div/div[2]/input";
    private  String saveEditedUserButton = "//button[@type='submit']";

    /* ----------------------------
     * Locators - Delete User
     * ---------------------------- */
    private  String searchByUsernameDel = "(//input[@class='oxd-input oxd-input--active'])[2]";
    private  String searchButtonDel = "//button[@type='submit']";
    private  String deleteButton = "//button[@class='oxd-icon-button oxd-table-cell-action-space']//preceding::i[@class='oxd-icon bi-trash'][1]";
    private  String confirmDeleteButton = "//button[@type='button' and @class='oxd-button oxd-button--medium oxd-button--label-danger orangehrm-button-margin']";

    /* ----------------------------
     * Locators - Messages/Results
     * ---------------------------- */
    // Success/Toast banner shown after save
    private final String successBanner = "//div[contains(@class,'oxd-alert--success') or contains(@class,'toast')][contains(.,'Success')]";

    /* =============================
     * Methods - Create User
     * ============================= */

    public void clickAddButton() throws Exception {
        sync.safeExplicitWait(addButton, 10);
        safeClick(addButton);
        Reporter.log("Clicked Add button", true);
        logger.info("Clicked 'Add' button");
      
    }

    public void userRoleDropdown() throws Exception {
        sync.safeExplicitWait(userRoleDropdown, 10);
        safeClick(userRoleDropdown);
        Reporter.log("Opened User Role dropdown", true);
        logger.info("Opened User Role dropdown");
    }

    public void selectAdminOption() throws Exception {
        sync.safeExplicitWait(selectAdmin, 10);
        safeClick(selectAdmin);
        Reporter.log("Selected Admin role", true);
        logger.info("Selected 'Admin' role");
    }

    public void typeEmployeeName(String name) throws Exception {
        try {
            sync.safeExplicitWait(employeeNameField, 10);
            safeType(employeeNameField, name);
            logger.info("Typed employee name hint: {}", name);

            // Wait for autocomplete suggestion and click first option
            sync.safeExplicitWait(employeeNameOption, 10);
            pause(2000);
            safeClick(employeeNameOption);
            Reporter.log("Selected Employee from suggestions: " + name, true);
            logger.info("Selected employee suggestion for: {}", name);
        } catch (Exception e) {
            logger.error("Failed while entering/selecting employee name: {}", name, e);
            pause(2000);
        }
    }

    public void clickStatusDropdown() throws Exception {
        sync.safeExplicitWait(statusDropdown, 10);
        safeClick(statusDropdown);
        Reporter.log("Opened Status dropdown", true);
        logger.info("Opened Status dropdown");
    }

    public void selectEnableStatus() throws Exception {
        sync.safeExplicitWait(selectStatus, 10);
        safeClick(selectStatus);
        Reporter.log("Selected Enabled status", true);
        logger.info("Selected 'Enabled' status");
        pause(2000);
    }

    // Backward-compatible alias (if old tests call selectEnablestatus)
    public void selectEnablestatus() throws Exception { selectEnableStatus(); }

    public void typeUsername(String username) throws Exception {
        sync.safeExplicitWait(usernameField, 10);
        safeType(usernameField, username);
        Reporter.log("Entered Username: " + username, true);
        logger.info("Entered Username: {}", username);
        pause(2000);
    }

    public void typePassword(String password) throws Exception {
        sync.safeExplicitWait(passwordField, 10);
        safeType(passwordField, password);
        Reporter.log("Entered Password", true);
        logger.info("Entered Password");
        pause(2000);
    }

    public void typeConfirmPassword(String confirmPassword) throws Exception {
        sync.safeExplicitWait(confirmPasswordField, 10);
        safeType(confirmPasswordField, confirmPassword);
        Reporter.log("Entered Confirm Password", true);
        logger.info("Entered Confirm Password");
        pause(2000);
    }

    public void clickSaveButton() throws Exception {
        sync.safeExplicitWait(saveButton, 10);
        safeClick(saveButton);
        Reporter.log("Clicked Save", true);
        logger.info("Clicked Save button");
        pause(4000);
    }

    /* =============================
     * Methods - Search User
     * ============================= */

    public void enterUserNameInField(String username) throws Exception {
        sync.safeExplicitWait(searchByUsername, 10);
        safeType(searchByUsername, username);
        Reporter.log("Entered Username in search field: " + username, true);
        logger.info("Entered Username in search field: {}", username);
    }

    public void clickOnSearchButton() throws Exception {
        sync.safeExplicitWait(searchButton, 10);
        safeClick(searchButton);
        Reporter.log("Clicked on Search button", true);
        logger.info("Clicked on Search button");
    }

    /* =============================
     * Methods - Update User
     * ============================= */

    public void clickOnEditButton() throws Exception {
        scrollUpDown(200);
        sync.safeExplicitWait(editButton, 10);
        safeClick(editButton);
        Reporter.log("Clicked on Edit button", true);
        logger.info("Clicked on Edit button");
    }

    public void updateUserName(String newUsername) throws Exception {
        sync.safeExplicitWait(editUsernameField, 10);
        safeType(editUsernameField, newUsername);
        Reporter.log("Updated Username to: " + newUsername, true);
        logger.info("Updated Username to: {}", newUsername);
    }

    public void clickOnSaveButtonAfterEdit() throws Exception {
        sync.safeExplicitWait(saveEditedUserButton, 10);
        safeClick(saveEditedUserButton);
        Reporter.log("Clicked on Save button after update", true);
        logger.info("Clicked on Save button after update");
    }

    /* =============================
     * Methods - Delete User
     * ============================= */

    public void enterUserNameForDelete(String username) throws Exception {
        sync.safeExplicitWait(searchByUsernameDel, 10);
        safeType(searchByUsernameDel, username);
        Reporter.log("Entered Username for deletion: " + username, true);
        logger.info("Entered Username for deletion: {}", username);
    }

    public void clickOnSearchButtonDel() throws Exception {
        sync.safeExplicitWait(searchButtonDel, 10);
        safeClick(searchButtonDel);
        Reporter.log("Clicked on Search button for deletion", true);
        logger.info("Clicked on Search button for deletion");
    }

    public void clickOnDeleteButton() throws Exception {
        scrollUpDown(200);
        sync.safeExplicitWait(deleteButton, 10);
        safeClick(deleteButton);
        Reporter.log("Clicked on Delete button", true);
        logger.info("Clicked on Delete button");
    }

    public void confirmDeleteUser() throws Exception {
        sync.safeExplicitWait(confirmDeleteButton, 10);
        safeClick(confirmDeleteButton);
        Reporter.log("Confirmed User Deletion", true);
        logger.info("Confirmed User Deletion");
    }

    /* =============================
     * Verifications (for assertions)
     * ============================= */

    /** Returns true if a success/toast banner appears after save. */
    public boolean isUserCreationSuccess() {
        try {
            sync.safeExplicitWait(successBanner, 10);
            logger.info("Success banner detected");
            return true;
        } catch (Exception e) {
            logger.warn("Success banner not detected");
            return false;
        }
    }

    /** Returns true if a row containing the username is shown in the results grid. */
    public boolean isUserPresent(String username) {
        final String userRow = "//div[@role='row']//div[normalize-space()='" + username + "']";
        try {
            sync.safeExplicitWait(userRow, 10);
            logger.info("User '{}' found in results grid", username);
            return true;
        } catch (Exception e) {
            logger.warn("User '{}' NOT found in results grid", username);
            return false;
        }
    }
}
