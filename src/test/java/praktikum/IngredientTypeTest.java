package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class IngredientTypeTest {
    private String type;
    private IngredientType ingredientType;

    public IngredientTypeTest(String type, IngredientType ingredientType) {
        this.type = type;
        this.ingredientType = ingredientType;
    }

    @Parameterized.Parameters
    public static Object[][] dataForTest() {
        return new Object[][] {
                {"SAUCE", IngredientType.SAUCE},
                {"FILLING", IngredientType.FILLING},
        };
    }
    @Test
    public void valueOf() {
        assertEquals(IngredientType.valueOf(type), ingredientType);
    }
}