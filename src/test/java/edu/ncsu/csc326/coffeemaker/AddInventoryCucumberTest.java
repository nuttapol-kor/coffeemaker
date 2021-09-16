package edu.ncsu.csc326.coffeemaker;
import edu.ncsu.csc326.coffeemaker.exceptions.InventoryException;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.*;

public class AddInventoryCucumberTest {

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
}
