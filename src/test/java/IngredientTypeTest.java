import org.junit.Test;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;

public class IngredientTypeTest {
    @Test
    public void testSauceType() {
        assertEquals("SAUCE", IngredientType.SAUCE.toString());
    }

    @Test
    public void testFillingType() {
        assertEquals("FILLING", IngredientType.FILLING.toString());
    }
}
