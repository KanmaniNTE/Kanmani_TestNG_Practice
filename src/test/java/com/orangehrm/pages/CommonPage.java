package com.orangehrm.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class CommonPage {
	WebDriver driver;
	
	
	public void verifyAPageByTitle(String title) {
		Assert.assertEquals(driver.getTitle(), title);
	}
	
	public void verifyAPageByWebElement(WebElement ele, String text) {
		Assert.assertEquals(ele.getText(), text);
	}
	
	@FindBy(xpath = "//div[contains(@class,'header-title')]")
	WebElement header_Title;
	
	@FindBy(xpath = "//div[contains(@class,'search')]")
	WebElement textBox_Search;
	
	@FindBy(xpath = "//a[contains(@href,'admin')]")
	WebElement link_Admin;
	
	@FindBy(xpath = "//a[contains(@href,'viewPimModule')]")
	WebElement link_PIM ;
	
	@FindBy(xpath = "//a[contains(@href,'leave')]")
	WebElement link_Leave;
	
	@FindBy(xpath = "//a[contains(@href,'Time')]")
	WebElement link_Time;
	
	@FindBy(xpath = "//a[contains(@href,'Recruitment')]")
	WebElement link_Recruitment;
	
	@FindBy(xpath = "//a[contains(@href,'viewMyDetails')]")
	WebElement link_MyInfo;
	
	@FindBy(xpath = "//a[contains(@href,'Performance')]")
	WebElement link_Performance ;
	
	@FindBy(xpath = "//a[contains(@href,'dashboard')]")
	WebElement link_Dashboard;
	
	@FindBy(xpath = "//a[contains(@href,'directory')]")
	WebElement link_Directory;
	
	@FindBy(xpath = "//a[contains(@href,'maintenance')]")
	WebElement link_Maintenance;
	
	@FindBy(xpath = "//a[contains(@href,'buzz')]")
	WebElement link_Buzz;
	
//	@FindBy()
//	WebElement ;
//	@FindBy()
//	WebElement ;

}
