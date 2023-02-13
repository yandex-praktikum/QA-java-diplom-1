package praktikum;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class IngredientTypeTest {

    @Test
    public void valuesTest() {
        IngredientType[] actual = IngredientType.values();
        IngredientType[] expected = {IngredientType.SAUCE, IngredientType.FILLING};
        assertEquals(expected, actual);
    }

    @Test
    public void valueOfSauce() {
        IngredientType actual = IngredientType.valueOf("SAUCE");
        IngredientType expected = IngredientType.SAUCE;
        assertEquals(expected, actual);
    }

    @Test
    public void valueOfFilling() {
        IngredientType actual = IngredientType.valueOf("FILLING");
        IngredientType expected = IngredientType.FILLING;
        assertEquals(expected, actual);
    }
}