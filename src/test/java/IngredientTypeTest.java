import org.junit.Test;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;

public class IngredientTypeTest {

    @Test
    public void numIngredientTypeTest () {
        final int NUM_TYPE = 2;
        assertEquals(NUM_TYPE, IngredientType.values().length);
        assertEquals(IngredientType.valueOf("SAUCE"), IngredientType.SAUCE);
        assertEquals(IngredientType.valueOf("FILLING"), IngredientType.FILLING);
    }
}
