package praktikum;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class IngredientTypeTest {
    @Test
    public void checkIngredientTypeSauce() {
        String expected = "SAUCE";
        assertEquals(expected, IngredientType.valueOf("SAUCE").toString());
    }

    @Test
    public void checkIngredientTypeFilling() {
        String expected = "FILLING";
        assertEquals(expected, IngredientType.valueOf("FILLING").toString());
    }
}
