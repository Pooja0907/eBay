package com.ebay.test.utils;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ebay.test.base.TestBase;

public class Testutilities extends TestBase {
	
	// method to select the product size from drop down option which is in stock.
	public static void dropdownSelection(WebElement element) {
		Select select = new Select(element);
		List<WebElement> allOptions = select.getOptions();
		for (int i = 0; i < allOptions.size(); i++) {
			if (!(allOptions.get(i).getText().contains("out of stock"))
					&& !(allOptions.get(i).getText().contains("-Select-"))) {
				select.selectByIndex(i);
				break;
			}
		}

	}

}
