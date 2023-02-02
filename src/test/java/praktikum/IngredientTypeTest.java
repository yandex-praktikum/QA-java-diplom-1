package praktikum;

import org.junit.Test;

import static org.junit.Assert.*;

public class IngredientTypeTest {

    IngredientType ingredientType;
    @Test
    public void valuesTest() {
        IngredientType[] actual = ingredientType.values();
        IngredientType[] expected = {ingredientType.SAUCE,ingredientType.FILLING};
        assertEquals(expected,actual);
    }

    @Test
    public void valueOfSauce() {
        IngredientType actual = ingredientType.valueOf("SAUCE");
        IngredientType expected = ingredientType.SAUCE;
        assertEquals(expected,actual);
    }
    @Test
    public void valueOfFilling() {
        IngredientType actual = ingredientType.valueOf("FILLING");
        IngredientType expected = ingredientType.FILLING;
        assertEquals(expected,actual);
    }
}