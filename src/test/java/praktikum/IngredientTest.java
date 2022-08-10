package praktikum;

import com.github.javafaker.Faker;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class IngredientTest {

    Ingredient ingredient;
    String testName;
    float testPrice;
    Faker faker;

    @Before
    public void setUp() {
        faker = new Faker();
        testName = faker.name().firstName();
        testPrice = faker.number().numberBetween(1, 888);
        ingredient = new Ingredient(IngredientType.SAUCE, testName, testPrice);
    }

    @Test
    public void getPriceShouldReturnCorrectPrice() {
        float expectedValue = testPrice;
        assertEquals(expectedValue, ingredient.getPrice(), 0.0);
    }

    @Test
    public void getNameShouldReturnCorrectName() {
        String expectedValue = testName;
        assertEquals(expectedValue, ingredient.getName());
    }

    @Test
    public void getTypeShouldReturnCorrectIngredientTypeSauce() {
        assertEquals(IngredientType.SAUCE, ingredient.getType());
    }
}