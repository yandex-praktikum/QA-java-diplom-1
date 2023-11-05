import org.junit.Test;
import praktikum.IngredientType;
import static org.junit.Assert.assertEquals;

public class IngredientTypeTest {
    @Test
    public void testSauceType() {
        IngredientType type = IngredientType.SAUCE;
        assertEquals("SAUCE", type.name());
        assertEquals(0, type.ordinal());
    }

    @Test
    public void testFillingType() {
        IngredientType type = IngredientType.FILLING;
        assertEquals("FILLING", type.name());
        assertEquals(1, type.ordinal());
    }

    @Test
    public void testValues() {
        IngredientType[] values = IngredientType.values();
        assertEquals(2, values.length);
        assertEquals(IngredientType.SAUCE, values[0]);
        assertEquals(IngredientType.FILLING, values[1]);
    }

}

