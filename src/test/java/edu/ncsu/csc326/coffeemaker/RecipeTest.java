package edu.ncsu.csc326.coffeemaker;
import static org.junit.Assert.*;

import edu.ncsu.csc326.coffeemaker.exceptions.RecipeException;
import org.junit.Before;
import org.junit.Test;
import java.lang.reflect.*;

public class RecipeTest {

    private Recipe recipe1;
    private Recipe recipe2;

    /**
     * Initializes inventory
     */
    @Before
    public void setUp() {
        recipe1 = new Recipe();
        recipe2 = new Recipe();
    }

    /**
     * Given a string that cannot convert to a number to setAmtChocolate()
     * Then raise an error.
     * @throws RecipeException if there was an error parsing the ingredient amount when setting up the recipe.
     */
    @Test(expected = RecipeException.class)
    public void testSetChocolateWithNotNumber() throws RecipeException {
        recipe1.setAmtChocolate("Chocolate");
    }

    /**
     * Given a negative number to setAmtChocolate()
     * Then raise an error
     * @throws RecipeException if there was an error parsing the ingredient amount when setting up the recipe.
     */
    @Test(expected = RecipeException.class)
    public void testSetChocolateWithNegativeNumber() throws RecipeException {
        recipe1.setAmtChocolate("-1");
    }

    /**
     * Given a position number to setAmtChocolate()
     * @throws RecipeException if there was an error parsing the ingredient amount when setting up the recipe.
     */
    @Test
    public void testSetChocolateWithPositiveNumber() throws RecipeException {
        recipe1.setAmtChocolate("0");
        assertEquals(0, recipe1.getAmtChocolate());
        recipe1.setAmtChocolate("100");
        assertEquals(100, recipe1.getAmtChocolate());
    }

    /**
     * Given a string that cannot convert to a number to setAmtCoffee()
     * Then raise an error.
     * @throws RecipeException if there was an error parsing the ingredient amount when setting up the recipe.
     */
    @Test(expected = RecipeException.class)
    public void testSetCoffeeWithNotNumber() throws RecipeException {
        recipe1.setAmtCoffee("Coffee");
    }

    /**
     * Given a negative number to setAmtCoffee()
     * Then raise an error
     * @throws RecipeException if there was an error parsing the ingredient amount when setting up the recipe.
     */
    @Test(expected = RecipeException.class)
    public void testSetCoffeeWithNegativeNumber() throws RecipeException {
        recipe1.setAmtCoffee("-1");
    }

    /**
     * Given a position number to setAmtCoffee()
     * @throws RecipeException if there was an error parsing the ingredient amount when setting up the recipe.
     */
    @Test
    public void testSetCoffeeWithPositiveNumber() throws RecipeException {
        recipe1.setAmtCoffee("0");
        assertEquals(0, recipe1.getAmtCoffee());
        recipe1.setAmtCoffee("100");
        assertEquals(100, recipe1.getAmtCoffee());
    }

    /**
     * Given a string that cannot convert to a number to setAmtMilk()
     * Then raise an error.
     * @throws RecipeException if there was an error parsing the ingredient amount when setting up the recipe.
     */
    @Test(expected = RecipeException.class)
    public void testSetMilkWithNotNumber() throws RecipeException {
        recipe1.setAmtMilk("Milk");
    }

    /**
     * Given a negative number to setAmtMilk()
     * Then raise an error
     * @throws RecipeException if there was an error parsing the ingredient amount when setting up the recipe.
     */
    @Test(expected = RecipeException.class)
    public void testSetMilkWithNegativeNumber() throws RecipeException {
        recipe1.setAmtMilk("-1");
    }

    /**
     * Given a position number to setAmtMilk()
     * @throws RecipeException if there was an error parsing the ingredient amount when setting up the recipe.
     */
    @Test
    public void testSetMilkWithPositiveNumber() throws RecipeException {
        recipe1.setAmtMilk("0");
        assertEquals(0, recipe1.getAmtMilk());
        recipe1.setAmtMilk("100");
        assertEquals(100, recipe1.getAmtMilk());
    }

    /**
     * Given a string that cannot convert to a number to setAmtSugar()
     * Then raise an error.
     * @throws RecipeException if there was an error parsing the ingredient amount when setting up the recipe.
     */
    @Test(expected = RecipeException.class)
    public void testSetSugarWithNotNumber() throws RecipeException {
        recipe1.setAmtSugar("Sugar");
    }

    /**
     * Given a negative number to setAmtSugar()
     * Then raise an error
     * @throws RecipeException if there was an error parsing the ingredient amount when setting up the recipe.
     */
    @Test(expected = RecipeException.class)
    public void testSetSugarWithNegativeNumber() throws RecipeException {
        recipe1.setAmtSugar("-1");
    }

    /**
     * Given a position number to setAmtSugar()
     * @throws RecipeException if there was an error parsing the ingredient amount when setting up the recipe.
     */
    @Test
    public void testSetSugarWithPositiveNumber() throws RecipeException {
        recipe1.setAmtSugar("0");
        assertEquals(0, recipe1.getAmtSugar());
        recipe1.setAmtSugar("100");
        assertEquals(100, recipe1.getAmtSugar());
    }

    /**
     * Given a string that cannot convert to a number to setPrice()
     * Then raise an error.
     * @throws RecipeException if there was an error parsing the ingredient amount when setting up the recipe.
     */
    @Test(expected = RecipeException.class)
    public void testSetPriceWithNotNumber() throws RecipeException {
        recipe1.setPrice("Chocolate");
    }

    /**
     * Given a negative number to setPrice()
     * Then raise an error
     * @throws RecipeException if there was an error parsing the ingredient amount when setting up the recipe.
     */
    @Test(expected = RecipeException.class)
    public void testSetPriceWithNegativeNumber() throws RecipeException {
        recipe1.setPrice("-1");
    }

    /**
     * Given a position number to setPrice()
     * @throws RecipeException if there was an error parsing the ingredient amount when setting up the recipe.
     */
    @Test
    public void testSetPriceWithPositiveNumber() throws RecipeException {
        recipe1.setPrice("0");
        assertEquals(0, recipe1.getPrice());
        recipe1.setPrice("100");
        assertEquals(100, recipe1.getPrice());
    }

    /**
     * Given a null to setName()
     */
    @Test
    public void testSetNameWithNull() {
        recipe1.setName(null);
        assertTrue(recipe1.getName().isEmpty()); // default name is empty string
    }

    /**
     * Given a command name as a String to setName()
     */
    @Test
    public void testSetNameWithString() {
        recipe1.setName("Coffee");
        assertEquals("Coffee", recipe1.getName());
    }

    /**
     * Test toString() that show properly
     */
    @Test
    public void testToString() {
        assertEquals("", recipe1.toString()); // default name is empty string
        recipe1.setName("Mocha");
        assertEquals("Mocha", recipe1.getName());
    }

    /**
     * If recipe is equal hashCode will be the same, if it's not hashCode between two Recipe is different
     */
    @Test
    public void testHashCode() throws NoSuchFieldException, IllegalAccessException {
        recipe1.setName("Coffee");
        recipe2.setName("Coffee");
        assertEquals(recipe1.hashCode(), recipe2.hashCode());
        recipe2.setName("Mocha");
        assertNotEquals(recipe1.hashCode(), recipe2.hashCode());
        Recipe recipe3 = new Recipe();
        Field field = Recipe.class.getDeclaredField("name"); // get field name
        field.setAccessible(true);
        field.set(recipe3, null); // set name to null
        assertEquals(31, recipe3.hashCode()); // Recipe object that has named = null, hashCode = 31
                                                        // from prime(31) * result(1) + 0 (if name = null)
    }

    /**
     * Given string object to compare with Recipe object
     */
    @Test
    public void testEqualButNotTheSameClass() {
        String s1 = "obj";
        assertFalse(recipe1.equals(s1));
    }

    /**
     * Test equal with recipe name is null
     * @throws NoSuchFieldException Signals that the class doesn't have a field of a specified name.
     * @throws IllegalAccessException create an instance but the currently executing method does not have access to the definition of the specified field,
     */
    @Test
    public void testEqualWithNameNull() throws NoSuchFieldException, IllegalAccessException {
        Recipe recipe3 = new Recipe();
        // forced to access private field name
        Field field = Recipe.class.getDeclaredField("name"); // get field name
        field.setAccessible(true);
        field.set(recipe3, null); // set name to null
        assertFalse(recipe3.equals(recipe1)); // recipe3 name = null, recipe1 name = ""
        field.set(recipe1, null);
        assertTrue(recipe3.equals(recipe1));
        // same class, but name not equal
        recipe1.setName("Coffee");
        field.set(recipe3, "Mocha");
        assertFalse(recipe3.equals(recipe1));
        // same class and same name
        recipe1.setName("Mocha");
        assertTrue(recipe3.equals(recipe1));
    }
}
