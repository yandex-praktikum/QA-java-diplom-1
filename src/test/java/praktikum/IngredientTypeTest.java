package praktikum;

import org.junit.Test;

import static org.junit.Assert.*;

public class IngredientTypeTest {

    @Test
    public void values() {
        IngredientType[] values = IngredientType.values();
        assertEquals(2, values.length);
        assertEquals(IngredientType.SAUCE, values[0]);
        assertEquals(IngredientType.FILLING, values[1]);
    }
}