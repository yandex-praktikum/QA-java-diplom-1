package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;
import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

@RunWith(Parameterized.class)
public class IngredientParamTypeTest {

    private IngredientType ingredientType;
    private IngredientType expectedType;

    public IngredientParamTypeTest(IngredientType ingredientType, IngredientType expectedType) {
    this.ingredientType = ingredientType;
    this.expectedType = expectedType;
    }

    @Parameterized.Parameters
    public static Object[][] getValue() {
        return new Object[][]{
                {SAUCE, SAUCE},
                {FILLING, FILLING},
        };
    }

    @Test
    public void getIngredientType() {
        Ingredient ingredient = new Ingredient(ingredientType, "Бургер>", 20);
        assertEquals(expectedType, ingredient.getType());
    }
}
