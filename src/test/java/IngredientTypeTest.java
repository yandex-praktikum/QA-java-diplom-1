import org.junit.Test;
import praktikum.IngredientType;

import static org.junit.Assert.*;


public class IngredientTypeTest {
    @Test
    public void testEnum() {
        assertNotNull(IngredientType.SAUCE);
        assertNotNull(IngredientType.FILLING);
    }
}
