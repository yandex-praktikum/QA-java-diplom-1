package praktikum;

import org.junit.Assert;
import org.junit.Test;

public class IngredientTest {
    @Test
    public void getPrice() {
        float expected = 1;
        IngredientType type = IngredientType.SAUCE;
        Ingredient ingredient = new Ingredient(type, "name", expected);
        Assert.assertEquals(expected, ingredient.getPrice(), 0.0);
    }

    @Test
    public void getName() {
        String expected = "name";
        IngredientType type = IngredientType.SAUCE;
        Ingredient ingredient = new Ingredient(type, expected, 1);
        Assert.assertEquals(expected, ingredient.getName());
    }

    @Test
    public void getType() {
        IngredientType expected = IngredientType.SAUCE;
        Ingredient ingredient = new Ingredient(expected, "name", 1);
        Assert.assertEquals(expected, ingredient.getType());
    }
}