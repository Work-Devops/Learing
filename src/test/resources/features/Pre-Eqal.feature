Feature: User login and application process

  Scenario: User logs in and applies for a Pre-Equal Loan
    Given The user is on the login page
    When The user enters a valid username and password
    And Click on Login button
    Then The user should redirect to home page
    When The user clicks on "Start Application"
    And The user selects "Pre-Equal Application"
    And The user enters valid borrower details
    And The user enters valid co-borrower details
    Then The user submits the application successfully
    Then user added the loan Application
    Then check it is working or not
