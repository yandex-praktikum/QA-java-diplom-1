import org.junit.Test;
import praktikum.IngredientType;

import static org.junit.Assert.assertNotNull;

public class IngredientTypeTest {
    @Test
    public void testIngredientTypeSauce() {
        assertNotNull(IngredientType.valueOf("FILLING"));
    }

    @Test
    public void testIngredientTypeFilling() {
        assertNotNull(IngredientType.valueOf("SAUCE"));
    }
}