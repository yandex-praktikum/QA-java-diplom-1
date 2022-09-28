package praktikum.ingredient;

import com.github.javafaker.Faker;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class GetTypeTest {
    private final IngredientType TYPE;
    private static Faker faker = new Faker();

    public GetTypeTest(IngredientType type) {
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
    public void getTypeReturnsCorrectValues() {
        String expectedName = faker.regexify("[A-Za-z]{6}");
        float expectedPrice = faker.number().numberBetween(1,10000);
        IngredientType expectedType = TYPE;

        Ingredient ingredient = new Ingredient(expectedType, expectedName, expectedPrice);

        IngredientType actualType = ingredient.getType();
        assertEquals("Type is not correct: ", expectedType, actualType);
    }
}
