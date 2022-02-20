package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class IngredientParameterizationTest {
    @Mock
    float priceMock;
    String nameMock;

    private final String expected;
    IngredientType ingredientType;

    public IngredientParameterizationTest(IngredientType ingredientType, String expected) {
        this.ingredientType = ingredientType;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Object[][] getIngredientType() {
        return new Object[][] {
                {IngredientType.SAUCE, "SAUCE"},
                {IngredientType.FILLING, "FILLING"},
        };
    }

    @Test
    public void doesHaveManeTrueResult() {
        Ingredient ingredient = new Ingredient(ingredientType, nameMock, priceMock);
        assertEquals(expected, ingredient.getType().toString());
    }
}
