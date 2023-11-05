import org.junit.Test;
import praktikum.IngredientType;
import static org.junit.Assert.assertNotEquals;
public class NegativeIngredientTypeTest {

    @Test
    public void negativeTestSauceType() {
        IngredientType type = IngredientType.SAUCE;
        assertNotEquals("MAYO", type.name());
        assertNotEquals(1, type.ordinal());
    }

    @Test
    public void testFillingType() {
        IngredientType type = IngredientType.FILLING;
        assertNotEquals("MAYO", type.name());
        assertNotEquals(3, type.ordinal());
    }

    @Test
    public void negativeTestValues() {
        IngredientType[] values = IngredientType.values();
        assertNotEquals(3, values.length);
        assertNotEquals(IngredientType.FILLING, values[0]);
        assertNotEquals(IngredientType.SAUCE, values[1]);
    }
}
