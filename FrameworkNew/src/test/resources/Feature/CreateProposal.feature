Feature: Client Creation Validation

  Scenario: Login successfully
    Given User is on login page
    When user type username and password
    And user click on signin
    Then user should see welcome message and logout