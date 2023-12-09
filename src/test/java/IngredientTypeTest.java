

import org.junit.Test;
import praktikum.IngredientType;

import static org.junit.Assert.assertTrue;

public class IngredientTypeTest {

    @Test
    public void testEnumValues() {
        assertTrue("Enum should contain SAUCE.", IngredientType.valueOf("SAUCE") == IngredientType.SAUCE);
        assertTrue("Enum should contain FILLING.", IngredientType.valueOf("FILLING") == IngredientType.FILLING);
    }
}
