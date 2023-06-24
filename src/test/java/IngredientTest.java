import static praktikum.IngredientType.SAUCE;

import org.junit.Assert;
import org.junit.Test;
import praktikum.Ingredient;
import praktikum.IngredientType;

public class IngredientTest {

    @Test
    public void testGetPrice() {
        Ingredient ingredient = new Ingredient(SAUCE, "Sweet-chili", 45.0f);
        float expected = 45.0f;
        float actual = ingredient.getPrice();

        Assert.assertEquals(expected, actual, 0.0f);
    }

    @Test
    public void testGetName() {
        Ingredient ingredient = new Ingredient(SAUCE, "Sweet-chili", 45.0f);
        String expected = "Sweet-chili";
        String actual = ingredient.getName();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetType() {
        Ingredient ingredient = new Ingredient(SAUCE, "Sweet-chili", 45.0f);
        Enum<IngredientType> actual = ingredient.getType();

        Assert.assertEquals(SAUCE, actual);
    }

}
