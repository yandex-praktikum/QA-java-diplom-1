package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class IngredientTypeTests {
    private final IngredientType ingredientType;
    private final String name;

    public IngredientTypeTests(IngredientType ingredientType, String name) {
        this.ingredientType = ingredientType;
        this.name = name;
    }

    @Parameterized.Parameters
    public static Object[][] setIngredientType() {
        return new Object[][] {
                {IngredientType.SAUCE, "SAUCE"},
                {IngredientType.FILLING, "FILLING"}
        };
    }

    @Test
    public void testGetIngredientType() {
        assertEquals(ingredientType, IngredientType.valueOf(name));
    }
}
