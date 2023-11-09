import org.junit.Test;
import praktikum.IngredientType;

import static org.junit.Assert.assertNotNull;

public class TestIngredientType {
    @Test
    public void fillingNotNull() {
        assertNotNull("Начинки не указаны в ингредиентах", IngredientType.valueOf("FILLING"));
    }

    @Test
    public void sauceNotNull() {
        assertNotNull("Соусы не указаны в ингредиентах", IngredientType.valueOf("SAUCE"));
    }
}
