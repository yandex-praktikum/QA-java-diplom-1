import org.junit.Test;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;

public class IngredientTypeTest {
    private final IngredientType filling = IngredientType.FILLING;
    private final IngredientType sauce = IngredientType.SAUCE;

    @Test
    public void constantSauceInIngredientTypeCorrect() {
        assertEquals("SAUCE", sauce.name());
    }


    @Test
    public void constantFILLINGInIngredientTypeCorrect() {
        assertEquals("FILLING", filling.name());
    }

}
