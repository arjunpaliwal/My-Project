package com.ui.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.constants.Browser;
import static com.constants.Env.*;
import com.utility.BrowserUtility;
import com.utility.JSONUtility;
import com.utility.LoggerUtility;

import static com.utility.PropertiesUtil.*;

public final class HomePage extends BrowserUtility {
	Logger logger = LoggerUtility.getLogger(this.getClass());
	private static final By SIGN_IN_LINK_LOCATOR = By.xpath("//a[contains(text(),\"Sign in\")]"); 


	
	public HomePage(Browser browser, boolean isHeadless) {
		super(browser, isHeadless); //to call parent class constructor in child class, mark parent methods as abstract
		//goToWebsite(readProperty(QA, "URL"));	
		goToWebsite(JSONUtility.readJSON(QA).getUrl());

	}
	
	public HomePage(WebDriver driver) {
		super(driver);
		goToWebsite(JSONUtility.readJSON(QA).getUrl());//to call parent class constructor in child class, mark parent methods as abstract
	}


	// this is constant and wont change, so make it final and if final then should be static and private
	
	
	public LoginPage goToLoginPage() {  //void return type is never used in page functions
		logger.info("Clicking on Sign In link");
		clickOn(SIGN_IN_LINK_LOCATOR);
		LoginPage loginPage = new LoginPage(getDriver());
		return loginPage;
		
	}

	public void quit() {
		// TODO Auto-generated method stub
		
	}



}
