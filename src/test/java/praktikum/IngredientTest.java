package praktikum;

import org.junit.Assert;
import org.junit.Test;


public class IngredientTest {

    Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "hot sauce", 100);

    @Test
    public void getPrice() {
        Assert.assertEquals(100, ingredient.getPrice(),0);
    }

    @Test
    public void getName() {
        Assert.assertEquals("hot sauce", ingredient.getName());
    }

    @Test
    public void getType() {
        Assert.assertEquals(IngredientType.SAUCE, ingredient.getType());
    }
}
