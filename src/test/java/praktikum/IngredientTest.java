package praktikum;

import com.github.javafaker.Faker;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class IngredientTest {
    Ingredient ingredient;
    String testName;
    float testPrice;
    Faker faker;



    @Before
    public void setUp() {
        Database database = new Database();
        final List<Ingredient> ingredients = database.availableIngredients();

        faker = new Faker();
        ingredient = ingredients.get(0);//new Ingredient(IngredientType.SAUCE, testName, testPrice);
    }

    @Test
    public void getPriceShouldReturnCorrectPrice() {
        float expectedValue = 100;
        assertEquals(expectedValue, ingredient.getPrice(), 0.0);
    }

    @Test
    public void getNameShouldReturnCorrectName() {
        String expectedValue = "hot sauce";
        assertEquals(expectedValue, ingredient.getName());
    }
}