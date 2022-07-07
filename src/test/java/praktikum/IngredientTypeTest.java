package praktikum;

import org.junit.Test;

import static org.junit.Assert.*;

public class IngredientTypeTest {

    @Test
    public void getSauceTypeTest() {
        assertEquals(IngredientType.SAUCE, IngredientType.valueOf("SAUCE"));
    }

    @Test
    public void getFillingTypeTest() {
        assertEquals(IngredientType.FILLING, IngredientType.valueOf("FILLING"));
    }

    @Test
    public void getNonExistentTypeTest() {
        assertThrows(IllegalArgumentException.class, () -> IngredientType.valueOf("JAM"));
    }

    @Test
    public void getNullTypeTest() {
        assertThrows(NullPointerException.class, () -> IngredientType.valueOf(null));
    }

}
