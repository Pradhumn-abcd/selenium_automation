package pages;

import common.Constant;
import common.SafeActions;
import common.Sync;

import org.openqa.selenium.By;
import org.testng.Reporter;

public class PIMPage extends SafeActions {

	
	//Action
	String clickOnAdd = "//button[normalize-space()='Add']";
	String enterUsername = "//input[@placeholder='First Name']";
	String enterlastName = "//input[@placeholder='Last Name']";
	String employeeID = "(//input[@class='oxd-input oxd-input--active'])[2]";
	String clickOnPlusIcon = "//i[@class='oxd-icon bi-plus']";
	String clickOnSaveButton = "//button[text()=' Save ']";	
	String enterExpiryDate="(//input[@class='oxd-input oxd-input--active'])[5]";
	String clickOnNationalityDD   = "(//i[@class='oxd-icon bi-caret-down-fill oxd-select-text--arrow']/parent::div[@class='oxd-select-text--after'])[1]";
	String selectNationalityDD  ="(//div[@class='oxd-select-option'])[2]";
	String clickOnMaritalStatusDD  ="(//div[@class='oxd-select-text oxd-select-text--active'])[2]";
	String selectMaritalDD = "(//div[@class='oxd-select-option'])[2]";
	String clickOnSaveButton1 = "(//button[text()=' Save '])[1]";
	String clickoncontactDetailsTab ="//a[text()='Contact Details']";
	String selectCountrySelect = "//div[text()='-- Select --']";
	String clickOnSaveButton2 = "//button[text()=' Save ']";
	String clickOnPIMTab= "//span[text()='PIM']";
	String enterEmployeeName = "(//input[@placeholder='Type for hints...'])[1]";
	String clickOnSearchButton = "//button[text()=' Search ']";
	String clickOnResult = "(//div[@class='oxd-table-row oxd-table-row--with-border oxd-table-row--clickable'])[1]";
	String enterEmployeeNameUpdate = "//input[@class='oxd-input oxd-input--active orangehrm-firstname']";
	String clickOnSaveButtonUpdate = "//button[@class='oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space']";
	
	
	
	
//methods 
	
	public void clickOnAddButton() throws Exception {
		safeClick(clickOnAdd);
		Reporter.log("Clicked on Add button successfully", true);
		Thread.sleep(8000);
		
	}
	
	public void enterUserNameField(String name) throws Exception{
		safeType(enterUsername, name);
		Reporter.log("Enter the User Name successfully", true);
		Thread.sleep(3000);
	}

	public void enterLastNameField(String lastname) throws Exception{
		safeType(enterlastName, lastname);
		Reporter.log("Enter the Last Name successfully", true);
		Thread.sleep(3000);
	}
	
	
	public void enterEmployeeID (String ID) throws Exception {
	safeType(employeeID, "11122");
	Reporter.log("Enter the employeeID successfully", true);
	Thread.sleep(3000);
	}
	
	
	
	public void clickOnPlusForUpload() throws Exception
	{
		safeClick (clickOnPlusIcon);
		Reporter.log("Clicked on plus icon successfully", true);
		Thread.sleep(3000);
	}
	
	
	public void uploadImage (String filePath) throws Exception {
		
		fileUpload("filePath");
		Thread.sleep(10000);
		
	}
	

	public void clickOnSaveButtonforCreateUser() throws Exception{
		safeClick(clickOnSaveButton);
		Reporter.log("Clicked on Add button", true);
		Thread.sleep(8000);
	}
	
	public void enterExpiryDatefield(String date) throws Exception {
		safeType(enterExpiryDate, date);
		Reporter.log("Enter date in field", true);
		Thread.sleep(5000);
	}
	
//	public void clickOnNationalityDDField() throws Exception{
//		safeClick(clickOnNationalityDD);
//		Reporter.log("Click on nationality", true);
//		Thread.sleep(8000);
//	}
//	public void selectNationalityFromDropdown()throws Exception {
//		safeClick(selectNationalityDD);
//		Reporter.log("Select on nationality", true);
//		Thread.sleep(8000);
//	}

	public void clickOnMaritalStatusDD() throws Exception {
		safeClick(clickOnMaritalStatusDD);
		Reporter.log("click on marital dropdown", true);
		Thread.sleep(8000);
	}
	
	public void selectMaritalFromDropdown() throws Exception {
		safeClick(selectMaritalDD);
		Reporter.log("Select marital Status", true);
		Thread.sleep(8000);

	}
	
	public void clickOnFirstSaveButton1() throws Exception {
		safeClick(clickOnSaveButton1);
		Reporter.log("Clicked on save button", true);
		Thread.sleep(8000);
	}
	
	public void clickOncontactDetails() throws Exception {
		safeClick(clickoncontactDetailsTab);
		Reporter.log("Clicked on save button", true);
		Thread.sleep(8000);
	}
	
	public void selectCountryFromDD() throws Exception {
		safeClick(selectCountrySelect);
		Reporter.log("Clicked on save button", true);
		Thread.sleep(8000);
	}
	
	public void clickOnSaveButton() throws Exception {
		safeClick(clickOnSaveButton2);
		Reporter.log("Clicked on save button", true);
		Thread.sleep(8000);
	}
	
	public void clickOnPIMTabRef() throws Exception{
		safeClick(clickOnPIMTab);
		Reporter.log("Clicked on PIM Tab", true);
		Thread.sleep(8000);
		
	}
	public void enterEmploUsername(String username) throws Exception
	{
		safeType(enterEmployeeName, username);
		Reporter.log("Clicked on employeeName", true);
		Thread.sleep(8000);
	}
	
	public void clickSearchButton () throws Exception
	{
		safeClick(clickOnSearchButton);
		Reporter.log("Clicked on search button", true);
		Thread.sleep(8000);
		scrollUpDown(300);	
	}
	
	public void clickOnResultFirst() throws Exception {
		safeClick(clickOnResult);
		Reporter.log("Clicked on edit button", true);
		Thread.sleep(8000);
	}
	
	public void updateEmployeeName(String employeename) throws Exception 
	{
		safeType(enterEmployeeNameUpdate, employeename);
		Reporter.log("Entered  update Employeee successfully", true);
		scrollUpDown(300);	
		Thread.sleep(8000);
	}
		
	public void saveUpdatedEmployee() throws Exception 
	{
		safeClick(clickOnSaveButtonUpdate);
		Reporter.log("Click on save button to update", true);
		Thread.sleep(8000);
	}

	
	
}






package pages;

import common.SafeActions;
import common.Sync;
import org.testng.Reporter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

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
     private static final Logger logger = LogManager.getLogger(AdminPage2.class);


    /* ----------------------------
     * Locators - Create User
     * ---------------------------- */
    
     String addButton = "//button[text()=' Add ']";
     String userRoleDropdown = "(//i[@class='oxd-icon bi-caret-down-fill oxd-select-text--arrow'])[1]";
     String selectAdmin = "(//div[@class='oxd-select-option'])[2]";
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
       
         safeClick(addButton);
         //Reporter.log("Clicked Add button", true);
         //assertElementDisplayed(addButton);
        // logger.info("'Add User' button clicked successfully");

     }

     public void userRoleDropdown() throws Exception {
      //  sync.safeExplicitWait(userRoleDropdown, NOWAIT);
         safeClick(userRoleDropdown);
         Reporter.log("Opened User Role dropdown", true);
      //   Thread.sleep(2000);
       //  assertElementDisplayed(userRoleDropdown);
         logger.info("Dropdown clicked successfully");
     }

     public void selectAdminOption() throws Exception {
        // sync.safeExplicitWait(selectAdmin, NOWAIT);
         safeClick(selectAdmin);
         Reporter.log("Selected Admin role", true);
         Thread.sleep(2000);
         assertElementDisplayed(selectAdmin); 
         logger.info("selectAdminOption clicked successfully");

     }

     public void typeEmployeeName(String name) throws Exception {
    	 Thread.sleep(2000);
    	 try {
    	        safeType(employeeNameField, name);
    	        logger.info("Typed employee name: {}", name);

    	       // sync.safeExplicitWait(employeeNameOption, 10);
    	        Thread.sleep(2000);
    	        safeClick(employeeNameOption);
    	        Reporter.log("Entered Employee: " + name, true);

    	        assertElementDisplayed(employeeNameOption);
    	        logger.info("Employee option displayed successfully for: {}", name);
    	    } catch (Exception e) {
    	        logger.error("Failed while entering employee name: {}", name, e);
    	        throw e;
    	    }
    	}

     public void clickStatusDropdown() throws Exception {
        // sync.safeExplicitWait(statusDropdown, NOWAIT);
         safeClick(statusDropdown);
         Reporter.log("Opened Status dropdown", true);
         Thread.sleep(2000);
         assertElementDisplayed(statusDropdown);
         logger.info("status dropdown clicked successfully");

         
     }

     public void selectEnablestatus() throws Exception {
        // sync.safeExplicitWait(selectStatus, NOWAIT);
         safeClick(selectStatus);
         Reporter.log("Selected Enabled status", true);
         Thread.sleep(2000);
         assertElementDisplayed(statusDropdown);



     }

     public void typeUsername(String username) throws Exception {
        // sync.safeExplicitWait(usernameField, NOWAIT);
         safeType(usernameField, username);
         Reporter.log("Entered Username: " + username, true);
         Thread.sleep(2000);
         assertElementDisplayed(usernameField);
         logger.info("username type successfully");

     }

     public void typePassword(String password) throws Exception {
        // sync.safeExplicitWait(passwordField, NOWAIT);
         safeType(passwordField, password);
         Reporter.log("Entered Password", true);
         Thread.sleep(2000);
         assertElementDisplayed(passwordField);
         logger.info("password type successfully");


     }

     public void typeConfirmPassword(String confirmPassword) throws Exception {
        // sync.safeExplicitWait(confirmPasswordField, NOWAIT);
         safeType(confirmPasswordField, confirmPassword);
         Reporter.log("Entered Confirm Password", true);
         Thread.sleep(2000);
         assertElementDisplayed(confirmPasswordField);
         logger.info("comformpassword type successfully");

     }

     public void clickSaveButton() throws Exception {
         //sync.safeExplicitWait(saveButton, NOWAIT);
         
         safeClick(saveButton);
         Reporter.log("Clicked Save", true);
         sync.safeExplicitWait(saveButton, NOWAIT);
         Thread.sleep(5000);
         assertElementDisplayed(saveButton);
         logger.info("save button clicked successfully");
     
     }


    /* =============================
     * Methods - Search User
     * ============================= */

    /**
     * Enters a username in Search field.
     */
    public void enterUserNameInField(String username) throws Exception {
      //  sync.safeExplicitWait(searchByUsername, NOWAIT);
        safeType(searchByUsername, username);
        Reporter.log("Entered Username in search field", true);
        Thread.sleep(2000);
        assertElementDisplayed(searchByUsername);
        logger.info("username type successfully");

        
    }

    /**
     * Clicks on Search button to perform search.
     */
    public void clickOnSearchButton() throws Exception {
        //sync.safeExplicitWait(searchButton, NOWAIT);
        safeClick(searchButton);
        Reporter.log("Clicked on Search button", true);
        Thread.sleep(2000);
        assertElementDisplayed(searchButton);
        logger.info("search clicked successfully");


    }

    /* =============================
     * Methods - Update User
     * ============================= */

    /**
     * Clicks on Edit button for a user.
     */
    public void clickOnEditButton() throws Exception {
      //  sync.safeExplicitWait(editButton, NOWAIT);
        scrollUpDown(200);
        safeClick(editButton);
        Reporter.log("Clicked on Edit button", true);
        Thread.sleep(2000);
        assertElementDisplayed(editButton);
        logger.info("edit clicked successfully");


    }

    /**
     * Updates username in the edit form.
     */
    public void updateUserName(String newUsername) throws Exception {
     //   sync.safeExplicitWait(editUsernameField, NOWAIT);
        safeType(editUsernameField, newUsername);
        Reporter.log("Updated Username to: " + newUsername, true);
        Thread.sleep(2000);
        assertElementDisplayed(editUsernameField);
        logger.info("enterupdated name successfully");

    }

    /**
     * Clicks Save button after updating user.
     */
    public void clickOnSaveButtonAfterEdit() throws Exception {
       // sync.safeExplicitWait(saveEditedUserButton, NOWAIT);
        safeClick(saveEditedUserButton);
        Reporter.log("Clicked on Save button after update", true);
        Thread.sleep(5000);
        assertElementDisplayed(saveEditedUserButton);
        logger.info("click on save button successfully");


    }

    /* =============================
     * Methods - Delete User
     * ============================= */

    public void enterUserNameFordelete(String username) throws Exception {
        sync.safeExplicitWait(searchByUsernameDel, NOWAIT);
        safeType(searchByUsernameDel, username);
        Reporter.log("Entered Username in search field", true);
        Thread.sleep(5000);
        logger.info("enter username successfully");

    }
    
    public void clickOnSearchButtonDel() throws Exception {
     //   sync.safeExplicitWait(searchButtonDel, NOWAIT);
        safeClick(searchButtonDel);
        Reporter.log("Clicked on Search button", true);
        Thread.sleep(5000);
        logger.info("click on search button successfully");

    }
    
    
    
    /**
     * Clicks Delete button for a user.
     */
    public void clickOnDeleteButton() throws Exception {
    //	sync.safeExplicitWait(deleteButton, NOWAIT);
    	 scrollUpDown(200);
    	safeClick(deleteButton);
    	Reporter.log("Clicked on Delete button", true);
        Thread.sleep(5000);
        logger.info("click on delete button successfully");

        
    }

    /**
     * Confirms delete action for a user.
     */
    public void confirmDeleteUser() throws Exception {
      //  sync.safeExplicitWait(confirmDeleteButton, NOWAIT);
        safeClick(confirmDeleteButton);
       // Reporter.log("Confirmed User Deletion", true);
        Thread.sleep(5000);
        logger.info("click on delete pop-up successfully");

    }
}

	
	
	

