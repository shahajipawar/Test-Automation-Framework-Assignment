package com.ui.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.ui.pages.HomePage;
import com.ui.pages.LoginPage;

public class LoginTest2 {

	public static void main(String[] args) {
		WebDriver wd = new ChromeDriver(); // Launch the browser window
		HomePage homePage = new HomePage(wd);
		LoginPage loginpage = homePage.goToLoginPage();
		loginpage.doLoginWith("dexep76529@evoxury.com", "password");
	}

}
