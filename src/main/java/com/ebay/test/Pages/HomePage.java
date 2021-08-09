package com.ebay.test.Pages;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ebay.test.base.TestBase;

public class HomePage extends TestBase {

	@FindBy(id = "gh-ac")
	private WebElement searchBar;

	@FindBy(id = "gh-btn")
	private WebElement submitBtn;

	@FindBy(xpath = "//h3[contains(@class, 'srp-carousel-list__item-group-title') and text() = 'Bike Type']")
	private WebElement bikeSearchValidation;

	private List<WebElement> productsList;

	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	public void enterInputToSearch(String input) {
		searchBar.sendKeys(input);
	}

	public void clickOnSubmitBtn() {
		submitBtn.click();
	}

	public WebElement getSearchResult() {
		return bikeSearchValidation;

	}

	public List<WebElement> returnSearchedProducts() {
		this.productsList = driver
				.findElements(By.xpath("//div[@id='mainContent']//li[contains(@data-view,'iid:')]//a//h3"));
		return productsList;
	}
}


