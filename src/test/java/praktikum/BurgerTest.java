package praktikum;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class BurgerTest {

    @Test
    public void getPriceWithoutIngredients() {
        float price = 100;
        Bun bun = new Bun("Булочка с кунжутом",price);

        var burger = new Burger();
        burger.setBuns(bun);

        float actual = bun.getPrice() * 2;
        Assert.assertEquals(actual, burger.getPrice(), 0);

    }
    @Test
    public void getPriceWithIngredients() {
        float price = 100;
        Bun bun = new Bun("Булочка с кунжутом",price);

        Ingredient sauce = new Ingredient(IngredientType.SAUCE, "name",10);
        Ingredient filling = new Ingredient(IngredientType.FILLING, "name",10);

        var burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(sauce);
        burger.addIngredient(filling);

        float actual = bun.getPrice() * 2 + sauce.price + filling.price;
        Assert.assertEquals(actual, burger.getPrice(),0);
    }

    @Test
    public void getPriceWithAddAndRemoveIngredients() {
        float price = 100;
        Bun bun = new Bun("Булочка с кунжутом",price);

        Ingredient sauce = new Ingredient(IngredientType.SAUCE, "name",10);
        Ingredient filling = new Ingredient(IngredientType.FILLING, "name",10);

        var burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(sauce);
        burger.addIngredient(filling);

        burger.removeIngredient(1);

        float actual = bun.getPrice() * 2 + filling.price;
        Assert.assertEquals(actual, burger.getPrice(),0);
    }

    @Test
    public void getReceiptWithIngredients() {
        float price = 100;
        Bun bun = new Bun("Булочка с кунжутом",price);

        Ingredient sauce = new Ingredient(IngredientType.SAUCE, "соус барбекю",10);
        Ingredient filling = new Ingredient(IngredientType.FILLING, "котлета",10);

        var burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(sauce);
        burger.addIngredient(filling);

        String actual = "(==== Булочка с кунжутом ====)\n" +
                "= sauce соус барбекю =\n" +
                "= filling котлета =\n" +
                "(==== Булочка с кунжутом ====)\n" +
                "\n" +
                "Price: 220,000000" +
                "\n";
        Assert.assertEquals(actual, burger.getReceipt());
    }

    @Test
    public void getReceiptWithAddAndMoveIngredients() {
        float price = 100;
        Bun bun = new Bun("Булочка с кунжутом",price);

        Ingredient sauce = new Ingredient(IngredientType.SAUCE, "соус барбекю",10);
        Ingredient filling = new Ingredient(IngredientType.FILLING, "котлета",10);

        var burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(sauce);
        burger.addIngredient(filling);
        burger.moveIngredient(0, 1);

        String actual = "(==== Булочка с кунжутом ====)\n" +
                "= filling котлета =\n" +
                "= sauce соус барбекю =\n" +
                "(==== Булочка с кунжутом ====)\n" +
                "\n" +
                "Price: 220,000000" +
                "\n";
        Assert.assertEquals(actual, burger.getReceipt());
    }

    @Test
    public void addIngredientTest(){
        Bun bun = new Bun("Булочка с кунжутом",100);
        Ingredient sauce = new Ingredient(IngredientType.SAUCE, "соус барбекю",10);
        Ingredient filling = new Ingredient(IngredientType.FILLING, "котлета",10);
        var burger = new Burger();
        burger.setBuns(bun);

        burger.addIngredient(sauce);
        burger.addIngredient(filling);

        Assert.assertEquals(2, burger.ingredients.size());
        Assert.assertTrue(burger.ingredients.stream().anyMatch((i) ->  i.getName() == sauce.getName()));
        Assert.assertTrue(burger.ingredients.stream().anyMatch((i) ->  i.getName() == filling.getName()));
    }

    @Test
    public void removeIngredientTest(){
        Bun bun = new Bun("Булочка с кунжутом",100);
        Ingredient sauce = new Ingredient(IngredientType.SAUCE, "соус барбекю",10);
        Ingredient filling = new Ingredient(IngredientType.FILLING, "котлета",10);
        var burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(sauce);
        burger.addIngredient(filling);

        burger.removeIngredient(1);

        Assert.assertEquals(1, burger.ingredients.size());
        Assert.assertTrue(burger.ingredients.stream().anyMatch((i) ->  i.getName() == sauce.getName()));
        Assert.assertFalse(burger.ingredients.stream().anyMatch((i) ->  i.getName() == filling.getName()));
    }

    @Test
    public void moveIngredientTest(){
        Bun bun = new Bun("Булочка с кунжутом",100);
        Ingredient sauce = new Ingredient(IngredientType.SAUCE, "соус барбекю",10);
        Ingredient filling = new Ingredient(IngredientType.FILLING, "котлета",10);
        var burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(sauce);
        burger.addIngredient(filling);

        burger.moveIngredient(1,0);

        Assert.assertEquals(filling.getName(), burger.ingredients.get(0).getName());
        Assert.assertEquals(sauce.getName(), burger.ingredients.get(1).getName());
    }
}