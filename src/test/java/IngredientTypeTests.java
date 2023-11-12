import org.junit.Test;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;

public class IngredientTypeTests {

    @Test
    public void ingredientTypesTests() {
        assertEquals(2, IngredientType.values().length);

        assertEquals(IngredientType.SAUCE, IngredientType.valueOf("SAUCE"));
        assertEquals(IngredientType.FILLING, IngredientType.valueOf("FILLING"));
    }
}