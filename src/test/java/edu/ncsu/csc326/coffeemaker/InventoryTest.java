package edu.ncsu.csc326.coffeemaker;
import static org.junit.Assert.*;

import edu.ncsu.csc326.coffeemaker.exceptions.InventoryException;
import edu.ncsu.csc326.coffeemaker.exceptions.RecipeException;
import org.junit.Before;
import org.junit.Test;

public class InventoryTest {

    private Inventory inventory;

    /**
     * Initializes inventory
     */
    @Before
    public void setUp() {
        inventory = new Inventory();
    }

    /**
     * Try to set chocolate with various value (negative, zero, positive)
     */
    @Test
    public void testSetChocolate() {
        inventory.setChocolate(-1); // this should not change chocolate value
        assertEquals(15, inventory.getChocolate()); // show default value (15)
        inventory.setChocolate(0); // change chocolate value from 15 to 0
        assertEquals(0, inventory.getChocolate());
        inventory.setChocolate(100); // change chocolate value from 0 to 100
        assertEquals(100, inventory.getChocolate());
    }

    /**
     * Passing string that can't convert to int to addChocolate()
     * @throws InventoryException if there was an error parsing the quanity to a positive integer.
     */
    @Test(expected = InventoryException.class)
    public void testAddChocolateWithNotNumber() throws InventoryException {
        inventory.addChocolate("Chocolate");
    }

    /**
     * Passing negative value to addChocolate()
     * @throws InventoryException if there was an error parsing the quanity to a positive integer.
     */
    @Test(expected = InventoryException.class)
    public void testAddChocolateWithNegativeNumber() throws InventoryException {
        inventory.addChocolate("-1");
    }

    /**
     * Passing positive value to addChocolate()
     * @throws InventoryException if there was an error parsing the quanity to a positive integer.
     */
    @Test
    public void testAddChocolateWithPositiveNumber() throws InventoryException {
        inventory.addChocolate("0"); // default chocolate value (15) + 0 = 15
        assertEquals(15, inventory.getChocolate());
        inventory.addChocolate("100"); // 15 + 100 = 115
        assertEquals(115, inventory.getChocolate());
    }

    /**
     * Try to set coffee with various value (negative, zero, positive)
     */
    @Test
    public void testSetCoffee() {
        inventory.setCoffee(-1); // this should not change coffee value
        assertEquals(15, inventory.getCoffee()); // show default value (15)
        inventory.setCoffee(0); // change coffee value from 15 to 0
        assertEquals(0, inventory.getCoffee());
        inventory.setCoffee(100); // change coffee value from 0 to 100
        assertEquals(100, inventory.getCoffee());
    }

    /**
     * Passing string that can't convert to int to addCoffee()
     * @throws InventoryException if there was an error parsing the quanity to a positive integer.
     */
    @Test(expected = InventoryException.class)
    public void testAddCoffeeWithNotNumber() throws InventoryException {
        inventory.addCoffee("Coffee");
    }

    /**
     * Passing negative value to addCoffee()
     * @throws InventoryException if there was an error parsing the quanity to a positive integer.
     */
    @Test(expected = InventoryException.class)
    public void testAddCoffeeWithNegativeNumber() throws InventoryException {
        inventory.addCoffee("-1");
    }

    /**
     * Passing positive value to addCoffee()
     * @throws InventoryException if there was an error parsing the quanity to a positive integer.
     */
    @Test
    public void testAddCoffeeWithPositiveNumber() throws InventoryException {
        inventory.addCoffee("0"); // default coffee value (15) + 0 = 15
        assertEquals(15, inventory.getCoffee());
        inventory.addCoffee("100"); // 15 + 100 = 115
        assertEquals(115, inventory.getCoffee());
    }

    /**
     * Try to set milk with various value (negative, zero, positive)
     */
    @Test
    public void testSetMilk() {
        inventory.setMilk(-1); // this should not change milk value
        assertEquals(15, inventory.getMilk()); // show default value (15)
        inventory.setMilk(0); // change milk value from 15 to 0
        assertEquals(0, inventory.getMilk());
        inventory.setMilk(100); // change milk value from 0 to 100
        assertEquals(100, inventory.getMilk());
    }

    /**
     * Passing string that can't convert to int to addMilk()
     * @throws InventoryException if there was an error parsing the quanity to a positive integer.
     */
    @Test(expected = InventoryException.class)
    public void testAddMilkWithNotNumber() throws InventoryException {
        inventory.addMilk("Milk");
    }

    /**
     * Passing negative value to addMilk()
     * @throws InventoryException if there was an error parsing the quanity to a positive integer.
     */
    @Test(expected = InventoryException.class)
    public void testAddMilkWithNegativeNumber() throws InventoryException {
        inventory.addMilk("-1");
    }

    /**
     * Passing positive value to addMilk()
     * @throws InventoryException if there was an error parsing the quanity to a positive integer.
     */
    @Test
    public void testAddMilkWithPositiveNumber() throws InventoryException {
        inventory.addMilk("0"); // default milk value (15) + 0 = 15
        assertEquals(15, inventory.getMilk());
        inventory.addMilk("100"); // 15 + 100 = 115
        assertEquals(115, inventory.getMilk());
    }

    /**
     * Try to set sugar with various value (negative, zero, positive)
     */
    @Test
    public void testSetSugar() {
        inventory.setSugar(-1); // this should not change sugar value
        assertEquals(15, inventory.getSugar()); // show default value (15)
        inventory.setSugar(0); // change sugar value from 15 to 0
        assertEquals(0, inventory.getSugar());
        inventory.setSugar(100); // change sugar value from 0 to 100
        assertEquals(100, inventory.getSugar());
    }

    /**
     * Passing string that can't convert to int to addSugar()
     * @throws InventoryException if there was an error parsing the quanity to a positive integer.
     */
    @Test(expected = InventoryException.class)
    public void testAddSugarWithNotNumber() throws InventoryException {
        inventory.addSugar("Sugar");
    }

    /**
     * Passing negative value to addSugar()
     * @throws InventoryException if there was an error parsing the quanity to a positive integer.
     */
    @Test(expected = InventoryException.class)
    public void testAddSugarWithNegativeNumber() throws InventoryException {
        inventory.addSugar("-1");
    }

    /**
     * Passing positive value to addSugar()
     * @throws InventoryException if there was an error parsing the quanity to a positive integer.
     */
    @Test
    public void testAddSugarWithPositiveNumber() throws InventoryException {
        inventory.addSugar("0"); // default sugar value (15) + 0 = 15
        assertEquals(15, inventory.getSugar());
        inventory.addSugar("100"); // 15 + 100 = 115
        assertEquals(115, inventory.getSugar());
    }

    /**
     * If some ingredient in inventory is not enough to make the coffee, it should return false, otherwise is true.
     * @throws RecipeException if there was an error parsing the ingredient amount when setting up the recipe.
     */
    @Test
    public void testEnoughIngredientsWithHardRecipe() throws RecipeException {
        Recipe recipe1 = new Recipe();
        assertTrue(inventory.enoughIngredients(recipe1)); // before set ingredient, this should be pass
        recipe1.setAmtCoffee("1000");
        assertFalse(inventory.enoughIngredients(recipe1));
        recipe1.setAmtCoffee("0");
        recipe1.setAmtChocolate("1000");
        assertFalse(inventory.enoughIngredients(recipe1));
        recipe1.setAmtChocolate("0");
        recipe1.setAmtMilk("1000");
        assertFalse(inventory.enoughIngredients(recipe1));
        recipe1.setAmtMilk("0");
        recipe1.setAmtSugar("1000");
        assertFalse(inventory.enoughIngredients(recipe1));
    }

}
