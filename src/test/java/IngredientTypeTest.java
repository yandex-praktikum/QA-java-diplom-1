import org.junit.Test;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;

public class IngredientTypeTest {

    @Test
    public void orderSauceTest() {
        assertEquals(0, IngredientType.SAUCE.ordinal());
    }

    @Test
    public void orderFillingTest() {
        assertEquals(1, IngredientType.FILLING.ordinal());
    }
}
