import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Database;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;
import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

@RunWith(Parameterized.class)
public class IngredientTypeTest {

    private final IngredientType exampleType;
    private final IngredientType expectedType;

    public IngredientTypeTest(IngredientType exampleType, IngredientType expectedType) {
        this.exampleType = exampleType;
        this.expectedType = expectedType;
    }

    @Parameterized.Parameters(name = "тестовые данные {0}, {1}")
    public static Object[][] getIngredientTypeData() {
        Database database = new Database();
        return new Object[][]{
                {database.availableIngredients().get(0).getType(), SAUCE},
                {database.availableIngredients().get(2).getType(), SAUCE},
                {database.availableIngredients().get(3).getType(), FILLING},
                {database.availableIngredients().get(5).getType(), FILLING},
        };
    }

    @Test
    public void IngredientTypeTest() {
        Ingredient ingredient = new Ingredient(exampleType, "abc ingr", 100);

        IngredientType actualType = ingredient.getType();

        assertEquals(expectedType, actualType);

    }
}
