package praktikum;

import com.github.javafaker.Faker;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class IngredientTest {
    private final IngredientType TYPE;
    private static Faker faker = new Faker();

    public IngredientTest(IngredientType type) {
        this.TYPE = type;
    }

    @Parameterized.Parameters
    public static Object[][] typeValues() {
        return new Object[][] {
                { IngredientType.FILLING},
                { IngredientType.SAUCE},
        };
    }

    @Test
    public void getNameReturnsCorrectValues() {
        String expectedName = faker.regexify("[A-Za-z]{6}");
        float expectedPrice = faker.number().numberBetween(1,10000);
        IngredientType expectedType = IngredientType.SAUCE;

        Ingredient ingredient = new Ingredient(expectedType, expectedName, expectedPrice);

        String actualName = ingredient.getName();
        assertEquals("Name is not correct: ", expectedName, actualName);
    }

    @Test
    public void getPriceReturnsCorrectValues() {
        String expectedName = faker.regexify("[A-Za-z]{6}");
        float expectedPrice = faker.number().numberBetween(1,10000);
        IngredientType expectedType = IngredientType.FILLING;

        Ingredient ingredient = new Ingredient(expectedType, expectedName, expectedPrice);

        float actualPrice = ingredient.getPrice();
        assertEquals("Price is not correct: ", expectedPrice, actualPrice, 0.1);
    }

    @Test
    public void getTypeReturnsCorrectValues() {
        String expectedName = faker.regexify("[A-Za-z]{6}");
        float expectedPrice = faker.number().numberBetween(1,10000);
        IngredientType expectedType = TYPE;

        Ingredient ingredient = new Ingredient(expectedType, expectedName, expectedPrice);

        IngredientType actualType = ingredient.getType();
        assertEquals("Type is not correct: ", expectedType, actualType);
    }
}
