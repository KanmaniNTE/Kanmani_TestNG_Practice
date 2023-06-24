package com.orangehrm.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.orangehrm.base.Generic;

public class LoginPage extends Generic {
	
	WebDriver driver;
	CommonPage commonPage = new CommonPage();
	
	@FindBy(tagName = "h5") 
	WebElement text_LoginHeader;
	
	@FindBy(name = "username")
	WebElement textBox_UserName;
	
	@FindBy(name = "password")
	WebElement textBox_Password;
	
	@FindBy(xpath = "//button[contains(@class,'orangehrm-login-button')]")
	WebElement button_Login;
	
	@FindBy(xpath = "//p[text() = 'Forgot your password? ']")
	WebElement link_forgotYourPassword;
	
	@FindBy(xpath = "//a[contains(@href,'linkedin')]")
	WebElement link_LinkedIn;
	
	@FindBy(xpath = "//a[contains(@href,'facebook')]")
	WebElement link_Facebook;
	
	@FindBy(xpath = "//a[contains(@href,'twitter')]")
	WebElement link_Twitter;
	
	@FindBy(xpath = "//a[contains(@href,'youtube')]")
	WebElement link_YouTube;
	
//	@FindAll(xpath = "//div[@class = 'orangehrm-login-footer-sm']//a")
//	WebElement link_SocialMedia;
	
	@FindBy(name = "username")
	WebElement textBox_ForgotPassword_UserName;
	
	@FindBy(tagName = "h6")
	WebElement text_ResetPasswordHeader;
	
	@FindBy(xpath = "//button[text() = ' Cancel ']")
	WebElement button_Cancel;
	
	@FindBy(xpath = "//button[text() = ' Reset Password ']")
	WebElement button_resetPassword;
	
	@FindBy(tagName = "h6")
	WebElement text_ResetPasswordLinkSent;
	
//	@FindBy()
//	WebElement ;
	
	
	public void loginOrangeHRM(String userName, String password) {
		textBox_UserName.sendKeys(userName);
		textBox_Password.sendKeys(password);
		button_Login.click();
	}
	
	public void forgotPassword(String userName) {
		link_forgotYourPassword.click();
		waitForElementToBeVisible(text_ResetPasswordHeader, 5);
		textBox_ForgotPassword_UserName.sendKeys(userName);
		button_resetPassword.click();
		commonPage.verifyAPageByWebElement(text_ResetPasswordLinkSent, "Reset Password link sent successfully");
	}
	

}
