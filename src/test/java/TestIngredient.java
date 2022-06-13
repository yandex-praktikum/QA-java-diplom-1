import org.junit.Assert;
import org.junit.Test;
import praktikum.Ingredient;
import praktikum.IngredientType;

import java.util.Arrays;
import java.util.Optional;
import java.util.Random;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;


public class TestIngredient {

    Optional<IngredientType> ingredientType = Arrays.stream(IngredientType.values()).findAny();
    String testName = randomAlphabetic(new Random().nextInt(20));
    Float testPrice = new Random().nextFloat() * 1000;
    Ingredient ingredient = new Ingredient(ingredientType.get(), testName, testPrice);

    @Test
    public void checkName()
    {
        Assert.assertEquals("name is not equal", testName, ingredient.getName());
    }

    @Test
    public void checkPrice()
    {
        Assert.assertEquals("price is not equal", testPrice, ingredient.getPrice(), 0.01F);
    }

    @Test
    public void checkType()
    {
        Assert.assertEquals("type is not equal", ingredientType.get(), ingredient.getType());
    }
}
