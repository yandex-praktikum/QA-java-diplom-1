package praktikum;

import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class IngredientTypeTest {
    @Test
    public void testIngredientType() {
        for (IngredientType type : IngredientType.values()) {
            assertNotNull(type);
        }
    }
}