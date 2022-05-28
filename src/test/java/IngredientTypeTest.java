import org.junit.Test;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;
import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

public class IngredientTypeTest {

    @Test
    public void sauceIngredientTypeTest() {
        assertEquals(SAUCE, IngredientType.valueOf("SAUCE"));
    }

    @Test
    public void fillingIngredientTypeTest() {
        assertEquals(FILLING, IngredientType.valueOf("FILLING"));
    }

    @Test(expected = Exception.class)
    public void nullIngredientTypeTest () {
        assertEquals(null, IngredientType.valueOf(null));
    }
}
