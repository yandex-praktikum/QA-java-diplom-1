package praktikum;

import org.junit.Assert;
import org.junit.Test;

public class IngredientTest {

    @Test
    public void testGetters() {
        IngredientType sauce = IngredientType.SAUCE;
        String name = "Соус";
        float price = 1.0f;
        Ingredient ingredient = new Ingredient(sauce, name, price);
        Assert.assertEquals(sauce, ingredient.getType());
        Assert.assertEquals(name, ingredient.getName());
        Assert.assertEquals(price, ingredient.getPrice(), 0.0001f);

        IngredientType filling = IngredientType.FILLING;
        ingredient.type = filling;
        Assert.assertEquals(filling, ingredient.getType());
    }
}