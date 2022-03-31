package praktikum;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static praktikum.IngredientType.SAUCE;

public class IngredientTest  {
    @Test
    public void testGetPrice() {
        Ingredient ingredient = new Ingredient(SAUCE, "Чесночный", 50);
        assertEquals("Внимание! Цена ингредиента некорректна", 50.0, ingredient.getPrice(), 0);
    }

    @Test
    public void testTestGetName() {
        Ingredient ingredient = new Ingredient(SAUCE, "Чесночный", 50);
        assertEquals("Внимание! Имя ингредиента некорректно", "Чесночный", ingredient.getName());
    }

    @Test
    public void testGetType() {
        Ingredient ingredient = new Ingredient(SAUCE, "Чесночный", 50);
        assertEquals("Внимание! Тип ингредиента некорректен", SAUCE, ingredient.getType());
    }
}


