package com.orangehrm.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.testng.Assert;

public class CommonPage {
	WebDriver driver;
	
	
	@FindBy(xpath = "//div[contains(@class,'header-title')]")
//	WebElement header_Title;
	WebElement text_DashBoardTitle;
	
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
	
	@FindBys(@FindBy(xpath="//ul[@class = 'oxd-main-menu']/li//span"))
	List<WebElement> link_orangehrmAllPages;
	
//	@FindBy()
//	WebElement ;
//	@FindBy()
//	WebElement ;
	
	public void verifyAPageByTitle(String title) {
		Assert.assertEquals(driver.getTitle(), title);
	}
	
	public void verifyAPageByWebElement(WebElement ele, String text) {
		Assert.assertEquals(ele.getText(), text);
	}
	
	public void goToGivenPageInOrangehrm(String pageName) {
//		List<WebElement> pageLinks = driver.findElements(By.xpath("//ul[@class = 'oxd-main-menu']/li//span"));
		
		for(WebElement eachPageLink: link_orangehrmAllPages) {
			if(eachPageLink.getText().equalsIgnoreCase(pageName)) {
				eachPageLink.click();
			}
		}
	}
	
	

}
