package com.ui.tests;

import static com.constants.Browser.CHROME;
import static org.testng.Assert.assertEquals;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ui.pages.HomePage;
import com.ui.pojos.User;

public class LoginTest {
	HomePage homePage;

	@BeforeMethod(description = "Load homepage of Website")
	public void setUp() {
		homePage = new HomePage(CHROME);
	}

	@Test(description = "Verifies with valid user able to login into app", groups = { "e2e",
			"sanity" }, dataProviderClass = com.ui.dataproviders.LoginDataProvider.class, dataProvider = "LoginTestDataProvider")
	public void loginTest(User user) {

		assertEquals(homePage.goToLoginPage().doLoginWith(user.getEmailAddress(), user.getPassword()).getUserName(),
				"Arjun Paliwal");

	}

}
