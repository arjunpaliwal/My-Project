package com.ui.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static com.constants.Browser.*;
import com.ui.pages.HomePage;
import com.ui.pages.LoginPage;

public class LoginTest2 {
	
	public static void main(String[] args) {
		WebDriver wd =new ChromeDriver();
		
		HomePage homePage = new HomePage(CHROME, false);
		
		LoginPage loginPage=homePage.goToLoginPage();
		loginPage.doLoginWith("arjun@gmail.com", "Password");
		

	}

}
