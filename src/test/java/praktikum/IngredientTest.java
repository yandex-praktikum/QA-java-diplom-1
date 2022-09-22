package praktikum;

import org.junit.Assert;
import org.junit.Test;

public class IngredientTest {
    IngredientType ingredientType;
    Ingredient ingredient = new Ingredient(ingredientType.SAUCE, "chili sauce", 100);

    @Test
    public void getName() {
        Assert.assertEquals("chili sauce", ingredient.getName());
    }

    @Test
    public void getPrice() {
        Assert.assertEquals(100, ingredient.getPrice(), 0);
    }

    @Test
    public void getType() {
        Assert.assertEquals(ingredientType.SAUCE, ingredient.getType());
    }
}