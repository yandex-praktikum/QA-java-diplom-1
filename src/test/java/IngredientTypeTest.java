import org.junit.Test;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;

public class IngredientTypeTest {
    public static final String SAUCE = "SAUCE";
    public static final String FILLING = "FILLING";

    @Test
    public void sauceTest() {
        assertEquals(SAUCE, IngredientType.SAUCE.toString());
    }

    @Test
    public void fillingTest() {
        assertEquals(FILLING, IngredientType.FILLING.toString());
    }
}
