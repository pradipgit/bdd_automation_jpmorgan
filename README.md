# Automation Behaviour driven development framework

To clone this repository use:  
git clone https://github.com/pradipgit/bdd_automation_jpmorgan.git

### Features
1.Useful for develop GUI automation   
2.Behaviour driven test automation using Cucumber/Gherkin language   
3.Maven based project  
4.JUnit is used  
5.Enabled report extending build in plugin  
6.Commandline execution 

### How to Run
mvn clean test -Dcucumber.options="src/test/java/com/test/features"  
or  
From Eclipse:   
Run as Unit test providing below details:  
Project : JPMorgan  
Test class: com.test.runner.RunnerTest  

### Examples:

### Runner
@RunWith(Cucumber.class)  
@CucumberOptions(features = "src/test/java/com/test/features", glue = "com.test.stepdefination",   
plugin = { "com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html" }, monochrome = true)  
public class RunnerTest {  
	@AfterClass  
	public static void writeExtentReport() {  
		Reporter.loadXMLConfig(new File("config/report.xml"));  
	}  
}  

### Feature File

#Author: pradip.blr28@gmail.com

@Logo
Feature: Verify J.P.Morgan Logo

  @Positive
  Scenario: Verify J P Morgan logo after searching via google
    Given I browse "https://google.com" website
    Then I search for "J.P.Morgan" key
    And I click on the first result link
    Then I verify "J.P. Morgan logo"


### Step defination 
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

### Report  
Navigate to target/cucumber-reports/reports.html  


