package com.qa.hotspot.page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.hubspot.base.BasePage;
import com.qa.hotspot.util.AppConstants;
import com.qa.hotspot.util.ElementUtil;
public class HomePage {
	WebDriver driver;
	ElementUtil elementUtil;
	
	By header = By.cssSelector("h1.dashboard-selector__title");
	By accountName = By.cssSelector("span.account-name ");
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
	}
	
	public String getHomePageTitle() {
		elementUtil.waitForTitlePresent(AppConstants.HOME_PAGE_TITLE);
		return elementUtil.doGetPageTitle();
	}
	
	public String getHomePageHeader() {
		return elementUtil.doGetText(header);
	}
	
	public String getLoggedInUserAccount() {
		return elementUtil.doGetText(accountName);
	}
	
}
