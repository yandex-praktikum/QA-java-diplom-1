package praktikum;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.ThreadLocalRandom;

import static org.junit.Assert.assertEquals;

public class IngredientTest {

    Ingredient ingredient;
    IngredientType[] ingredientTypes = IngredientType.values();
    IngredientType randomIngredientType = ingredientTypes[ThreadLocalRandom.current().nextInt(1, 2)];
    String randomName = RandomStringUtils.randomAlphabetic(5);
    float randomPrice = ThreadLocalRandom.current().nextFloat();

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
