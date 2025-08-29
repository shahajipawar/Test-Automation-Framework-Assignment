package com.ui.pages;

import static com.constants.Env.QA;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.constants.Browser;
import com.utility.BrowserUtility;
import com.utility.JSONUtility;
import com.utility.LoggerUtility;

public final class HomePage extends BrowserUtility { // Inheritance, child class marked with final keyword

	Logger logger = LoggerUtility.getLogger(this.getClass());

	// page object pattern -
	// Locators & methods to perform operation on them are kept in same class
	private final static By SIGN_IN_LINK_LOCATOR = By.xpath("//a[contains(text(), \"Sign in\")]");
	// constants are marked with final and in upper class text, Final as there value
	// will not be changed
	// Class variables = static variables

	public HomePage(Browser browserName, boolean isHeadless) {
		super(browserName, isHeadless); // To call parent class constructor from child class constructor
		// goToWebsite(PropertiesUtils.readProperties(QA, "URL"));
		goToWebsite(JSONUtility.readJSON(QA).getUrl());

	}

	public HomePage(WebDriver driver) {
		super(driver);
		goToWebsite(JSONUtility.readJSON(QA).getUrl());
	}

	public LoginPage goToLoginPage() {// Page functions--Cannot use void return type
		logger.info("Trying to perfrom click to go to Sign in page");
		clickOn(SIGN_IN_LINK_LOCATOR);
		LoginPage loginPage = new LoginPage(getDriver());// pass driver object instance from one page to another
		return loginPage;
	}	
}
