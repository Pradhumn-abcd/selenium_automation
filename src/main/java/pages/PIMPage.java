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
	
	
	

