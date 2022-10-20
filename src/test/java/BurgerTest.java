import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import praktikum.*;

import java.util.ArrayList;
import java.util.List;

public class BurgerTest {
    @Mock
    Burger burger;
    List<Ingredient> ingredients;
    Ingredient ingredient1;
    Ingredient ingredient2;
    Bun bun;
    Database database;


    @Before
    public void setUp() {
        database = new Database();
        burger = new Burger();
        ingredients = new ArrayList<>();
        ingredient1 = new Ingredient(database.availableIngredients().get(0).type,
                database.availableIngredients().get(0).name, database.availableIngredients().get(0).price);
        ingredient2 = new Ingredient(database.availableIngredients().get(1).type,
                database.availableIngredients().get(1).name, database.availableIngredients().get(1).price);
        bun = database.availableBuns().get(0);
    }

    @Test
    public void testAddIngredient() {
        ingredients.add(ingredient1);
        burger.addIngredient(ingredient1);
        Assert.assertEquals(ingredient1, ingredients.get(0));
    }

    @Test
    public void testRemoveIngredient() {
        ingredients.add(ingredient1);
        burger.addIngredient(ingredient1);
        burger.removeIngredient(0);
        Assert.assertEquals(0, burger.ingredients.size());
    }

    @Test
    public void testMoveIngredient() {
        ingredients.add(ingredient1);
        ingredients.add(ingredient2);
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        burger.moveIngredient(1, 0);
        Assert.assertEquals(ingredient2, burger.ingredients.get(0));
    }

    @Test
    public void testGetPrice() {
        float actual = (bun.getPrice() * 2) + ingredient1.getPrice() + ingredient2.getPrice();
        ingredients.add(ingredient1);
        ingredients.add(ingredient2);
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        burger.setBuns(bun);
        Assert.assertEquals(burger.getPrice(), actual, 0.0f);
    }
}