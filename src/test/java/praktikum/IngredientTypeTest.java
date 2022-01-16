package praktikum;

import org.junit.Test;

import static org.junit.Assert.assertNotEquals;

public class IngredientTypeTest {

    @Test
    public void SauceIngredientTypeFromEnumTest() {
        assertNotEquals("No SAUCE in IngredientType list",null, IngredientType.SAUCE);
    }

    @Test
    public void FillingIngredientTypeFromEnumTest() {
        assertNotEquals("No FILLING in IngredientType list",null, IngredientType.FILLING);
    }

}
