Feature: OrangeHRM Test Scenario
  I will test more multiple components on this feature file

  @login-Function
  Scenario Outline: Try login with Outline inputs
    Given I navigate to OrangeHRM live page
    And I verify the page
    And I enter username "<username>"
    And I enter password "<password>"
    And I click login button
    Then I validate and see the <status>Dashboard page

    Examples: 
      | username  | password  | status  |
      | Abc123456 | Abc123456 | Fail    |
      | Abc1B3b43 | Abc12GJ56 | Fail    |
      | Admin     | admin123  | success |
