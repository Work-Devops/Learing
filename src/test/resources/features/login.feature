
@Regression

Feature: User login functionality

  Scenario: Valid login
    Given The user is on the login page
    When The user enters a valid username and password
    Then Click on Login button
  

