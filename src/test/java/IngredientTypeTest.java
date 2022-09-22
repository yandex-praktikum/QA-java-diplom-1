import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class IngredientTypeTest {
    private Ingredient ingredient;
    private String expectedType;

    public IngredientTypeTest(Ingredient ingredient, String expectedType) {
        this.ingredient = ingredient;
        this.expectedType = expectedType;
    }

    @Parameterized.Parameters
    public static Object[][] checkIngredientType() {
        return new Object[][]{
                {new Ingredient(IngredientType.SAUCE, "chili sauce", 300), "SAUCE"},
                {new Ingredient(IngredientType.FILLING, "cutlet", 100), "FILLING"}
        };
    }

    @Test
    public void getIngredientTypeTest() {
        String actual = String.valueOf(ingredient.getType());
        assertEquals("Method incorrect", expectedType, actual);
    }
}
