package praktikum;

import org.junit.Assert;
import org.junit.Test;

public class IngredientTest {
    private Ingredient testIngredient = new Ingredient(IngredientType.SAUCE, "яблочный уксус", 33.33F);
    private IngredientType expectedType = IngredientType.SAUCE;
    private float expectedPrice = 33.33F;
    private String expectedName = "яблочный уксус";

    @Test
    public void getNameTest() {
        Assert.assertEquals(expectedName, testIngredient.getName());
    }

    @Test
    public void getPriceTest() {
        Assert.assertEquals(expectedPrice, testIngredient.getPrice(), 0);
    }

    @Test
    public void getTypeTest() {
        Assert.assertEquals(expectedType, testIngredient.getType());
    }
}
