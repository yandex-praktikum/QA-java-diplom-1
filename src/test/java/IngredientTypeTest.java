import org.junit.Test;
import praktikum.IngredientType;

import static org.junit.Assert.assertNotNull;

public class IngredientTypeTest {
    @Test
    public void testSauceNotNull() {
        assertNotNull("How about some sauce in your burger?", IngredientType.SAUCE);
    }

    @Test
    public void testFillingNotNull() {
        assertNotNull("Come on! You're not going to eat a burger without fillings, are you?", IngredientType.FILLING);
    }
}