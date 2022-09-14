package praktikum;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class IngredientTypeTest {
    @Test
    public void checkIngredientTypeValuesCount() {
        assertEquals(IngredientType.values().length, 2);
    }

    @Test
    public void checkIngredientTypeSauce() {
        assertEquals(IngredientType.valueOf("SAUCE"), IngredientType.SAUCE);
    }

    @Test
    public void checkIngredientTypeFilling() {
        assertEquals(IngredientType.valueOf("FILLING"), IngredientType.FILLING);
    }

    @Test
    public void shouldBeExceptionIfWrongTypeValue() {
        assertThrows(IllegalArgumentException.class, () -> IngredientType.valueOf("WRONG"));
    }
}