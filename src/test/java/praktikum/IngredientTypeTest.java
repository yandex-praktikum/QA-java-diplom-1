package praktikum;

import static org.junit.Assert.assertEquals;
import org.junit.Test;


public class IngredientTypeTest {

    @Test
    public void testIngredientTypeValues() {
        IngredientType[] types = IngredientType.values();
        assertEquals(2, types.length);
        assertEquals(IngredientType.SAUCE, types[0]);
        assertEquals(IngredientType.FILLING, types[1]);
    }
}
