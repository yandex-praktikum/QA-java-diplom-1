package praktikum;

import junit.framework.TestCase;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Assert;
import org.junit.Test;

import java.util.Random;

public class IngredientTest extends TestCase {

    float price = new Random().nextFloat() * 1000;
    String name = RandomStringUtils.randomAlphabetic(20);
    Ingredient ingredient = new Ingredient(IngredientType.SAUCE, name, price);

    @Test
    public void testTestGetNameIngredient() {
        Assert.assertEquals(name, ingredient.getName());
    }

    @Test
    public void testGetPriceIngredient() {
        Assert.assertEquals(price, ingredient.getPrice(), 0);
    }

    @Test
    public void testGetTypeIngredient() {
        Assert.assertEquals(IngredientType.SAUCE, ingredient.getType());
    }
}
