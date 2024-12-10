@SmokeTest
Feature: Log In Validation

@smoketest
  Scenario: User should be able to launch home page
    Given User is in Log in Page
    When User put valid id and password
    And User click on log in button
    Then User should be on Home Page