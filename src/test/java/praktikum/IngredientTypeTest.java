package praktikum;

import junit.framework.TestCase;

public class IngredientTypeTest extends TestCase {

    public void testValues() {

        assertEquals(2,
                IngredientType.values().length);

        assertEquals(IngredientType.SAUCE,
                IngredientType.values()[0]);

        assertEquals(IngredientType.FILLING,
                IngredientType.values()[1]);
    }

    public void testValueOfSauce() {

        assertEquals(IngredientType.SAUCE,
                IngredientType.valueOf("SAUCE"));
    }

    public void testValueOfFilling() {

        assertEquals(IngredientType.SAUCE,
                IngredientType.valueOf("SAUCE"));
    }
}