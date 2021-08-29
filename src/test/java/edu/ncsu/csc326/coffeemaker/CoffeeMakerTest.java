/*
 * Copyright (c) 2009,  Sarah Heckman, Laurie Williams, Dright Ho
 * All Rights Reserved.
 * 
 * Permission has been explicitly granted to the University of Minnesota 
 * Software Engineering Center to use and distribute this source for 
 * educational purposes, including delivering online education through
 * Coursera or other entities.  
 * 
 * No warranty is given regarding this software, including warranties as
 * to the correctness or completeness of this software, including 
 * fitness for purpose.
 * 
 * 
 * Modifications 
 * 20171114 - Ian De Silva - Updated to comply with JUnit 4 and to adhere to 
 * 							 coding standards.  Added test documentation.
 */
package edu.ncsu.csc326.coffeemaker;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import edu.ncsu.csc326.coffeemaker.exceptions.InventoryException;
import edu.ncsu.csc326.coffeemaker.exceptions.RecipeException;

/**
 * Unit tests for CoffeeMaker class.
 * 
 * @author Sarah Heckman
 */
public class CoffeeMakerTest {
	
	/**
	 * The object under test.
	 */
	private CoffeeMaker coffeeMaker;
	
	// Sample recipes to use in testing.
	private Recipe recipe1;
	private Recipe recipe2;
	private Recipe recipe3;
	private Recipe recipe4;

	/**
	 * Initializes some recipes to test with and the {@link CoffeeMaker} 
	 * object we wish to test.
	 * 
	 * @throws RecipeException  if there was an error parsing the ingredient 
	 * 		amount when setting up the recipe.
	 */
	@Before
	public void setUp() throws RecipeException {
		coffeeMaker = new CoffeeMaker();
		
		//Set up for r1
		recipe1 = new Recipe();
		recipe1.setName("Coffee");
		recipe1.setAmtChocolate("0");
		recipe1.setAmtCoffee("3");
		recipe1.setAmtMilk("1");
		recipe1.setAmtSugar("1");
		recipe1.setPrice("50");
		
		//Set up for r2
		recipe2 = new Recipe();
		recipe2.setName("Mocha");
		recipe2.setAmtChocolate("20");
		recipe2.setAmtCoffee("3");
		recipe2.setAmtMilk("1");
		recipe2.setAmtSugar("1");
		recipe2.setPrice("75");
		
		//Set up for r3
		recipe3 = new Recipe();
		recipe3.setName("Latte");
		recipe3.setAmtChocolate("0");
		recipe3.setAmtCoffee("3");
		recipe3.setAmtMilk("3");
		recipe3.setAmtSugar("1");
		recipe3.setPrice("100");
		
		//Set up for r4
		recipe4 = new Recipe();
		recipe4.setName("Hot Chocolate");
		recipe4.setAmtChocolate("4");
		recipe4.setAmtCoffee("0");
		recipe4.setAmtMilk("1");
		recipe4.setAmtSugar("1");
		recipe4.setPrice("65");
	}

	/**
	 * Only three recipes may be added to the Coffee Maker
	 * When we add fourth receive to the Coffee Maker, adding should not success
	 * Then return false.
	 */
	@Test
	public void testAddRecipe() {
		coffeeMaker.addRecipe(recipe1); // 1
		coffeeMaker.addRecipe(recipe2); // 2
		coffeeMaker.addRecipe(recipe3); // 3
		assertFalse(coffeeMaker.addRecipe(recipe4)); // 4
	}

	/**
	 * Each recipe name must be unique in the recipe list.
	 */
	@Test
	public void testAddDuplicateRecipe() {
		boolean attempt1 = coffeeMaker.addRecipe(recipe1);
		assertTrue(attempt1);
		boolean attempt2 = coffeeMaker.addRecipe(recipe1);
		assertFalse(attempt2);
	}

	/**
	 * Given valid index to delete recipe in Coffee maker
	 * The deleted recipe should not be in recipe book
	 */
	@Test
	public void testDeleteRecipe() {
		coffeeMaker.addRecipe(recipe1);
		coffeeMaker.addRecipe(recipe2);
		String s1 = coffeeMaker.deleteRecipe(0);
		String s2 = coffeeMaker.deleteRecipe(1);
		assertEquals("Coffee", s1);
		assertEquals("Mocha", s2);
		boolean found = false;
		Recipe[] recipes = coffeeMaker.getRecipes();
		// if found the deleted recipe in recipe book, found = true
		int countRecipe = 0;
		for (Recipe recipe : recipes) {
			if (recipe != null) {
				if (recipe.getName().equals(s1) || recipe.getName().equals(s2)) {
					found = true;
				}
				if (recipe.getClass() == Recipe.class) {
					countRecipe++;
				}
			}
		}
		assertFalse(found); // deleted recipe must not found in recipe book.
		assertEquals(0, countRecipe); // if recipe has been deleted, recipe object should be zero in recipe book
	}

	/**
	 * Given the empty recipe book
	 * When try to delete the recipe (call deleteRecipe()) should return null (return null if the recipe does not exist)
	 */
	@Test
	public void testDeleteRecipeWhenRecipeBookIsEmpty() {
		String s1 = coffeeMaker.deleteRecipe(0);
		assertNull(s1);
	}

	/**
	 * Given one recipe in Coffee Maker
	 * When try to delete with invalid index target (negative index) should return null (return null if the recipe does not exist)
	 */
	@Test
	public void testDeleteRecipeWithNegativeIndexRecipeToDelete() {
		coffeeMaker.addRecipe(recipe1);
		String s1 = coffeeMaker.deleteRecipe(-1);
		assertNull(s1);
	}

	/**
	 * Given one recipe in Coffee Maker
	 * When try to delete with invalid index target (Out of bound index) should return null (return null if the recipe does not exist)
	 */
	@Test
	public void testDeleteRecipeWithOutOfBoundIndexRecipeToDelete() {
		coffeeMaker.addRecipe(recipe1);
		String s1 = coffeeMaker.deleteRecipe(100);
		assertNull(s1);
	}

	/**
	 * User enter the new recipe information (Recipe object). A recipe name may not be changed.
	 */
	@Test
	public void testEditRecipe() {
		coffeeMaker.addRecipe(recipe1);
		coffeeMaker.addRecipe(recipe2);
		// edit recipe2 (Mocha) by to be the same with recipe3 (Latte) except the recipe name.
		coffeeMaker.editRecipe(1, recipe3);
		// the recipe that just edited. the recipe name should be "Mocha".
		assertEquals("Mocha", coffeeMaker.getRecipes()[1].getName());
	}

	/**
	 * Given the empty recipe book
	 * When try to edit the recipe (call editRecipe()) should return null (return null if the recipe does not exist)
	 */
	@Test
	public void testEditRecipeWhenRecipeBookIsEmpty() {
		String s1 = coffeeMaker.editRecipe(0, recipe1);
		assertNull(s1);
	}

	/**
	 * Given one recipe in Coffee Maker
	 * When try to edit with invalid index target (negative index) should return null (return null if the recipe does not exist)
	 */
	@Test
	public void testEditRecipeWithNegativeIndexRecipeToEdit() {
		coffeeMaker.addRecipe(recipe1);
		String s1 = coffeeMaker.editRecipe(-1, recipe2);
		assertNull(s1);
	}

	/**
	 * Given one recipe in Coffee Maker
	 * When try to edit with invalid index target (out of bound index) should return null (return null if the recipe does not exist)
	 */
	@Test
	public void testEditRecipeWithOutOfBoundIndexRecipeToEdit() {
		coffeeMaker.addRecipe(recipe1);
		String s1 = coffeeMaker.editRecipe(100, recipe2);
		assertNull(s1);
	}
	
	/**
	 * Given a coffee maker with the default inventory
	 * When we add inventory with well-formed quantities
	 * Then we do not get an exception trying to read the inventory quantities.
	 * 
	 * @throws InventoryException  if there was an error parsing the quanity
	 * 		to a positive integer.
	 */
	@Test
	public void testAddInventory() throws InventoryException {
		coffeeMaker.addInventory("4","7","0","9");
		coffeeMaker.addInventory("10", "10", "10", "10");
		// boundary case
		coffeeMaker.addInventory("1","0","0","0");
		coffeeMaker.addInventory("1","0","0","0");
		coffeeMaker.addInventory("0", "1", "0", "0");
		coffeeMaker.addInventory("0", "0", "1", "0");
		coffeeMaker.addInventory("0", "0", "0", "1");
	}
	
	/**
	 * Given a coffee maker with the default inventory
	 * When we add inventory with malformed quantities (i.e., a negative 
	 * quantity and a non-numeric string)
	 * Then we get an inventory exception
	 * 
	 * @throws InventoryException  if there was an error parsing the quanity
	 * 		to a positive integer.
	 */
	@Test(expected = InventoryException.class)
	public void testAddInventoryException() throws InventoryException {
		coffeeMaker.addInventory("4", "-1", "asdf", "3");
		// try to add malformed quantities for each args
		// start with string
		coffeeMaker.addInventory("coffee", "Mike", "Sugar", "Chocolate");
		// negative quantity
		coffeeMaker.addInventory("-1", "-1", "-1", "-1");
	}

	/**
	 * The units of each item in the inventory are displayed (return as string)
	 * amount of all ingredient default is 15
	 */
	@Test
	public void testCheckInventory() {
		StringBuffer s1 = new StringBuffer();
		s1.append("Coffee: ");
		s1.append("15");
		s1.append("\n");
		s1.append("Milk: ");
		s1.append("15");
		s1.append("\n");
		s1.append("Sugar: ");
		s1.append("15");
		s1.append("\n");
		s1.append("Chocolate: ");
		s1.append("15");
		s1.append("\n");
		assertEquals(s1.toString(), coffeeMaker.checkInventory());
	}
	
	/**
	 * Given a coffee maker with one valid recipe
	 * When we make coffee, selecting the valid recipe and paying more than 
	 * 		the coffee costs
	 * Then we get the correct change back.
	 */
	@Test
	public void testMakeCoffeePaidMoreThanPrice() {
		coffeeMaker.addRecipe(recipe1);
		// inventory: coffee = 15, milk = 15, sugar = 15, chocolate = 15. enough for make coffee
		assertEquals(25, coffeeMaker.makeCoffee(0, 75)); // 75-50 = 25
	}

	/**
	 * Given a coffee maker with one valid recipe
	 * When we make coffee, selecting the valid recipe and paying equal to
	 * 		the coffee costs
	 * Then we will not get the change.
	 */
	@Test
	public void testMakeCoffeePaidEqualPrice() {
		coffeeMaker.addRecipe(recipe1);
		// inventory: coffee = 15, milk = 15, sugar = 15, chocolate = 15. enough for make coffee
		assertEquals(0, coffeeMaker.makeCoffee(0, 50)); // 50-50 = 0
	}

	/**
	 * Given a coffee maker with one valid recipe
	 * When we make coffee, selecting the valid recipe and paying less than
	 * 		the coffee costs
	 * Then we get the money back.
	 */
	@Test
	public void testMakeCoffeePaidLessThanPrice() {
		coffeeMaker.addRecipe(recipe1);
		// inventory: coffee = 15, milk = 15, sugar = 15, chocolate = 15. enough for make coffee
		assertEquals(25, coffeeMaker.makeCoffee(0, 25)); // amtPaid (25) < Price (50) cannot purchase, so change = 25.
	}

	/**
	 * Make a coffee with invalid selecting (negative integer)
	 * makeCoffee() should handle for invalid args, so makeCoffee() must return something and not occur an error.
	 *
	 */
	@Test
	public void testMakeCoffeeWithNegativeIndexRecipeToPurchase() {
		coffeeMaker.addRecipe(recipe1);
		int change = coffeeMaker.makeCoffee(-1, 100);
		assertEquals(100, change);
	}

	/**
	 * Make a coffee with invalid selecting (Out of bound index)
	 * makeCoffee() should handle for invalid args, so makeCoffee() must return something and not occur an error.
	 *
	 */
	@Test
	public void testMakeCoffeeWithOutOfBoundRecipeToPurchase() {
		coffeeMaker.addRecipe(recipe1);
		int change = coffeeMaker.makeCoffee(100, 100);
		assertEquals(100, change);
	}

	/**
	 * Given one recipe that require some ingredient, but inventory not have enough.
	 * Then we get money back.
	 */
	@Test
	public void testMakeCoffeeWhenInventoryNotEnough() {
		// default inventory: coffee = 15, milk = 15, sugar = 15, chocolate = 15
		coffeeMaker.addRecipe(recipe2); // add Mocha
		// cannot make Mocha because Mocha need chocolate >= 20, but we got chocolate only 15.
		int change = coffeeMaker.makeCoffee(0, 100);
		assertEquals(100, change);

	}

	/**
	 * Given one recipe to Coffee Maker
	 * When user purchase beverage the ingredient in inventory should decrease with require ingredient in recipe.
	 */
	@Test
	public void testCheckInventoryWhenPurchaseBeverage() {
		StringBuffer s1 = new StringBuffer();
		coffeeMaker.addRecipe(recipe1);
		coffeeMaker.makeCoffee(0, 100);
		s1.append("Coffee: ");
		s1.append("12");
		s1.append("\n");
		s1.append("Milk: ");
		s1.append("14");
		s1.append("\n");
		s1.append("Sugar: ");
		s1.append("14");
		s1.append("\n");
		s1.append("Chocolate: ");
		s1.append("15");
		s1.append("\n");
		assertEquals(s1.toString(), coffeeMaker.checkInventory());
	}
}
