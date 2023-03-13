package praktikum;

import org.junit.Assert;
import org.junit.Test;

public class TestIngredients {
    public IngredientType expectedType = IngredientType.SAUCE;
    public String expectedName = "test_name";
    public float expectedPrice = 12.90F;
    Ingredient testIngredient = new Ingredient(expectedType, expectedName, expectedPrice);

    @Test
    public void checkIngredientGetName() {
        Assert.assertEquals(expectedName, testIngredient.getName());
    }

    @Test
    public void checkIngredientGetPrice() {
        Assert.assertEquals(expectedPrice, testIngredient.getPrice(), 0.0F);
    }

    @Test
    public void checkIngredientGetType() {
        Assert.assertEquals(expectedType, testIngredient.getType());
    }
}
