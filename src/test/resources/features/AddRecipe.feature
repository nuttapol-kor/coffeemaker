Feature: Add recipes to the recipe book in the coffee maker
  Only three recipes may be added to the coffee maker.
  Each recipe name must be unique in the recipe list.

  Background:
    Given Turn on the coffee maker

  Scenario: add one recipe to the recipe book in the coffee maker
    When I add 1 recipe
    Then recipe book has 1 recipe
    
  Scenario: add two recipe to the recipe book in the coffee maker
    When I add 2 recipes
    Then recipe book has 2 recipes

  Scenario: add three recipe to the recipe book in the coffee maker
    When I add 3 recipes
    Then recipe book has 3 recipes

  Scenario: add four recipe to the recipe book in the coffee maker
    When I add 4 recipes
    Then recipe book has 3 recipes