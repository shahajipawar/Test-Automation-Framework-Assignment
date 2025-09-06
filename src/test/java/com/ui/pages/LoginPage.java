package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utility.BrowserUtility;

public final class LoginPage extends BrowserUtility {
	private final static By EMAIL_TEXTBOX_LOCAOTR = By.id("email");
	private final static By PASSWORD_TEXTBOX_LOCAOTR = By.id("passwd");
	private final static By SUBMIT_BUTTON_LOCATOR = By.id("SubmitLogin");
	private final static By ERROR_MESSAGE_LOCATOR = By.xpath("//div[contains(@class, \"alert-danger\")]/ol/li");

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
	
	public LoginPage doLoginWithInvalidCredentials(String emailAddress, String password) {
		enterText(EMAIL_TEXTBOX_LOCAOTR, emailAddress);
		enterText(PASSWORD_TEXTBOX_LOCAOTR, password);
		clickOn(SUBMIT_BUTTON_LOCATOR);
		LoginPage loginPage = new LoginPage(getDriver());
		return loginPage;
	}
	
	public String getErrorMessage() {
		return getVisibleText(ERROR_MESSAGE_LOCATOR);
	}
}