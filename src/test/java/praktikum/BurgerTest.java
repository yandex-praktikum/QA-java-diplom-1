package praktikum;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;


public class BurgerTest {

    Burger burger;
    List<Ingredient> ingredients;
    Database database;
    List<Bun> buns;

    @Before
    public void initObjects() {
        burger = new Burger();
        database = new Database();
        ingredients = database.availableIngredients();
        buns = database.availableBuns();
    }

    @Test
    public void getBurgerPriceTest() {
        burger.setBuns(buns.get(1));
        burger.addIngredient(ingredients.get(1));
        Assert.assertEquals(600, burger.getPrice(), 0);
        Assert.assertEquals(3, burger.countLayers(burger.getReceipt()));
        Assert.assertNotNull(burger.getReceipt());
    }

    @Test
    public void getBurgerChangeIngredientTest() {
        burger.setBuns(buns.get(1));
        burger.setBuns(buns.get(0));
        burger.addIngredient(ingredients.get(0));
        burger.addIngredient(ingredients.get(1));
        burger.moveIngredient(1, 0);
        Assert.assertEquals("hot sauce", burger.ingredients.get(1).getName());
    }

    @Test
    public void getBurgerDeleteIngredientTest() {
        burger.setBuns(buns.get(1));
        burger.addIngredient(ingredients.get(0));
        burger.addIngredient(ingredients.get(1));
        burger.removeIngredient(0);
        Assert.assertEquals(burger.countLayers(burger.getReceipt()), 3);
        Assert.assertEquals("sour cream", burger.ingredients.get(0).getName());
    }
}
