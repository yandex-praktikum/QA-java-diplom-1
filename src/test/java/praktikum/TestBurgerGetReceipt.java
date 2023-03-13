package praktikum;

import org.junit.Assert;
import org.junit.Test;

public class TestBurgerGetReceipt {
    Bun testBun = new Bun("test_bun", 10.00F);
    Ingredient testIngredient1 = new Ingredient(IngredientType.SAUCE, "ingredient1", 15.00F);
    Ingredient testIngredient2 = new Ingredient(IngredientType.SAUCE, "ingredient2", 10.00F);
    Ingredient testIngredient3 = new Ingredient(IngredientType.SAUCE, "ingredient3", 20.00F);
    String expected1 = "(==== test_bun ====)\n" +
            "= sauce ingredient1 =\n" +
            "= sauce ingredient2 =\n" +
            "= sauce ingredient3 =\n" +
            "(==== test_bun ====)\n" +
            "\n" +
            "Price: 65,000000\n";
    String expected2 = "(==== test_bun ====)\n" +
            "= sauce ingredient1 =\n" +
            "= sauce ingredient3 =\n" +
            "(==== test_bun ====)\n" +
            "\n" +
            "Price: 55,000000\n";
    String expected3 = "(==== test_bun ====)\n" +
            "= sauce ingredient1 =\n" +
            "= sauce ingredient3 =\n" +
            "= sauce ingredient2 =\n" +
            "(==== test_bun ====)\n" +
            "\n" +
            "Price: 65,000000\n";

    @Test
    public void checkReceiptWith3Ingredients() {
        Burger testBurger = new Burger();
        testBurger.setBuns(testBun);
        testBurger.addIngredient(testIngredient1);
        testBurger.addIngredient(testIngredient2);
        testBurger.addIngredient(testIngredient3);

        String actualReceipt = testBurger.getReceipt();
        Assert.assertEquals(expected1, actualReceipt);
    }

    @Test
    public void checkReceiptWith2Ingredients() {
        Burger testBurger = new Burger();
        testBurger.setBuns(testBun);
        testBurger.addIngredient(testIngredient1);
        testBurger.addIngredient(testIngredient2);
        testBurger.addIngredient(testIngredient3);
        testBurger.removeIngredient(1);

        String actualReceipt = testBurger.getReceipt();
        Assert.assertEquals(expected2, actualReceipt);
    }

    @Test
    public void checkReceiptWith3MovedIngredients() {
        Burger testBurger = new Burger();
        testBurger.setBuns(testBun);
        testBurger.addIngredient(testIngredient1);
        testBurger.addIngredient(testIngredient2);
        testBurger.addIngredient(testIngredient3);
        testBurger.moveIngredient(1, 2);

        String actualReceipt = testBurger.getReceipt();
        Assert.assertEquals(expected3, actualReceipt);
    }
}