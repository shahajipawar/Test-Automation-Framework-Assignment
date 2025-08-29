package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utility.BrowserUtility;

public final class LoginPage extends BrowserUtility {
	private final static By EMAIL_TEXTBOX_LOCAOTR = By.id("email");
	private final static By PASSWORD_TEXTBOX_LOCAOTR = By.id("passwd");
	private final static By SUBMIT_BUTTON_LOCATOR = By.id("SubmitLogin");

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	public MyAccountPage doLoginWith(String emailAddress, String password) {
		enterText(EMAIL_TEXTBOX_LOCAOTR, emailAddress);
		enterText(PASSWORD_TEXTBOX_LOCAOTR, password);
		clickOn(SUBMIT_BUTTON_LOCATOR);
		MyAccountPage myAccountPage = new MyAccountPage(getDriver()); //New page object creation help in method chaining
		return myAccountPage;
	}
}