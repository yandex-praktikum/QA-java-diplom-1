package praktikum;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class IngredientTypeTest {

    @Test
    public void values() {
        assertEquals("SAUCE", IngredientType.SAUCE.name());
        assertEquals("FILLING", IngredientType.FILLING.name());
    }

    @Test
    public void valueOfIngredientType() {
        IngredientType.valueOf("SAUCE");
        IngredientType.valueOf("FILLING");
    }
}