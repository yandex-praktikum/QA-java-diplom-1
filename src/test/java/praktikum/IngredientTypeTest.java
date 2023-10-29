package praktikum;

import static org.junit.Assert.*;
import org.junit.Test;

public class IngredientTypeTest {
    @Test
    public void selectSauceTest() {
        assertEquals(IngredientType.valueOf("SAUCE"), IngredientType.SAUCE);
    }

    @Test
    public void selectFillingTest() {
        assertEquals(IngredientType.valueOf("FILLING"), IngredientType.FILLING);
    }

}