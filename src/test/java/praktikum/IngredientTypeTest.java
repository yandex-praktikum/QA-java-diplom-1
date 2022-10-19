package praktikum;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class IngredientTypeTest {

    //@Test
    public void testValues() {
        IngredientType[] actualValuesResult = IngredientType.values();
        assertEquals(2, actualValuesResult.length);
        assertEquals(IngredientType.SAUCE, actualValuesResult[0]);
        assertEquals(IngredientType.FILLING, actualValuesResult[1]);
    }
}

