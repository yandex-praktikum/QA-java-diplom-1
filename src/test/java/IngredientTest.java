import org.junit.Assert;
import org.junit.Test;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static praktikum.IngredientType.SAUCE;

public class IngredientTest {
    Ingredient ingredient = new Ingredient(SAUCE, "Кетчунез", 100.00f);

    @Test
    public void getPriceTest() {
        float expectedPrice = 100.00f;
        float actualPrice = ingredient.getPrice();
        Assert.assertEquals(expectedPrice, actualPrice, 0);
    }

    @Test
    public void getNameTest() {
        String expectedName = "Кетчунез";
        String actualName = ingredient.getName();
        Assert.assertEquals(expectedName, actualName);
    }

    @Test
    public void getTypeTest() {
        String expectedType = String.valueOf(IngredientType.SAUCE);
        String actualType = String.valueOf(ingredient.getType());
        Assert.assertEquals(expectedType, actualType);
    }
}
