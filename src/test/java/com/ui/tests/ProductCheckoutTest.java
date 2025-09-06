package com.ui.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.constants.Size.*;
import com.ui.pages.SearchResultPage;

public class ProductCheckoutTest extends TestBase {

	private static final String SEARCH_TERM = "Printed Summer dress";
	SearchResultPage searchResultPage;

	@BeforeMethod(description = "User logs into the application and searches for a product")
	public void setup() {
		searchResultPage = homePage.goToLoginPage().doLoginWith("dexep76529@evoxury.com", "password")
				.searchForAProduct(SEARCH_TERM);
	}

	@Test(description = "Verify if the logged in user is able to buy a dress ", groups = { "e2e", "sanity", "smoke" })
	public void checkOutTest() {
		String result = searchResultPage.clickOnTheProductAtIndex(0).changeSize(M).addProductToCart()
				.proceedToCheckout().goToConfirmAddressPage().goToShipmentPage().goToPayementPage().makePaymentByWire();
		System.out.println(result);

		Assert.assertTrue(result.contains("complete"));
	}
}