package praktikum;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class IngredientTypeTest {

    @Test
    public void allValuesIncluded() {
        assertNotNull(IngredientType.valueOf("SAUCE"));
        assertNotNull(IngredientType.valueOf("FILLING"));
    }

    @Test
    public void enumerableLengthCorrect() {
        assertEquals(2, IngredientType.values().length);
    }

}
