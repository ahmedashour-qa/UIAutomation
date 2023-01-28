Feature: Cart

  Background:
    Given User opens chrome browser and navigates to the url

  @@Test
  Scenario: Verify Add to Cart
    When Home page should be loaded
    And User scrolls down to Products section
    And Clicks on a product from the products list
    And Product description page should be loaded
    And Add to cart button should be displayed
    And User clicks on Add to cart button
    Then Product added alert should be loaded

  @@Test
  Scenario: Verify Remove Item from Cart
    When Home page should be loaded
    And User scrolls down to Products section
    And Clicks on a product from the products list
    And Product description page should be loaded
    And Add to cart button should be displayed
    And User clicks on Add to cart button
    And Product added alert should be loaded
    And User clicks on Ok button from the alert
    And Clicks on Cart tab from the top nav bar
    And User clicks on Remove Item Button
    Then Item should be removed from table

  @@Test
  Scenario Outline: Verify purchasing product
    Then Home page should be loaded
    When User scrolls down to Products section
    And Clicks on a product from the products list
    Then Product description page should be loaded
    And Add to cart button should be displayed
    When User clicks on Add to cart button
    Then Product added alert should be loaded
    When User clicks on Ok button from the alert
    And Clicks on Cart tab from the top nav bar
    Then Cart page should be loaded
    And Place Order button should be displayed
    When User clicks on Place Order button
    Then Place Order form should be loaded
    When User enters "<name>" into the Name input field
    And enters "<country>" into the Country input field
    And enters "<city>" into the City input field
    And enters "<credit_card_no>" into the Credit Card input field
    And enters "<month>" into the Month input field
    And enters "<year>" into the Year input field
    And clicks on the Purchase button
    Then Purchase confirmation alert should be displayed
    Examples:
      | name | country | city  | credit_card_no | month   | year |
      | Test | EGYPT   | Cairo | 123456         | October | 2022 |