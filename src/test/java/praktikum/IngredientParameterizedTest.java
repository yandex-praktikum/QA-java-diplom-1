package praktikum;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class IngredientParameterizedTest {
    private final IngredientType ingredientType;
    private final String expected;
    private Ingredient ingredient;

    public IngredientParameterizedTest (IngredientType ingredientType, String expected) {
        this.ingredientType = ingredientType;
        this.expected = expected;
    }

    @Parameterized.Parameters(name = "getType(), should be: {1}")
    public static Object [][] getTestData() {
        return new Object[][] {
                {IngredientType.SAUCE, "SAUCE"},
                {IngredientType.FILLING, "FILLING"}
        };
    }

    @Before
    public void setup() {
        ingredient = new Ingredient(ingredientType, "Cheese", 1f);
    }

    @Test
    public void getTypeTest() {
        String result = ingredient.getType().toString();
        Assert.assertEquals(expected, result);
    }
}
