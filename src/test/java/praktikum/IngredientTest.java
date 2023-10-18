package praktikum;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;
import static praktikum.IngredientType.FILLING;
import static praktikum.constants.Constants.*;

public class IngredientTest {
    Ingredient ingredient = new Ingredient(FILLING, FILLING_NAME, FILLING_PRICE);

    @Test
    public void getNameSuccess() {
        assertEquals(
                FILLING_NAME,
                ingredient.getName());
    }

    @Test
    public void getPriceSuccess()  {
        Assert.assertTrue(Math.abs(ingredient.getPrice()- FILLING_PRICE) <= 0.00001);
    }

    @Test
    public void getTypeSuccess()  {
        Assert.assertEquals(
                FILLING,
                ingredient.getType());

    }

}

