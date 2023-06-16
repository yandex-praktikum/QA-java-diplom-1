package praktikum;

import org.junit.Assert;
import org.junit.Test;
import praktikum.Ingredient;
import praktikum.IngredientType;

public class IngredientTest {

    Ingredient defaultIngredient = new Ingredient(IngredientType.FILLING, "Томат", 230);


    @Test
    public void getPricePositiveTest() {
        Assert.assertEquals(230.0, defaultIngredient.getPrice(), 0);
    }

    @Test
    public void getPriceNegativeTest() {
        Assert.assertNotEquals(50.0, defaultIngredient.getPrice(), 0);
    }

    @Test
    public void getNamePositiveTest() {
        Assert.assertEquals("Томат", defaultIngredient.getName());
    }

    @Test
    public void getNameNegativeTest() {
        Assert.assertNotEquals("Помидор", defaultIngredient.getName());
    }

    @Test
    public void getTypePositiveTest() {
        Assert.assertEquals(IngredientType.FILLING, defaultIngredient.getType());
    }

    @Test
    public void getTypeNegativeTest() {
        Assert.assertNotEquals(IngredientType.SAUCE, defaultIngredient.getType());
    }

}