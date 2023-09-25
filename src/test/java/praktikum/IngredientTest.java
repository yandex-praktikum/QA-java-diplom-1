package praktikum;

import org.junit.Assert;
import org.junit.Test;

public class IngredientTest {
    private final IngredientType ingredientType = IngredientType.SAUCE;
    private final String name = "mayonnaise";
    private final float price = 100F;
    private final Ingredient ingredient = new Ingredient(ingredientType, name, price);
    @Test
    public void getPrice() {
        Assert.assertEquals(price, ingredient.getPrice(), 0);
    }

    @Test
    public void getName() {
        Assert.assertEquals(name, ingredient.getName());
    }

    @Test
    public void getType() {
        Assert.assertEquals(ingredientType, ingredient.getType());
    }
}