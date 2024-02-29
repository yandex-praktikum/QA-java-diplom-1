import org.junit.Test;
import praktikum.IngredientType;

import static org.junit.Assert.*;

public class IngredientTypeTest {

    @Test
    public void testExistenceOfEnumValues() {
        assertTrue("IngredientType should contain SAUCE",
                java.util.Arrays.asList(IngredientType.values()).contains(IngredientType.SAUCE));
        assertTrue("IngredientType should contain FILLING",
                java.util.Arrays.asList(IngredientType.values()).contains(IngredientType.FILLING));
    }

    @Test
    public void testNumberOfEnumValues() {
        assertEquals("IngredientType should contain exactly 2 values",
                2, IngredientType.values().length);
    }
}

