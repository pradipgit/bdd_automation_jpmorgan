package com.test.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GooglePage {

	WebDriver driver;

	public GooglePage(WebDriver driver) {
		this.driver = driver;
	}

	By GOOGLE_SEARCH_BOX = By.name("q");
	By GOOGLE_SEARCH_RESULT = By.xpath("//*[@id='rso']//h3/a");

	public WebElement getSearchBoxElement() {
		WebElement element = driver.findElement(GOOGLE_SEARCH_BOX);
		return element;

	}

	public List<WebElement> getAllSearchResults() {
		List<WebElement> findElements = driver.findElements(GOOGLE_SEARCH_RESULT);
		return findElements;
	}

}
