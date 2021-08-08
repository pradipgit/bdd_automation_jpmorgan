package com.test.stepdefination;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.test.pagefactory.Pagefactory;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class JPMorgan_Steps {

	public WebDriver driver;
	public Pagefactory factory;

	@Before
	public void setup() {
		try {
			
			String rootDir = System.getProperty("user.dir");
			System.setProperty("webdriver.gecko.driver",
					rootDir + "\\src\\test\\resources\\com\\test\\drivers\\geckodriver.exe");
			driver = new FirefoxDriver();
			factory = new Pagefactory(driver);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		} catch (Exception e) {
			System.out.println("Error occured during Initializing Browser: " + e);
		}
	}

	@After
	public void teardown() {
		try {
			driver.quit();
		} catch (Exception e) {
			System.out.println("Error occured during quit: " + e);
		}
	}

	@Given("^I browse \"(.*)\" website$")
	public void browseGoogle(String url) {
		try {
			driver.get(url);
		} catch (Exception e) {
			System.out.println("Error occured during opening url: " + e);
		}

	}

	@When("^I search for \"(.*)\" key$")
	public void searchJPMorgan(String str) {
		try {
			WebElement element = factory.gp.getSearchBoxElement();
			element.sendKeys(str);
			element.submit();
			driver.manage().window().maximize();

		} catch (Exception e) {
			System.out.println("Error occured during opening browser: " + e);
		}

	}

	@And("^I click on the first result link$")
	public void clickFirstResult() {
		try {

			List<WebElement> findElements = factory.gp.getAllSearchResults();

			for (WebElement webElement : findElements) {
				String link = webElement.getAttribute("href");
				if (link.contains("https://www.jpmorgan.com")) {
					webElement.click();
					break;
				}
			}

		} catch (Exception e) {
			System.out.println("Not able to identify first result: " + e);
		}
	}

	@Then("^I verify \"(.*)\"$")
	public void verifyLogo(String logo) {

		String logoName = factory.jp.getLogoName();
		Assert.assertEquals(logo, logoName);

	}

}
