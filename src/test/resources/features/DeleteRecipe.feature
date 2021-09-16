Feature: Delete a recipe from recipe book

  Background:
    Given Turn on the coffee maker
    When I add 2 recipe

  Scenario: Delete one recipe
    When I delete recipe number 1
    Then recipe book has 1 recipe