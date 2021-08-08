#Author: pradip.blr28@gmail.com

@tag
Feature: Verify J.P.Morgan Logo

  @label
  Scenario: Verify J P Morgan logo after searching via google
    Given I browse "https://google.com" website
    Then I search for "J.P.Morgan" key
    And I click on the first result link
    Then I verify "J.P. Morgan logo"
         
 