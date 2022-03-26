package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class IngredientGetTypeParameterizedTest {


    private final IngredientType expected;
    Ingredient ingredient;

    public IngredientGetTypeParameterizedTest(Ingredient ingredient, IngredientType expected) {
        this.ingredient = ingredient;
        this.expected = expected;
    }


    @Parameterized.Parameters
    public static Object[][] getData() {
        return new Object[][]{
                {new Ingredient(IngredientType.SAUCE, "Ann", 12), IngredientType.SAUCE},
                {new Ingredient(IngredientType.FILLING, "Ann", 12), IngredientType.FILLING}
        };
    }

    @Test
    public void getTypeTest() {

        IngredientType actual = ingredient.getType();
        assertEquals("ingredient type is correct", expected, actual);
    }
}
