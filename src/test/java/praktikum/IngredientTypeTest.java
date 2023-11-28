package praktikum;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class IngredientTypeTest {

    @Test
    public void values() {
        int expectedValue = 2;
        assertEquals(expectedValue, IngredientType.values().length);
    }

    @Test
    public void valueOf() {
        IngredientType expectedValue = IngredientType.SAUCE;
        assertEquals(expectedValue, IngredientType.valueOf("SAUCE"));
    }
}