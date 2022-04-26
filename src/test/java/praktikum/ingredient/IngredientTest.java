package praktikum.ingredient;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Assert;
import org.junit.Test;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.apache.commons.lang3.RandomUtils.nextFloat;

public class IngredientTest {

    @Test
    public void methodGetNameShouldReturnSameName() {
        String name = RandomStringUtils.randomAlphabetic(10);
        float price = nextFloat();

        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, name, price);
        Assert.assertEquals(name, ingredient.getName());
    }

    @Test
    public void methodGetPriceShouldReturnSamePrice() {
        String name = RandomStringUtils.randomAlphabetic(10);
        float price = nextFloat();

        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, name, price);
        Assert.assertEquals(price, ingredient.getPrice(), 0.001);
    }
}
