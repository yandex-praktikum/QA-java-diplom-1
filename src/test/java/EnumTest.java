import org.junit.Test;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;

public class EnumTest {

    @Test
    public void sauceEnumTest() {
        IngredientType ingredientType = IngredientType.SAUCE;
        assertEquals(ingredientType.valueOf("SAUCE"), ingredientType);
    }

    @Test
    public void fillingEnumTest() {
        IngredientType ingredientType = IngredientType.FILLING;
        assertEquals(ingredientType.valueOf("FILLING"), ingredientType);
    }
}
