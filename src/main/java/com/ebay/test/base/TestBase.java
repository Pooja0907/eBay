package com.ebay.test.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestBase {

	public static WebDriver driver;
	public static Properties prop;

	public TestBase() {
		prop = new Properties();
		try {
			FileInputStream fileinput = new FileInputStream(
				"src\\main\\java\\com\\ebay\\test\\config\\config.properties");

			prop.load(fileinput);
		} catch (IOException e) {

			e.printStackTrace();
		}

	}

	public void initialization() {
		System.setProperty("webdriver.chrome.driver", "resources\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();

	}

}
