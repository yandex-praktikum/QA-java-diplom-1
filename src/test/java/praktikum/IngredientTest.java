package praktikum;

import org.junit.Assert;
import org.junit.Test;

public class IngredientTest {
    private Ingredient testIngredient = new Ingredient(IngredientType.SAUCE, "яблочный уксус", 33.33F);

    @Test
    public void getNameTest() {
        Assert.assertEquals("яблочный уксус", testIngredient.getName());
    }

    @Test
    public void getPriceTest() {
        Assert.assertEquals(33.33F, testIngredient.getPrice(), 0);
    }

    @Test
    public void getTypeTest() {
        Assert.assertEquals(IngredientType.SAUCE, testIngredient.getType());
    }
}
