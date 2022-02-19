package praktikum;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class IngredientTypeTest {

    @Test
    public void testSauceValue() {
        assertEquals("SAUCE", IngredientType.SAUCE.toString());
    }

    @Test
    public void testFillingValue() {
        assertEquals("FILLING", IngredientType.FILLING.toString());
    }
}