package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import static org.junit.Assert.*;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class IngredientParameterizedTest {

    private final IngredientType testType;
    private final IngredientType expected;

    public IngredientParameterizedTest(IngredientType testType, IngredientType expected) {
        this.testType = testType;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Object[][] getIngredientType() {
        return new Object[][] {
                { IngredientType.FILLING, IngredientType.FILLING},
                { IngredientType.SAUCE, IngredientType.SAUCE},
        };
    }

    @Test
    public void ingredientTypeTest() {
        Ingredient ingredient = new Ingredient(testType, "testName1", 10F);
        IngredientType actual = ingredient.getType();
        assertEquals(expected, actual);
    }
}
