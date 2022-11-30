package Ingredient;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;
import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

@RunWith(Parameterized.class)
public class IngredientTypeTest {

    private final IngredientType ingredientType;
    private final IngredientType expected;

    public IngredientTypeTest(IngredientType ingredientType, IngredientType expected) {
        this.ingredientType = ingredientType;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Object[][] ingredientTypeParam() {
        return new Object[][] {
                {SAUCE, SAUCE},
                {FILLING, FILLING}
        };
    }

    @Test
    public void getIngredientType() {
        Ingredient ingredient = new Ingredient(ingredientType, "beef", 0.5f);
        IngredientType actual = ingredient.getType();
        assertEquals("Данные не совпадают", expected, actual);
    }
}
