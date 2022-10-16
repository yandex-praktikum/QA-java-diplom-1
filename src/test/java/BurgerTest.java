import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import java.util.ArrayList;
import java.util.List;

public class BurgerTest {
    @Mock
    Burger burger;
    List<Ingredient> ingredients;
    Ingredient ingredient;
    Bun bun;

    @Before
    public void setUp() {
        burger = new Burger();
        ingredients = new ArrayList<>();
        ingredient = new Ingredient(IngredientType.FILLING, "Sauce", 54);
    }

    @Test
    public void testAddIngredient() {
        ingredients.add(ingredient);
        burger.addIngredient(ingredient);
        Assert.assertEquals(ingredient, ingredients.get(0));
    }

    @Test
    public void testRemoveIngredient() {
        ingredients.add(ingredient);
        burger.addIngredient(ingredient);
        burger.removeIngredient(0);
        Assert.assertEquals(0, burger.ingredients.size());
    }

    @Test
    public void testMoveIngredient() {
        Ingredient ingredient1 = new Ingredient(IngredientType.FILLING, "f", 54);
        Ingredient ingredient2 = new Ingredient(IngredientType.SAUCE, "И", 74);
        ingredients.add(ingredient1);
        ingredients.add(ingredient2);
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        burger.moveIngredient(1, 0);
        Assert.assertEquals(ingredient2, burger.ingredients.get(0));
    }

    @Test
    public void testGetPrice() {
        bun = new Bun("Пончик", 57);
        Ingredient ingredient1 = new Ingredient(IngredientType.FILLING, "f", 54);
        Ingredient ingredient2 = new Ingredient(IngredientType.SAUCE, "И", 74);
        float actual = (bun.getPrice() * 2) + ingredient1.getPrice() + ingredient2.getPrice();
        ingredients.add(ingredient1);
        ingredients.add(ingredient2);
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        burger.setBuns(bun);
        Assert.assertEquals(burger.getPrice(), actual, 0.0f);
    }
}