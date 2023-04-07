import org.junit.Test;
import praktikum.IngredientType;

import static org.junit.Assert.assertNotNull;

public class IngredientTypeTest {

    @Test
    public void checkSauceNotNullTest() {
        assertNotNull("Соус не указан", IngredientType.SAUCE);
    }

    @Test
    public void checkFillingNotNullTest() {
        assertNotNull("Не указаны начинки", IngredientType.FILLING);
    }

}
