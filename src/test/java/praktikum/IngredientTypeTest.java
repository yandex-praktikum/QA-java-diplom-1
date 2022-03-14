package praktikum;

import org.junit.Test;

import static org.junit.Assert.*;

public class IngredientTypeTest {

    @Test
    public void valuesCheck() {
        IngredientType expected [] = IngredientType.values();
        assertEquals(IngredientType.values(), expected);
    }

    @Test
    public void valueOfCheck() {
        IngredientType expected = IngredientType.SAUCE;
        assertEquals(IngredientType.valueOf("SAUCE"), expected);
    }
}