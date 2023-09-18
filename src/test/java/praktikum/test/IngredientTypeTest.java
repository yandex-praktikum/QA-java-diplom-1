package praktikum.test;

import org.junit.Test;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;

public class IngredientTypeTest {
    private String SAUCE = "SAUCE";
    private String FILLING = "FILLING";

    @Test
    public void testSauceEnumValue() {
        IngredientType sauce = IngredientType.SAUCE;
        assertEquals(SAUCE, sauce.name());
    }

    @Test
    public void testFillingEnumValue() {
        IngredientType filling = IngredientType.FILLING;
        assertEquals(FILLING, filling.name());
    }
}
