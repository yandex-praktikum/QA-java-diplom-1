package praktikum;

import org.junit.Assert;
import org.junit.Test;

public class IngredientTest {
    @Test
    public void getNameTest() {
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "test", 78);
        Assert.assertEquals("test", ingredient.getName());
    }

    @Test
    public void getPriceTest() {
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "test", 78);
        Assert.assertEquals(78, ingredient.getPrice(), 1);
    }

    @Test
    public void getTypeTest() {
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "test", 78);
        Assert.assertEquals(IngredientType.SAUCE, ingredient.getType());
    }
}
