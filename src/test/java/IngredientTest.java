import com.github.javafaker.Faker;
import org.junit.Before;
import org.junit.Test;
import praktikum.Ingredient;
import praktikum.IngredientType;

import java.util.Random;

import static org.junit.Assert.assertEquals;

public class IngredientTest {

    Ingredient ingredient = new Ingredient();
    Faker faker = new Faker();
    String expectedNameIngredient = faker.food().ingredient();
    float expectedPriceIngredient = (float) faker.number().randomDouble(2, 1, 1000);
    int ingredientTypeEnum = new Random().nextInt(IngredientType.values().length);
    IngredientType expectedIngredientType = IngredientType.values()[ingredientTypeEnum];

    @Before
    public void setup() {
        ingredient = new Ingredient(expectedIngredientType, expectedNameIngredient, expectedPriceIngredient);
    }

    @Test
    public void getName() {
        assertEquals("Incorrect name bun", expectedNameIngredient, ingredient.getName());

    }

    @Test
    public void getPrice() {
        assertEquals(expectedPriceIngredient, ingredient.getPrice(), 1);

    }

    @Test
    public void getType() {
        assertEquals("Incorrect type ingredient", expectedIngredientType, ingredient.getType());

    }
}
