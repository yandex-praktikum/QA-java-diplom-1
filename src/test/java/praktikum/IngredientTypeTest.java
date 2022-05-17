package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class IngredientTypeTest {

    private final String ingredientName;
    private final IngredientType ingredientType;

    public IngredientTypeTest(String ingredientName, IngredientType ingredientType) {
        this.ingredientName = ingredientName;
        this.ingredientType = ingredientType;
    }

    @Parameterized.Parameters
    public static Object[][] getTypeName() {
        return new Object[][]{
                {"SAUCE", IngredientType.SAUCE},
                {"FILLING", IngredientType.FILLING}

        };
    }

    @Test
    public void valueOfReturnsCorrectValue() {
        assertEquals(IngredientType.valueOf(ingredientName), ingredientType);
    }
}