package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.constants.Browser;
import static com.constants.Env.*;
import com.utility.BrowserUtility;
import com.utility.JSONUtility;

import static com.utility.PropertiesUtil.*;

public final class HomePage extends BrowserUtility {
	
	public HomePage(Browser browser) {
		super(browser); //to call parent class constructor in child class, mark parent methods as abstract
		//goToWebsite(readProperty(QA, "URL"));	
		goToWebsite(JSONUtility.readJSON(QA));

	}


	// this is constant and wont change, so make it final and if final then should be static and private
	private static final By SIGN_IN_LINK_LOCATOR = By.xpath("//a[contains(text(),\"Sign in\")]"); 
	
	
	public LoginPage goToLoginPage() {  //void return type is never used in page functions
		clickOn(SIGN_IN_LINK_LOCATOR);
		LoginPage loginPage = new LoginPage(getDriver());
		return loginPage;
		
	}


}
