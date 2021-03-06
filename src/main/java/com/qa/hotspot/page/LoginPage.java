package com.qa.hotspot.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.hotspot.util.AppConstants;
import com.qa.hotspot.util.Credentials;
import com.qa.hotspot.util.ElementUtil;
import com.qa.hubspot.base.BasePage;

public class LoginPage extends BasePage{
	
	WebDriver driver;
	ElementUtil elementUtil;
	
	//1. locators
	By emailId = By.id("username");
	By password = By.id("password");
	By loginButton = By.id("loginBtn");
	By signUpLink = By.linkText("Sign up");
	By loginErrorText = By.cssSelector("div.private-alert__inner");
	
	//Constructor
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
	}
	
	//Page actions
	public String getPageTitle() {
		elementUtil.waitForTitlePresent(AppConstants.LOGIN_HOME_PAGE_TITLE);
		return elementUtil.doGetPageTitle();
	}
	
	public boolean checkSignUpLink() {
		//elementUtil.waitForElementVisible(signUpLink);
		return elementUtil.doIsDisplayed(signUpLink);
	}
	
	public HomePage doLogin(Credentials userCred) {
		//elementUtil.waitForElementPresent(emailId);
		elementUtil.doSendKeys(emailId, userCred.getAppUsername());
		//elementUtil.waitForElementPresent(password);
		elementUtil.doSendKeys(password, userCred.getAppPassword());
		//elementUtil.waitForElementPresent(loginButton);
		elementUtil.doClick(loginButton);
		
//		driver.findElement(emailId).sendKeys(username);
//		driver.findElement(password).sendKeys(pwd);
//		driver.findElement(loginButton).click();
		
		return new HomePage(driver);
	}
	
	public boolean checkLoginErrorMessage() {
		return elementUtil.doIsDisplayed(loginErrorText);
	}
	
	
	
	

}
