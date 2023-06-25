package com.orangehrm.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class PIMPage {
WebDriver driver;
	
	
	public void verifyAPageByTitle(String title) {
		Assert.assertEquals(driver.getTitle(), title);
	}
	
	public void verifyAPageByWebElement(WebElement ele, String text) {
		Assert.assertEquals(ele.getText(), text);
	}
	
	@FindBy(xpath = "//div[contains(@class,'oxd-grid-item oxd-grid-item--gutters')][1]")
	WebElement textBox_EmployeeName;
	
	@FindBy(xpath = "//div[contains(@class,'oxd-grid-item oxd-grid-item--gutters')][2]")
	WebElement textBox_EmployeeID;
	
	@FindBy(xpath = "//div[contains(@class,'oxd-grid-item oxd-grid-item--gutters')][3]")
	WebElement dropDown_EmployeeStatus;
	
	@FindBy(xpath = "//div[contains(@class,'oxd-grid-item oxd-grid-item--gutters')][4]")
	WebElement dropDown_Include;
	
	@FindBy(xpath = "//div[contains(@class,'oxd-grid-item oxd-grid-item--gutters')][5]")
	WebElement textBox_SupervisorName;
	
	@FindBy(xpath ="//div[contains(@class,'oxd-grid-item oxd-grid-item--gutters')][6]")
	WebElement dropDown_JobTitle;
	
	@FindBy(xpath ="//div[contains(@class,'oxd-grid-item oxd-grid-item--gutters')][7]")
	WebElement dropDown_SubUnit;
	
	@FindBy(xpath ="//li[contains(@class,'tab --parent')]")
	WebElement list_Configuration;
	
	@FindBy(xpath = "//a[contains(text(),'Employee List')]")
	WebElement link_EmployeeList;
	
	@FindBy(xpath = "//a[contains(text(),'Add Employee')]")
	WebElement link_AddEmployee;
	
	@FindBy(xpath = "//a[contains(text(),'Reports')]")
	WebElement link_Reports ;
	
	@FindBy(xpath = "//button[@title='Help']")
	WebElement button_Help;
	
	@FindBy(xpath = "//button[@type='reset']")
	WebElement button_Reset;
	
	@FindBy(xpath = "//button[@type='submit']")
	WebElement button_Search;
	
	@FindBy(xpath = "//button[contains(@class,'button--secondary')][2]")//not working
	WebElement button_Add;
	
	@FindBy()
	WebElement ;
	@FindBy()
	WebElement ;
	@FindBy()
	WebElement ;
	@FindBy()
	WebElement ;
}
