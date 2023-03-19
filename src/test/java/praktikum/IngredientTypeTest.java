package praktikum;

import org.junit.Test;

import static org.junit.Assert.*;

public class IngredientTypeTest {

    @Test
    public void values() {
        assertEquals(new IngredientType[]{IngredientType.SAUCE, IngredientType.FILLING}, IngredientType.values());
    }

    @Test
    public void valueOf() {
        assertEquals(IngredientType.SAUCE, IngredientType.valueOf("SAUCE"));
        assertEquals(IngredientType.FILLING, IngredientType.valueOf("FILLING"));
    }
}