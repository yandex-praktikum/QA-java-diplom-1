import org.junit.Test;
import praktikum.IngredientType;

import static org.junit.Assert.assertSame;

public class IngredientTypeTest {

    @Test
    public void testEnumValues() {
        assertSame("Enum should contain SAUCE.", IngredientType.valueOf("SAUCE"), IngredientType.SAUCE);
        assertSame("Enum should contain FILLING.", IngredientType.valueOf("FILLING"), IngredientType.FILLING);
    }
}
