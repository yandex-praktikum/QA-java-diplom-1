import org.junit.Test;
import praktikum.IngredientType;

import static org.junit.Assert.assertNotNull;

public class IngredientTypeTest {


    @Test
    public void fillingNotNull() {
        assertNotNull("Тип ингридиента не указан", IngredientType.valueOf("FILLING"));
    }

    @Test
    public void sauceNotNull() {
        assertNotNull("Тип ингридиента не указан", IngredientType.valueOf("SAUCE"));
    }
}
