package com.ui.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ui.pages.MyAccountPage;
import com.ui.pojo.AddressPOJO;
import com.utility.FakerAddressUtility;

public class AddNewFirstAddressTest extends TestBase {

	private MyAccountPage myAccountPage;
	private AddressPOJO address;

	@BeforeMethod(description = "Valid First time user logs into the application")
	public void setup() {
		myAccountPage = homePage.goToLoginPage().doLoginWith("dexep76529@evoxury.com", "password");
		address = FakerAddressUtility.getFakeAddress();
	}

	@Test
	public void addNewAddress() {
		String newAddress = myAccountPage.goToAddressPage().saveAddress(address);
		Assert.assertEquals(newAddress, address.getAddressAlias().toUpperCase());
	}
}