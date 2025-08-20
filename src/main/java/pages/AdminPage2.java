package pages;

import common.Constant;
import common.SafeActions;
import org.testng.Reporter;

public class AdminPage2 extends SafeActions {
	
	


    // Locators for create user. 
     String addButton = "//button[normalize-space()='Add']";
     String userRoleDropdown = "(//div[contains(@class,'oxd-select-text--after')])[1]";
     String selectAdmin = "//div[@class='oxd-select-option']//span[text()='Admin']";
     String employeeNameField = "//input[@placeholder='Type for hints...']";
     String employeeNameOption = "(//div[@class='oxd-autocomplete-option'])[1]";
     String statusDropdown = "(//div[contains(@class,'oxd-select-text--after')])[2]";
     String selectStatus = "//span[text()='Enabled']";
     String usernameField = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[4]/div/div[2]/input";
     String passwordField = "(//input[@type='password'])[1]";
     String confirmPasswordField = "(//input[@type='password'])[2]";
     String saveButton = "//button[@type='submit']";
     
     
     //Locators for search functionality.
     String searchByUsername = "//div[@class='oxd-input-group__label-wrapper']//following::input[1]"; //top to bottom approach (following method)
     String clickOnsearchbutton = "//div[@class='oxd-form-actions']//parent::button[@class='oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space']"; //using parent method.     
     
     
     //Locators for read and update
     String clickOnEditButton = "//i[@class='oxd-icon bi-pencil-fill']";
     String enterUsernameField = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[4]/div/div[2]/input";
     String clickOnsaveButton = "//button[@type='submit']";
     
     
     //Locator for delete functionality
     String searchByUsernameDel = "//div[@class='oxd-input-group__label-wrapper']//following::input[1]"; 
     String clickOnSearchButtonDel = "//div[@class='oxd-form-actions']//parent::button[@class='oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space']";
     String clickOnDeleteButtonDel = "//button[@class='oxd-icon-button oxd-table-cell-action-space']//preceding::i[@class='oxd-icon bi-trash'][1]";
     String ClickOnCofirmButton = "//button[@type='button' and @class = 'oxd-button oxd-button--medium oxd-button--label-danger orangehrm-button-margin']";
     
     

 
    public void clickAddButton() throws Exception  {
    	safeExplicitWait(addButton,Constant.NORMALWAIT);
        safeClick(addButton);
		Reporter.log("Clicked on Add button", true);
		//return safeIsDisplay(addButton);
		

    }

	public void clickUserRoleDropdown() throws Exception  {
		safeExplicitWait(userRoleDropdown, Constant.NORMALWAIT);
        safeClick(userRoleDropdown);
		Reporter.log("Clicked on userrole tab", true);
		//return safeIsDisplay(userRoleDropdown);

    }
    private void safeExplicitWait(String userRoleDropdown2, int i) {
		
	}

	public void selectAdminOption() throws Exception  {
    	safeExplicitWait(selectAdmin, Constant.NORMALWAIT);
    	safeClick(selectAdmin);
    	Reporter.log("Clicked on selectAdminOption", true);
    	//return safeIsDisplay(selectAdmin);
    }

    public void typeEmployeeName(String name) throws Exception  {
    	safeExplicitWait(employeeNameField, Constant.NORMALWAIT);
        safeType(employeeNameField, name);
        safeClick(employeeNameOption);
        Reporter.log("Clicked on employee Name tab", true);
       // return safeIsDisplay(employeeNameField);

    
    }

    public void clickStatusDropdown() throws Exception  {
    	safeExplicitWait(employeeNameOption, Constant.NORMALWAIT);
        safeClick(statusDropdown);
        Reporter.log("Clicked on status from Dropdown tab", true);
       // return safeIsDisplay(statusDropdown);
    
    
    }
    
    public void selectEnablestatus() throws Exception{
    	safeExplicitWait(employeeNameOption, Constant.NORMALWAIT);
    	safeClick(selectStatus);
    	Reporter.log("Clicked on selectStatus dropdown", true);
       // return safeIsDisplay(selectStatus);
    	
    }

    public void typeUsername(String username) throws Exception {
    	safeExplicitWait(employeeNameOption, Constant.NORMALWAIT);
        safeType(usernameField, username);
        Reporter.log("Enter the name in username field", true);
       // return safeIsDisplay(usernameField);
    }

    public void typePassword(String password) throws Exception {
    	safeExplicitWait(employeeNameOption, Constant.NORMALWAIT);
        safeType(passwordField, password);
        Reporter.log("Enter password in password field ", true);
       // return safeIsDisplay(passwordField);
    }

    public void typeConfirmPassword(String confirmPassword) throws Exception {
    	safeExplicitWait(employeeNameOption, Constant.NORMALWAIT);
        safeType(confirmPasswordField, confirmPassword);
        Reporter.log("Enter the password in confirm password field ", true);
       // return safeIsDisplay(userRoleDropdown);
    }

    public void clickSaveButton() throws Exception {
    	safeExplicitWait(employeeNameOption, Constant.NORMALWAIT);
    	safeClick(saveButton); 
    	Reporter.log("Clicked on save button ", true);
        // return safeIsDisplay(saveButton);       
    }


//Methods for search user 

	public void enterUserNameInField(String username) throws Exception {
    	safeExplicitWait(employeeNameOption, Constant.NORMALWAIT);
		safeType(searchByUsername, username);
		Reporter.log("Enter the UserName tab", true);
		
	}

	public void clickOnSearchButton() throws Exception {
    	safeExplicitWait(employeeNameOption, Constant.NORMALWAIT);
		safeClick(clickOnsearchbutton);
		Reporter.log("Clicked on employee Name tab", true);
	}

	
//Update method 
	public void UpdateUserFunctionality() throws Exception {
    	safeExplicitWait(employeeNameOption, Constant.NORMALWAIT);
		safeClick(clickOnEditButton);
		Reporter.log("Clicked on employee Name tab", true);
	}
	
	public void enterUserName(String value) throws Exception{
    	safeExplicitWait(employeeNameOption, Constant.NORMALWAIT);
		safeType(enterUsernameField, value);
		Reporter.log("Clicked on employee Name tab", true);
	}
	
	public void clickOnSaveButtonR() throws Exception {
    	safeExplicitWait(employeeNameOption, Constant.NORMALWAIT);
		safeClick(clickOnsaveButton);
		Reporter.log("Clicked on employee Name tab", true);
	}
	
	
// Delete Method 
	public void searchUserFromUsername(String value)throws Exception {
    	safeExplicitWait(employeeNameOption, Constant.NORMALWAIT);
		safeType(searchByUsernameDel, value);
		Reporter.log("Clicked on employee Name tab", true);	
	}
	
	public void clkOnSearchButton() throws Exception {
    	safeExplicitWait(employeeNameOption, Constant.NORMALWAIT);
		safeClick(clickOnSearchButtonDel);
		Reporter.log("Clicked on employee Name tab", true);	
	
	}
	
	public void deleteButtonClick() throws Exception {
    	safeExplicitWait(employeeNameOption, Constant.NORMALWAIT);
		safeClick(clickOnDeleteButtonDel);
		Reporter.log("Clicked on employee Name tab", true);	

	}
	
	public void confirmDeleteUser() throws Exception {
    	safeExplicitWait(employeeNameOption, Constant.NORMALWAIT);
		safeClick(ClickOnCofirmButton);
		Reporter.log("Clicked on employee Name tab", true);
	}
	

}





