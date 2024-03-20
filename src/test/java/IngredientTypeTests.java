import org.junit.Test;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;

public class IngredientTypeTests {
    @Test
    public void sauceTest() {
        assertEquals("SAUCE", IngredientType.SAUCE.toString());
    }

    @Test
    public void fillingTest() {
        assertEquals("FILLING", IngredientType.FILLING.toString());
    }
}
