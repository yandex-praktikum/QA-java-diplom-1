import org.junit.Test;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;

public class IngredientTypeTest {
    @Test
    public void shouldReturnFilling() {
        IngredientType actual = IngredientType.FILLING;
        String expected = "FILLING";
        assertEquals(expected, actual.toString());

    }

    @Test
    public void shouldReturnSauce() {
        IngredientType actual = IngredientType.SAUCE;
        String expected = "SAUCE";
        assertEquals(expected, actual.toString());

    }
}
