import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.Test;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;
@RunWith(Parameterized.class)
public class IngredientTypeParametrizedTest {
    private final String expected;
    private final IngredientType actual;


    public IngredientTypeParametrizedTest(String expected, IngredientType actual) {
        this.expected = expected;
        this.actual = actual;
    }

    @Parameterized.Parameters
    public static Object[][] getSumData() {
        return new Object[][] {
                { "SAUCE", IngredientType.SAUCE},
                { "FILLING", IngredientType.FILLING},
        };
    }

    @Test
    public void ingredientTypeTest() {
        assertEquals(expected, actual.toString());
    }
}
