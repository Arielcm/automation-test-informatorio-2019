package io.github.jschenfeld.automation.tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import io.github.jschenfeld.automation.Page;
import io.github.jschenfeld.automation.selenium.WebDriverFactory;
import io.github.jschenfeld.automation.selenium.WebDriverFactory.Browser;

public class Base {
	
	@BeforeMethod
	@Parameters("browser")
	public void setUp(@Optional(value = "CHROME") String browser){
		WebDriver driver = WebDriverFactory.getDriver(Browser.valueOf(browser));
		Page.setDriver(driver);
	}
	
	@AfterMethod
	public void tearDown(){
		Page.closeBrowser();
	}
}