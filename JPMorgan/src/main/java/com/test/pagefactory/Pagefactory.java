package com.test.pagefactory;

import org.openqa.selenium.WebDriver;

import com.test.pages.GooglePage;
import com.test.pages.JPMorganPage;

public class Pagefactory {

	public WebDriver driver;
	public GooglePage gp;
	public JPMorganPage jp;

	public Pagefactory(WebDriver driver) {
		this.driver = driver;
		setup();
	}

	public void setup() {
		gp = new GooglePage(driver);
		jp = new JPMorganPage(driver);
	}

}
