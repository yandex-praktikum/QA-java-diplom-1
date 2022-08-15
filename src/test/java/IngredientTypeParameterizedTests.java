import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;
import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

@RunWith(Parameterized.class)
public class IngredientTypeParameterizedTests {
    private final IngredientType expected;
    private final IngredientType actual;

    public IngredientTypeParameterizedTests(IngredientType expected, IngredientType actual) {
        this.expected = expected;
        this.actual = actual;
    }


    @Parameterized.Parameters(name = "{0}, {1}")
    public static Object[][] ingredientType() {
        return new Object[][]{
                {SAUCE, SAUCE},
                {FILLING, FILLING},
        };
    }
    @Test
    public void IngredientTypeTest() {
        assertEquals(expected, actual);
    }
}