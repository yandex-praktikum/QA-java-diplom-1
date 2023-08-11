package praktikum;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestIngredientType {

    @Test
    public void testGetSauceTypeIsCorrect() {
        assertEquals(IngredientType.valueOf("SAUCE"), IngredientType.SAUCE);
    }

    @Test
    public void testGetFillingTypeIsCorrect() {
        assertEquals(IngredientType.valueOf("FILLING"), IngredientType.FILLING);
    }
}
