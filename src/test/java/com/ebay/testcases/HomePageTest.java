package com.ebay.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.ebay.test.Pages.CartPage;
import com.ebay.test.Pages.HomePage;
import com.ebay.test.Pages.ProductDetailsPage;
import com.ebay.test.base.TestBase;
import com.ebay.test.utils.Testutilities;

public class HomePageTest extends TestBase {

	HomePage homePage;
	ProductDetailsPage productDetailsPage;
	Testutilities testutilities;
	CartPage cartPage;

	public HomePageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		homePage = new HomePage();
		productDetailsPage = new ProductDetailsPage();
		testutilities = new Testutilities();
		cartPage = new CartPage();
	}

	@Test
	public void addBikeToCart() {
		SoftAssert softAssert = new SoftAssert();
		homePage.enterInputToSearch(prop.getProperty("productName"));
		homePage.clickOnSubmitBtn(); // It will search bikes.
		String text = homePage.getSearchResult().getText();
		softAssert.assertEquals(text, "Bike Type", "Search failed");
		try {
			Thread.sleep(2000);
		} catch (Exception e) {
			e.getStackTrace();
		}
		if (homePage.returnSearchedProducts().size() == 0) {
			System.out.println("No results for the searched item " + text);
		} else {
			String bikeName = homePage.returnSearchedProducts().get(0).getText();
			homePage.returnSearchedProducts().get(0).click(); // It will select first bike.
			Testutilities.dropdownSelection(productDetailsPage.selectionOfSize());
			productDetailsPage.clickOnAddToCart(); // It will add item to the cart.
			softAssert.assertEquals(cartPage.getAddedProduct().isDisplayed(), true);// verify if added item displayed in
																					// the cart
			softAssert.assertEquals(bikeName.toString(), cartPage.getProductText(), "Product name not matched");
			softAssert.assertAll();
		}
	}

	@AfterMethod
	public void closeBrowser() {
		driver.close();
	}

}
