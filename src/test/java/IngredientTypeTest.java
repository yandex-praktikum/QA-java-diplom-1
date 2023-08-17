import org.junit.Test;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;

public class IngredientTypeTest {

    @Test
    public void testSauceEnum() {
        IngredientType type = IngredientType.SAUCE;
        assertEquals("SAUCE", type.name());
        assertEquals("SAUCE", type.toString());
    }

    @Test
    public void testFillingEnum() {
        IngredientType type = IngredientType.FILLING;
        assertEquals("FILLING", type.name());
        assertEquals("FILLING", type.toString());
    }
}
