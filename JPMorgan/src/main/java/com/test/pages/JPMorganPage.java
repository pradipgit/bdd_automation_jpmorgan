package com.test.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JPMorganPage {

	WebDriver driver;

	public JPMorganPage(WebDriver driver) {
		this.driver = driver;
	}

	By JPMORGAN_LOGO = By.xpath("(//img[@alt='J.P. Morgan logo'])[2]");

	public String getLogoName() {
		WebElement element = driver.findElement(JPMORGAN_LOGO);
		String logoName = element.getAttribute("alt");
		return logoName;
	}

}
