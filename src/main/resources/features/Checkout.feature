Feature: User Checkout
  Scenario: User add items to cart
    Given User enter URL web SwagLabs
    When User enter username
    And User enter password
    And User click login button
    Then User login successful redirect to page home
    When User add to cart 0
    And User add to cart 1
    Then User added items to cart

  Scenario: