package com.ebay.test.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ebay.test.base.TestBase;

public class ProductDetailsPage extends TestBase {

	@FindBy(id = "itemTitle")
	private WebElement productTitle;

	@FindBy(id = "msku-sel-1")
	private WebElement selectSize;

	@FindBy(id = "isCartBtn_btn")
	private WebElement addToCartBtn;

	@FindBy(xpath = "//button[contains(text(),'No thanks')]")
	private WebElement noThanks;

	public ProductDetailsPage() {
		PageFactory.initElements(driver, this);
	}

	public WebElement selectionOfSize() {
		return selectSize;
	}

	public String productTitle() {
		String productTitleOnProductPage = productTitle.getText();
		return productTitleOnProductPage;
	}

	public CartPage clickOnAddToCart() {
		addToCartBtn.click();
		noThanks.click();
		return new CartPage();

	}

}
