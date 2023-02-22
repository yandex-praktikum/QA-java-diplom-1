import org.junit.Test;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;

public class IngredientTypeTest {

    private IngredientType ingredientType;

    @Test
    public void checkingValueSauceTest() {
        IngredientType actualResult = IngredientType.valueOf("SAUCE");
        IngredientType expectedResult = IngredientType.SAUCE;
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void checkingValueFillingTest() {
        IngredientType actualResult = IngredientType.valueOf("FILLING");
        IngredientType expectedResult = IngredientType.FILLING;
        assertEquals(expectedResult, actualResult);
    }
}
