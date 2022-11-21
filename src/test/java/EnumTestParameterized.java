import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class EnumTestParameterized {

    private IngredientType type;

    private String expected;

    public EnumTestParameterized(IngredientType type, String expected) {
        this.type = type;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Object[][] ingredientData() {
        return new Object[][]{
                { IngredientType.FILLING, "FILLING"},
                { IngredientType.SAUCE, "SAUCE" }
        };
    }

    @Test
    public void sauceEnumTest() {
        IngredientType ingredientType = type;
        assertEquals(ingredientType.valueOf(expected), ingredientType);
    }
}
