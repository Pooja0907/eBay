package com.ebay.test.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ebay.test.base.TestBase;

public class CartPage extends TestBase{
	
	@FindBy(xpath="//span[contains(text(),'MONVELO Mountain Bike 26〞/27.5〞/29〞21 Speed Bicycl')]")
	private WebElement addedProduct;
	
	public CartPage() {
		PageFactory.initElements(driver,this);
	}
	
	public String getProductText() {
		String productName= addedProduct.getText();
		return productName;
	}
	
	public WebElement getAddedProduct() {
		return addedProduct;
	}
}
