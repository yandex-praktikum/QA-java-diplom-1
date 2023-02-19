import org.junit.Test;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

/**
 * Тесты, покрывающие класс IngredientType
 *
 * @see IngredientType
 */
public class IngredientTypeTest {
    @Test
    public void checkValuesCount() {
        assertEquals(IngredientType.values().length, 2);
    }

    @Test
    public void checkSauceAvailability() {
        assertEquals(IngredientType.SAUCE, IngredientType.valueOf("SAUCE"));
    }

    @Test
    public void checkFillingAvailability() {
        assertEquals(IngredientType.FILLING, IngredientType.valueOf("FILLING"));
    }

    @Test
    public void exceptionWithMissingValue() {
        assertThrows(IllegalArgumentException.class, () -> IngredientType.valueOf("WRONG"));
    }
}