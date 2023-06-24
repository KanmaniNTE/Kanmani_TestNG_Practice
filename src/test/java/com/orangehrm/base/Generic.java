package com.orangehrm.base;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Generic {
	
	WebDriver driver;
	WebDriverWait wait;
	
	
//	************** WebDriver methods ********************************
	
	
//	************** WebElement methods ********************************
	
	
//	************** Robot Class methods ********************************
	
	
//	************** Actions Class methods ********************************
	
	
//	************** Alert methods ********************************
	
//	************** Frames methods ********************************
	
//	************** WindowHandling methods ********************************
	
//	************** Scrolling methods ********************************
	
//	************** DropDown methods ********************************
	
//	**************  methods ********************************
	
	
	
//	************** Wait methods ********************************
	public void maximizeAWindow() {
		driver.manage().window().maximize();
	}

	public void waitForAlertToBePresent(long seconds) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
		wait.until(ExpectedConditions.alertIsPresent());
	}

	public void waitForElementToBeClickableByLocator(String locatorName, String classText, long seconds) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));

		switch (locatorName) {
		case "id":
			wait.until(ExpectedConditions.elementToBeClickable(By.id(classText)));
			break;
		case "className":
			wait.until(ExpectedConditions.elementToBeClickable(By.className(classText)));
			break;

		case "name":
			wait.until(ExpectedConditions.elementToBeClickable(By.name(classText)));
			break;

		case "tagName":
			wait.until(ExpectedConditions.elementToBeClickable(By.tagName(classText)));
			break;

		case "css selector":
			wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(classText)));
			break;

		case "xpath":
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(classText)));
			break;

		}
	}
	
	public void waitForElementToBeClickable(WebElement ele, long seconds) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
		wait.until(ExpectedConditions.elementToBeClickable(ele));
	}
	
	public void waitForElementToBeVisible(WebElement ele, long seconds) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
		wait.until(ExpectedConditions.visibilityOf(ele));
	}


}
