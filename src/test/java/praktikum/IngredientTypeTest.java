package praktikum;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class IngredientTypeTest {

    @Test
    public void ingredientTypeSauceTest() {
        assertEquals(IngredientType.valueOf("SAUCE"), IngredientType.SAUCE);
    }

    @Test
    public void ingredientTypeFillingTest() {
        assertEquals(IngredientType.valueOf("FILLING"), IngredientType.FILLING);
    }

    @Test
    public void ingredientTypeEnumCount() {
        assertEquals(2, IngredientType.values().length);
    }
}