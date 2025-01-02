Feature: Client Creation Validation

  Background:
  Given user has already logged in to application

   Scenario: Create Allocation
    Given User is on dashboard page
    When Click on asset allocation top menu
    Then Verify allocation table header
    And Verify No allocation Available message
   
   Scenario: Create Asset
    Given User is on Asset Allocation page
    When Click on Add-Allocation Case Icon In Allocation-Cases Page
    And Click on All Allocation-Cases burger menu icon to navigate to View all AllocationCaes
    And Click on Add-Allocation Case Icon In Allocation-Cases Page
    Then Click on down-arrow icon beside too title to Assumption cases
    And Verify Allocation Case Visible in the list
    And Logout User from the Application