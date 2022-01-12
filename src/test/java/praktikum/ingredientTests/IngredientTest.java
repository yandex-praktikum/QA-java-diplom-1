package praktikum.ingredientTests;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mock;
import praktikum.Ingredient;
import praktikum.IngredientType;

public class IngredientTest {

    @Mock
    IngredientType ingredientType;

    @Test
    public void getPrice() {
        Ingredient ingredient = new Ingredient(ingredientType, "test", 19);
        Assert.assertEquals(ingredient.getPrice(), 19, 0);
    }

    @Test
    public void getName() {
        Ingredient ingredient = new Ingredient(ingredientType, "test", 19);
        Assert.assertEquals(ingredient.getName(), "test");
    }
}