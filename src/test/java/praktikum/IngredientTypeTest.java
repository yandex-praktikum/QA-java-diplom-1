package praktikum;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class IngredientTypeTest {

    @Test
    public void valueFilling() {
        assertEquals("FILLING", IngredientType.FILLING.name());
    }

    @Test
    public void valueSauce() {
        assertEquals("SAUCE", IngredientType.SAUCE.name());
    }
}