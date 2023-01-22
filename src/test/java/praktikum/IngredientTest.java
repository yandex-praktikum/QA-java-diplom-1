package praktikum;

import org.junit.Assert;
import org.junit.Test;

public class IngredientTest {

    @Test
    public void getPriceTest() {
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "hot sauce", 100);
        float expected = 100;
        float actual = ingredient.getPrice();
        Assert.assertEquals(expected, actual, 0.0);
    }

    @Test
    public void getNameTest() {
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "chili sauce", 300);
        String expected = "chili sauce";
        String actual = ingredient.getName();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getTypeTest() {
        Ingredient ingredient = new Ingredient(IngredientType.FILLING, "dinosaur", 200);
        IngredientType expected = IngredientType.FILLING;
        IngredientType actual = ingredient.getType();
        Assert.assertEquals(expected, actual);
    }

}
