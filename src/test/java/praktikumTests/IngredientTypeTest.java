package praktikumTests;

import org.junit.Test;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;

public class IngredientTypeTest {
    @Test
    public void valuesTest() {
        IngredientType[] actualValuesResult = IngredientType.values();
        assertEquals(2, actualValuesResult.length);
        assertEquals(IngredientType.SAUCE, actualValuesResult[0]);
        assertEquals(IngredientType.FILLING, actualValuesResult[1]);
    }
}
