// for ec account 
@Regression
Feature: Pre-Equal Loan Application with valid Data

  Scenario: Apply for Pre-Equal Loan with valid data
    Given The user is on the home page
    When The user clicks on "Start Application"
    And The user selects "Pre-Equal Application"
    And The user enters borrower details "Margaret" "Grayson" "666199131" "03/1/1974" "52 sweetgum ct" "Lake Jackson" "TX" "77566"
    And The user enters co-borrower details "Pattie" "Graves" "666171366" "12/26/1947" "75 Lyerly st" "Houston" "TX" "77022"
    Then The user submits the application successfully

  Scenario: Apply for Pre-Equal Loan with blank data
    Given The user is on the home page
    When The user clicks on "Start Application"
    And The user selects "Pre-Equal Application"
    And The user leaves all the form fields blank
    Then The user should see validation errors for all required fields

  Scenario: Apply for Pre-Equal Loan with invalid data
    Given The user is on the home page
    When The user clicks on "Start Application"
    And The user selects "Pre-Equal Application"
    And The user enters invalid data in the form (e.g., invalid email or phone number , Address)
    Then The loan should be declined
