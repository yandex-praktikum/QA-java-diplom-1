package praktikum;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

public class IngredientTypeTest {
    IngredientType[] expectedResult = {SAUCE, FILLING};
    IngredientType[] actualResult;

    @Test
    public void testValues() {
        actualResult = IngredientType.values();
        assertEquals(expectedResult, actualResult);

    }

    @Test
    public void testValueOf() {
        assertEquals(SAUCE, IngredientType.valueOf("SAUCE"));
        assertEquals(FILLING, IngredientType.valueOf("FILLING"));
    }
}


