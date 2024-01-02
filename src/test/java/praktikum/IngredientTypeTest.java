package praktikum;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class IngredientTypeTest {

    @Test
    public void testIngredientTypeSauce() {
        assertEquals("SAUCE", IngredientType.SAUCE.name());
    }

    @Test
    public void testIngredientTypeFilling() {
        assertEquals("FILLING", IngredientType.FILLING.name());
    }
}