import org.junit.Test;
import praktikum.IngredientType;

import static org.junit.Assert.assertNotNull;

public class IngredientTypeTest {
    @Test
    public void values() {
        assertNotNull(IngredientType.FILLING);
        assertNotNull(IngredientType.SAUCE);
    }
}
