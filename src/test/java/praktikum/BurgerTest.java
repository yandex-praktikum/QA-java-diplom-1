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
        Assert.assertEquals(burger.getPrice(), 600, 0);
        Assert.assertEquals(burger.countLayers(burger.getReceipt()), 3);
        Assert.assertNotNull(burger.getReceipt());
        burger.removeIngredient(0);
    }

    @Test
    public void getBurgerChangeIngredientTest() {
        burger.setBuns(buns.get(1));
        burger.setBuns(buns.get(0));
        burger.addIngredient(ingredients.get(0));
        burger.addIngredient(ingredients.get(1));
        burger.moveIngredient(1, 0);
        Assert.assertEquals(burger.ingredients.get(1).getName(), "hot sauce");
        System.out.println(burger.getReceipt());
    }

    @Test
    public void getBurgerDeleteIngredientTest() {
        burger.setBuns(buns.get(1));
        burger.addIngredient(ingredients.get(0));
        burger.addIngredient(ingredients.get(1));
        burger.removeIngredient(0);
        Assert.assertEquals(burger.countLayers(burger.getReceipt()), 3);
        Assert.assertEquals(burger.ingredients.get(0).getName(), "sour cream");
    }


}
