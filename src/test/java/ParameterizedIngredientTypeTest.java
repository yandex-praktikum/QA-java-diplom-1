import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class )
public class ParameterizedIngredientTypeTest {
    private final String ingredient;
    private final IngredientType expected;

    public ParameterizedIngredientTypeTest(String ingredient, IngredientType type) {
        this.ingredient = ingredient;
        this.expected = type;
    }

    @Parameterized.Parameters
    public static Object[][] getData() {
        return new Object[][]{
                {"SAUCE", IngredientType.SAUCE},
                {"FILLING", IngredientType.FILLING},
        };
    }

    @Test
    public void ingredientTypeReturnsCorrectType() {
        IngredientType actual = IngredientType.valueOf(ingredient);

        assertEquals("Returns incorrect ingredient type", expected, actual);
    }
}
