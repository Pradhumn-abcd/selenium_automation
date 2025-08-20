package tests;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.Test;

import common.BaseSetup;
import pages.AdminPage2;
import pages.LeftPanelPage;
import pages.PIMPage;

public class PIMTest extends BaseSetup {

	@Test
	public void createAdminUser() throws Exception {
	    LeftPanelPage leftPanelPage = new LeftPanelPage();
	    leftPanelPage.pimTabClick();
	    PIMPage  pimTabTest = new PIMPage ();
	   
	    pimTabTest.clickOnAddButton();
	    pimTabTest.enterUserNameField("1231213");
	    pimTabTest.enterLastNameField("enterLastNameField");
	    pimTabTest.clickOnPlusForUpload();
	    pimTabTest.fileUpload("C:\\Users\\USER\\Downloads\\fuji-mountain.jpg");
	    pimTabTest.clickOnSaveButtonforCreateUser();
	    pimTabTest.enterExpiryDatefield("1990-12-31");
//	    pimTabTest.clickOnNationalityDDField();
//	    pimTabTest.selectNationalityFromDropdown();
	    pimTabTest.clickOnMaritalStatusDD();
	    pimTabTest.selectMaritalFromDropdown();
	    pimTabTest.clickOnFirstSaveButton1();
	    pimTabTest.clickOncontactDetails();
	    pimTabTest.selectCountryFromDD();
	    pimTabTest.clickOnSaveButton();
	    pimTabTest.clickOnPIMTabRef();
	    pimTabTest.enterEmploUsername("123");
	    pimTabTest.clickSearchButton();
	    pimTabTest.clickOnResultFirst();
	    pimTabTest.updateEmployeeName("123123123");
	    pimTabTest.saveUpdatedEmployee();
	    
	    
	    
	}

	
		
	}
	