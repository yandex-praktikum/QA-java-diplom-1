package praktikum;

import org.junit.Assert;
import org.junit.Test;

import static praktikum.IngredientType.SAUCE;

public class IngredientTest {
    Ingredient ingredient = new Ingredient(SAUCE, "майонезик",1000);
    @Test
    public void getPrice() {
        Assert.assertEquals(1000, ingredient.getPrice(),0);
    }
    @Test
    public void getName() {
        Assert.assertEquals("майонезик", ingredient.getName());
    }
    @Test
    public void getType() {
        Assert.assertEquals(SAUCE, ingredient.getType());
    }
}