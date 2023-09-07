package praktikum;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BurgerTest {

    private Burger burger;

    @Before
    public void before() {
        burger = new Burger();
    }

    @Test
    public void setBuns() {
        Bun bun = new Bun("name", 14.1f);
        burger.setBuns(bun);
        Assert.assertEquals(bun, burger.bun);
    }

    @Test
    public void positiveRemoveIngredient() {
        Ingredient ingredient1 = new Ingredient(IngredientType.SAUCE, "ketchunez", 10_000.05f);
        Ingredient ingredient2 = new Ingredient(IngredientType.FILLING, "natchinka", 100_500.0f);
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        Assert.assertEquals(2, burger.ingredients.size());
        burger.removeIngredient(0);
        Assert.assertEquals(1, burger.ingredients.size());
        Assert.assertEquals(ingredient2.getName(), burger.ingredients.get(0).getName());
        Assert.assertEquals(ingredient2.getPrice(), burger.ingredients.get(0).getPrice(), 0.001f);
        Assert.assertEquals(ingredient2.getType(), burger.ingredients.get(0).getType());
    }

    @Test
    public void negativeRemoveIngredient() {
        Ingredient ingredient1 = new Ingredient(IngredientType.SAUCE, "ketchunez", 10_000.05f);
        Ingredient ingredient2 = new Ingredient(IngredientType.FILLING, "natchinka", 100_500.0f);
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        Assert.assertEquals(2, burger.ingredients.size());
        Assert.assertThrows(IndexOutOfBoundsException.class, () -> burger.removeIngredient(2));
        Assert.assertEquals(2, burger.ingredients.size());
    }

    @Test
    public void moveIngredient() {
        Ingredient ingredient1 = new Ingredient(IngredientType.SAUCE, "ketchunez", 10_000.05f);
        Ingredient ingredient2 = new Ingredient(IngredientType.FILLING, "natchinka", 100_500.0f);
        Ingredient ingredient3 = new Ingredient(IngredientType.FILLING, "uffsladkiy", 10_000.0f);
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        burger.addIngredient(ingredient3);
        Assert.assertEquals(3, burger.ingredients.size());
        burger.moveIngredient(2, 0);

        Assert.assertEquals(ingredient3.getName(), burger.ingredients.get(0).getName());
        Assert.assertEquals(ingredient3.getPrice(), burger.ingredients.get(0).getPrice(), 0.001f);
        Assert.assertEquals(ingredient3.getType(), burger.ingredients.get(0).getType());
    }

    @Test
    public void getPrice() {
        Ingredient ingredient1 = new Ingredient(IngredientType.SAUCE, "ketchunez", 10_000.05f);
        Ingredient ingredient2 = new Ingredient(IngredientType.FILLING, "natchinka", 100_500.0f);
        Ingredient ingredient3 = new Ingredient(IngredientType.FILLING, "uffsladkiy", 10_000.0f);
        Bun bun = new Bun("name", 14.1f);
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        burger.addIngredient(ingredient3);
        burger.setBuns(bun);
        Assert.assertEquals(120_528.25f, burger.getPrice(), 0.001f);
    }

    @Test
    public void getReceipt() {
        Ingredient ingredient1 = new Ingredient(IngredientType.SAUCE, "ketchunez", 10_000.05f);
        Ingredient ingredient2 = new Ingredient(IngredientType.FILLING, "natchinka", 100_500.0f);
        Ingredient ingredient3 = new Ingredient(IngredientType.FILLING, "uffsladkiy", 10_000.0f);
        Bun bun = new Bun("name", 14.1f);
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        burger.addIngredient(ingredient3);
        burger.setBuns(bun);
        String receipt = burger.getReceipt();
        Assert.assertTrue(receipt.contains(bun.getName()));
        Assert.assertTrue(receipt.contains(ingredient1.getName()));
        Assert.assertTrue(receipt.contains(ingredient1.getType().toString().toLowerCase()));
        Assert.assertTrue(receipt.contains(ingredient2.getName()));
        Assert.assertTrue(receipt.contains(ingredient2.getType().toString().toLowerCase()));
        Assert.assertTrue(receipt.contains(ingredient3.getName()));
        Assert.assertTrue(receipt.contains(ingredient3.getType().toString().toLowerCase()));
    }
}