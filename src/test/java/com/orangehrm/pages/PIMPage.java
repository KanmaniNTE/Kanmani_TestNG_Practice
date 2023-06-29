package com.orangehrm.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.orangehrm.base.Generic;

public class PIMPage {
	WebDriver driver;
	Generic generic = new Generic();
	public PIMPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	

	@FindBy(xpath = "//li[contains(@class,'tab --parent')]")
	WebElement list_Configuration;

	@FindBys(@FindBy(xpath = "//ul[@class = 'oxd-dropdown-menu']//li"))
	List<WebElement> link_ConfigurationSubMenu;

	@FindBy(xpath = "//a[text() = 'Optional Fields']")
	WebElement link_Configuration_OptionalFields;

	@FindBy(xpath = "//a[contains(text(),'Employee List')]")
	WebElement link_EmployeeList;

	@FindBy(xpath = "//a[contains(text(),'Add Employee')]")
	WebElement link_AddEmployee;

	@FindBy(xpath = "//a[contains(text(),'Reports')]")
	WebElement link_Reports;

	@FindBy(xpath = "//button[@title='Help']")
	WebElement link_Help;

//	@FindBy(xpath = "//div[contains(@class,'oxd-grid-item oxd-grid-item--gutters')][1]")
	@FindBy(xpath = "//label[text() = 'Employee Name']//following::div//input")
	WebElement textBox_EmployeeName;

	@FindBy(xpath = "//div[contains(@class,'oxd-grid-item oxd-grid-item--gutters')][2]")
	WebElement textBox_EmployeeID;

	@FindBy(xpath = "//div[contains(@class,'oxd-grid-item oxd-grid-item--gutters')][3]")
	WebElement dropDown_EmployeeStatus;

	@FindBy(xpath = "//div[contains(@class,'oxd-grid-item oxd-grid-item--gutters')][4]")
	WebElement dropDown_Include;

	@FindBy(xpath = "//div[contains(@class,'oxd-grid-item oxd-grid-item--gutters')][5]")
	WebElement textBox_SupervisorName;

	@FindBy(xpath = "//div[contains(@class,'oxd-grid-item oxd-grid-item--gutters')][6]")
	WebElement dropDown_JobTitle;

	@FindBy(xpath = "//div[contains(@class,'oxd-grid-item oxd-grid-item--gutters')][7]")
	WebElement dropDown_SubUnit;

	@FindBy(xpath = "//button[@type='reset']")
	WebElement button_Reset;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement button_Search;

	@FindBy(xpath = "//button[text() = ' Add ']")
	WebElement button_Add;

	@FindBy(xpath = "//div[@class = 'orangehrm-horizontal-padding orangehrm-vertical-padding']//span")
	WebElement text_NoOfRecords;

	@FindBys(@FindBy(xpath = "//div[@class ='oxd-table-body']/div"))
	List<WebElement> text_NoOfRows;

//	int i;
//	@FindBy(xpath = "//div[@class ='oxd-table-body']/div["+i+"]//i[contains(@class,'trash')]")
//	WebElement

//	@FindBy()
//	WebElement ;
//	@FindBy()
//	WebElement ;
//	@FindBy()
//	WebElement ;
//	@FindBy()
//	WebElement ;

	public void deleteGivenRowInEmployeeList(int row) {
		int noOfRows = text_NoOfRows.size();
		for (int i = 1; i <= noOfRows; i++) {
			if (i == row) {
				generic.clickElementUsingDynamicXpath(
						"//div[@class ='oxd-table-body']/div[" + i + "]//i[contains(@class,'trash')]");
				break;
			}
		}
//		write code for Yes delete
		driver.findElement(By.xpath("//div[@class='orangehrm-modal-footer']//following::i")).click();
	}

//	selectGivenRow
//	selectGivenRowAndDelete
//	EditGivenRow

	public void sortGivenColumn(String columnName, String sortType) throws InterruptedException {
		List<WebElement> employeeListHeader = driver
				.findElements(By.xpath("//div[@class = 'oxd-table-header']//div[contains(@class, 'header-cell')]"));
		for (WebElement eachHeader : employeeListHeader) {
			if (!eachHeader.getText().isEmpty() && eachHeader.getText().equalsIgnoreCase("Last Name")) {
				eachHeader.findElement(By.xpath(".//div/i")).click();
				;
				Thread.sleep(2000);
				List<WebElement> ascendingOrDecending = driver.findElements(By.xpath(
						"//div[@class = 'oxd-table-header']//div[contains(@class, 'header-cell')]//div//ul//span"));
				for (WebElement each : ascendingOrDecending) {
					if (each.getText().equalsIgnoreCase("ascending")) {
						each.click();
						Thread.sleep(2000);
						break;
					}
				}
				break;
			}
		}
	}

}
