package praktikum;

import org.junit.Assert;
import org.junit.Test;



public class IngredientTest {

    Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "hot sauce", 100);
    @Test
    public void getPriceTest() {

        float expected = 100;
        float actual = ingredient.getPrice();
        Assert.assertEquals(expected,actual,0);

    }

    @Test
    public void getNameTest() {
        String expected = "hot sauce";
        String actual = ingredient.getName();
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void getTypeTest() {
        IngredientType expected = IngredientType.SAUCE;
        IngredientType actual = ingredient.getType();
        Assert.assertEquals(expected,actual);
    }
}