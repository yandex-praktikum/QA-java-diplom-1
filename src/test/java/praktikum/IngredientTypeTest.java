package praktikum;

import org.junit.Test;

import static org.junit.Assert.*;

public class IngredientTypeTest {

    @Test
    public void nameTestSauce() {
        IngredientType ingredientType = IngredientType.SAUCE;
        assertEquals(ingredientType.name(), IngredientType.SAUCE.toString());
    }

    @Test
    public void nameTestFilling() {
        IngredientType ingredientType = IngredientType.FILLING;
        assertEquals(ingredientType.name(), IngredientType.FILLING.toString());
    }

    @Test
    public void ordinalTestForSauce() {
        assertEquals(0, IngredientType.SAUCE.ordinal());
    }

    @Test
    public void ordinalTestForFilling() {
        assertEquals(1, IngredientType.FILLING.ordinal());
    }

    @Test
    public void valueOfTestSauce() {
        assertEquals(IngredientType.SAUCE, IngredientType.valueOf("SAUCE"));
    }

    @Test
    public void valueOfTestFilling() {
        assertEquals(IngredientType.FILLING, IngredientType.valueOf("FILLING"));
    }

    @Test
    public void valuesTest() {
        assertNotNull(IngredientType.values());
    }
}