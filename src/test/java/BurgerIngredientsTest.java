import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static praktikum.IngredientType.*;

public class BurgerIngredientsTest {
    Burger burger = new Burger();
    Ingredient firstIngredient = new Ingredient(SAUCE, "Соус кисло-сладкий", 50.0f);
    Ingredient secondIngredient = new Ingredient(FILLING, "Мясо", 500.0f);
    Ingredient thirdIngredient = new Ingredient(SAUCE, "Соус горчичиный", 50.0f);
    public List<Ingredient> initialIngredients = List.of(firstIngredient, secondIngredient, thirdIngredient);

    @Test
    public void checkMoveIngredient() {
        burger.addIngredient(firstIngredient);
        burger.addIngredient(secondIngredient);
        burger.addIngredient(thirdIngredient);
        burger.moveIngredient(0, 2);
        Assert.assertNotEquals(initialIngredients, burger.ingredients);
    }

    @Test
    public void checkRemoveIngredient() {
        burger.addIngredient(firstIngredient);
        burger.addIngredient(secondIngredient);
        burger.addIngredient(thirdIngredient);
        burger.removeIngredient(0);
        Assert.assertNotEquals(initialIngredients, burger.ingredients);
        Assert.assertTrue(burger.ingredients.size() < initialIngredients.size());
    }
}
