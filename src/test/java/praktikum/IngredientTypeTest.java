package praktikum;

import org.junit.Test;

import static org.junit.Assert.*;

public class IngredientTypeTest {

    @Test
    public void sauceTest() {
        assertEquals("SAUCE", IngredientType.valueOf("SAUCE").toString());
    }

    @Test
    public void fillingTest() {
        assertEquals("FILLING", IngredientType.valueOf("FILLING").toString());
    }

}