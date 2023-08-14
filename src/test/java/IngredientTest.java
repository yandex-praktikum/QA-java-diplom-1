import org.junit.Before;
import org.junit.Test;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;

public class IngredientTest {
    Ingredient ingredient;
    @Before
    public void setUp() {
        ingredient = new Ingredient(IngredientType.SAUCE, "Кетчуп", 40);
    }

    @Test
    public void getPriceTest() {
        assertEquals("Цена ингредиента не совпадает", ingredient.getPrice(), 40, 0);
    }
    @Test
    public void getNameTest() {
        assertEquals("Имя ингредиента не совпадает", ingredient.getName(), "Кетчуп");
    }
    @Test
    public void getTypeTest() {
        assertEquals("Тип ингредиента не совпадает", ingredient.getType(), IngredientType.SAUCE);
    }
}
