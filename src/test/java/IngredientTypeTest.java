import org.junit.Test;
import praktikum.IngredientType;

import static org.junit.Assert.assertNotNull;

public class IngredientTypeTest {
    @Test
    public void sauceTest() {
        assertNotNull("Несуществующий тип ингредиента", IngredientType.valueOf("SAUCE"));
    }

    @Test
    public void fillingTest() {
        assertNotNull("Несуществующий тип ингредиента", IngredientType.valueOf("FILLING"));
    }
}
