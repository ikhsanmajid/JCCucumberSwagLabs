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

  Scenario Outline: User check items cart
    When User click cart button
    And User cart <item> right <name> and <price>
    And User click checkout button
    Then User redirect to shipping information

    Examples:
      | item | name | price |
      | 0    | "Sauce Labs Backpack" | "29.99" |
      | 1    | "Sauce Labs Bike Light" | "9.99" |

  Scenario Outline: User input empty shipping address
    When User input empty <firstName> or empty <lastName> or empty <postalCode>
    And User click continue button
    Then Show shipping error message

    Examples:
      | firstName | lastName | postalCode |
      | "ikhsan" | "" | "12345" |
      | "" | "majid" | "12345" |
      | "ikhsan" | "majid" | "" |
      | "" | "" | "" |

  Scenario: User input valid shipping address
    When User input valid firstName and valid lastName and valid postalCode
    And User click continue button
    Then Show checkout overview page

  Scenario: User finish checkout
    When User click finish button
    Then Show success order

  Scenario: User back to page products
    When User click back home button
    Then User redirect to page products