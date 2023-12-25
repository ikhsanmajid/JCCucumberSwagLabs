Feature: User Login
  Scenario Outline: User Login with invalid username or password
    Given User enter URL web SwagLabs
    When User enter invalid <username> or <password>
    And User click login button
    Then Show login error message

    Examples:
      | username | password |
      | "standard_user" | "secret_sauce123" |
      | "standard_user123" | "secret_sauce" |

  Scenario Outline: User Login with empty password or username
    Given User enter URL web SwagLabs
    When User enter empty <username> or <password>
    And User click login button
    Then Show login error message

    Examples:
      | username | password |
      | "standard_user" | "" |
      | "" | "secret_sauce" |
      | "" | "" |
    
  Scenario: User Login Valid
    Given User enter URL web SwagLabs
    When User enter username
    And User enter password
    And User click login button
    Then User login successful redirect to page home