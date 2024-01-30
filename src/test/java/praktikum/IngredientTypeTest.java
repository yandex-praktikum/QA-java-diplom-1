package praktikum;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

public class IngredientTypeTest {

    @Test
    public void enumIngredientIsValidTest() {
        assertEquals(SAUCE, IngredientType.valueOf("SAUCE"));
        assertEquals(FILLING, IngredientType.valueOf("FILLING"));
    }
}