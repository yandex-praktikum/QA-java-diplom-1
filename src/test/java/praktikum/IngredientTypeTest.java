package praktikum;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static praktikum.IngredientType.SAUCE;


public class IngredientTypeTest {


    @Test
    public void ingredientType() {
        IngredientType expectedResult = SAUCE;
        IngredientType actualResult = IngredientType.valueOf(String.valueOf(SAUCE));
        assertEquals("IngredientType is incorrect", expectedResult, actualResult);
    }
}
