import org.junit.Assert;
import org.junit.Test;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static praktikum.IngredientType.SAUCE;

public class IngredientTest {
    @Test
    public void getPriceTest() {
        Ingredient ingredient = new Ingredient(SAUCE, "hot sauce", 100);
        float price = ingredient.getPrice();
        Assert.assertEquals(price, 100, TestConstants.delta);
    }

    @Test
    public void getNameTest() {
        Ingredient ingredient = new Ingredient(SAUCE, "hot sauce", 100);
        String name = ingredient.getName();
        Assert.assertEquals(name, "hot sauce");
    }

    @Test
    public void getTypeTest() {
        Ingredient ingredient = new Ingredient(SAUCE, "hot sauce", 100);
        IngredientType type = ingredient.getType();
        Assert.assertEquals(type, SAUCE);
    }
}