Feature: Add Ingredients to the inventory in the coffee maker
  The user will be prompted for the units of each of the four ingredients
  (coffee, milk, sugar, chocolate) they wish to add to the inventory.
  All ingredients in inventory starting with 15.

  Background:
    Given Turn on the coffee maker

  Scenario: add coffee to the inventory in the coffee maker
    When I add 10 coffee, add 0 milk, add 0 sugar, add 0 chocolate
    Then Inventory has 25 coffee, 15 milk, 15 sugar, 15 chocolate

  Scenario: add milk to the inventory in the coffee maker
    When I add 0 coffee, add 10 milk, add 0 sugar, add 0 chocolate
    Then Inventory has 15 coffee, 25 milk, 15 sugar, 15 chocolate

  Scenario: add sugar to the inventory in the coffee maker
    When I add 0 coffee, add 0 milk, add 10 sugar, add 0 chocolate
    Then Inventory has 15 coffee, 15 milk, 25 sugar, 15 chocolate

  Scenario: add chocolate to the inventory in the coffee maker
    When I add 0 coffee, add 0 milk, add 0 sugar, add 10 chocolate
    Then Inventory has 15 coffee, 15 milk, 15 sugar, 25 chocolate

  Scenario: add coffee to the inventory in the coffee maker with negative
    When I add -10 coffee, add 0 milk, add 0 sugar, add 0 chocolate
    Then Throw inventory exception

  Scenario: add milk to the inventory in the coffee maker with negative
    When I add 0 coffee, add -10 milk, add 0 sugar, add 0 chocolate
    Then Throw inventory exception

  Scenario: add sugar to the inventory in the coffee maker with negative
    When I add 0 coffee, add 0 milk, add -10 sugar, add 0 chocolate
    Then Throw inventory exception

  Scenario: add chocolate to the inventory in the coffee maker with negative
    When I add 0 coffee, add 0 milk, add 0 sugar, add -10 chocolate
    Then Throw inventory exception