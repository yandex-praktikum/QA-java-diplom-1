package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;
import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

@RunWith(Parameterized.class)
public class IngredientGetTypeParameterizedTest {


    private final IngredientType expected;
    private final Ingredient ingredient;

    public IngredientGetTypeParameterizedTest(Ingredient ingredient,
                                              IngredientType expected) {
        this.ingredient = ingredient;
        this.expected = expected;
    }


    @Parameterized.Parameters
    public static Object[][] getData() {
        return new Object[][]{
                {new Ingredient(SAUCE, "barbecue", 111), SAUCE},
                {new Ingredient(FILLING, "meat", 222), FILLING}
        };
    }

    @Test
    public void getTypeTest() {

//        IngredientType actual = ingredient.getType();
        assertEquals("ingredient type is correct", expected, ingredient.getType());
    }
}