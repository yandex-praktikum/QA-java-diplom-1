import org.junit.Test;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;

public class IngredientTypeTest {
    @Test
    public void filling() {
        IngredientType filling = IngredientType.FILLING;
        assertEquals(IngredientType.FILLING, filling);
    }

    @Test
    public void sauce() {
        IngredientType sauce = IngredientType.SAUCE;
        assertEquals(IngredientType.SAUCE, sauce);
    }

}
