import org.junit.Test;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;

public class IngredientTypeTest {

    @Test
    public void checkSauceValue() {
        assertEquals(IngredientType.SAUCE, IngredientType.valueOf("SAUCE"));}

    @Test
    public void checkFillingValue() {
        assertEquals(IngredientType.FILLING, IngredientType.valueOf("FILLING"));
    }
}
