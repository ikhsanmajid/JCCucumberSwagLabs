Feature: User Logout
  Scenario: User Logout from Session
    Given User enter URL web SwagLabs
    When User enter username
    And User enter password
    And User click login button
    Then User login successful redirect to page home
    When User click hamburger button
    And User click logout button
    Then User back to login page