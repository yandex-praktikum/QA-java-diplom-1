package praktikum;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class IngredientTypeTest {

    @Test
    public void checkIngredientType() {
        assertEquals(IngredientType.valueOf("SAUCE"), IngredientType.SAUCE);
        assertEquals(IngredientType.valueOf("FILLING"), IngredientType.FILLING);
    }
}