package praktikum;

import org.junit.Test;

import static org.junit.Assert.*;

public class IngredientTypeTest {

    @Test
    public void testSauceType() {
        assertEquals(IngredientType.SAUCE, IngredientType.valueOf("SAUCE"));
    }

    @Test
    public void testFillingType() {
        assertEquals(IngredientType.FILLING, IngredientType.valueOf("FILLING"));
    }
}