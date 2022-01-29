package praktikum;

import org.junit.Assert;
import org.junit.Test;

public class IngredientTest {
    @Test
    public void getNameIngredientReturnName() {
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE,"hot sauce", 100);

        String expectedName = "hot sauce";
        String actualName = ingredient.getName();

        Assert.assertEquals(expectedName, actualName);
    }

    @Test
    public void getPriceIngredientReturnPrice() {
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE,"hot sauce", 100);

        float expectedPrice = 100;
        float actualPrice = ingredient.getPrice();

        Assert.assertEquals(actualPrice, expectedPrice, 0);
    }
}
