package practicum;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Before;
import org.junit.Test;
import praktikum.Ingredient;
import praktikum.IngredientType;

import java.util.concurrent.ThreadLocalRandom;

import static org.junit.Assert.assertEquals;

public class IngredientTest {
    IngredientType[] ingredientTypes = IngredientType.values();
    IngredientType randomIngredientType = ingredientTypes[ThreadLocalRandom.current().nextInt(1, 2)];
    String randomName = RandomStringUtils.randomAlphabetic(10);
    float randomPrice = ThreadLocalRandom.current().nextFloat();
    Ingredient ingredient;

    @Before
    public void setUp() {
        ingredient = new Ingredient(randomIngredientType, randomName, randomPrice);
    }

    @Test
    public void getNameShouldReturnValidName() {
        assertEquals(randomName, ingredient.getName());
    }

    @Test
    public void getPriceShouldReturnValidPrice() {
        assertEquals(randomPrice, ingredient.getPrice(), 0);
    }

    @Test
    public void getTypeShouldReturnValidType() {
        assertEquals(randomIngredientType, ingredient.getType());
    }
}