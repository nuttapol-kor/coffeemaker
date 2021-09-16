package edu.ncsu.csc326.coffeemaker;
import edu.ncsu.csc326.coffeemaker.exceptions.InventoryException;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.*;

public class CoffeeMakerCucumberTest {

    private CoffeeMaker coffeeMaker;
    private Exception exception;

    @Given("Turn on the coffee maker")
    public void turnOnTheCoffeeMaker() {
        coffeeMaker = new CoffeeMaker();
    }


    @When("I add {int} coffee, add {int} milk, add {int} sugar, add {int} chocolate")
    public void iAddCoffeeAddMilkAddSugarAddChocolate(Integer amtCoffee, Integer amtMilk, Integer amtSugar, Integer amtChocolate) throws InventoryException {
        try {
            coffeeMaker.addInventory(amtCoffee.toString(), amtMilk.toString(), amtSugar.toString(), amtChocolate.toString());
        } catch (Exception e) {
            exception = e;
        }
    }

    @Then("Inventory has {int} coffee, {int} milk, {int} sugar, {int} chocolate")
    public void inventoryHasCoffeeMilkSugarChocolate(Integer amtCoffee, Integer amtMilk, Integer amtSugar, Integer amtChocolate) {
        StringBuffer s1 = new StringBuffer();
        s1.append("Coffee: ");
        s1.append(amtCoffee.toString());
        s1.append("\n");
        s1.append("Milk: ");
        s1.append(amtMilk.toString());
        s1.append("\n");
        s1.append("Sugar: ");
        s1.append(amtSugar.toString());
        s1.append("\n");
        s1.append("Chocolate: ");
        s1.append(amtChocolate.toString());
        s1.append("\n");
        assertEquals(s1.toString(), coffeeMaker.checkInventory());
    }

    @Then("Throw {word} exception")
    public void throwInventoryException(String exceptionType) {
        if (exceptionType.equals("inventory")) {
            assertEquals(InventoryException.class, exception.getClass());
        }
        else fail();
    }

    @When("I add {int} recipe(s)")
    public void iAddARecipe(Integer num) {
        for (int i = 0; i< num; i++) {
            Recipe recipe = new Recipe();
            recipe.setName("Recipe " + (i+1));
            coffeeMaker.addRecipe(recipe);
        }
    }

    @Then("recipe book has {int} recipe(s)")
    public void recipeBookHasRecipe(Integer num) {
        int countRecipe = 0;
        for (Recipe recipe: coffeeMaker.getRecipes()) {
            if (recipe != null) {
                if (recipe.getClass() == Recipe.class) countRecipe++;
            }
        }
        assertEquals(num.intValue(), countRecipe);
    }

    @When("I delete recipe number {int}")
    public void iDeleteRecipeNumber(Integer num) {
        coffeeMaker.deleteRecipe(num);
    }
}
