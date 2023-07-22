import org.junit.Test;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;

public class IngredientTypeTest {
    @Test
    public void ingredientTypeSauce() {
        IngredientType sauce = IngredientType.SAUCE;
        assertEquals("SAUCE", sauce.name()); // Проверяем имя
        assertEquals(0, sauce.ordinal()); // Проверяем порядковый номер (индекс)
    }

    @Test
    public void ingredientTypeFilling() {
        IngredientType filling = IngredientType.FILLING;
        assertEquals("FILLING", filling.name()); // Проверяем имя
        assertEquals(1, filling.ordinal()); // Проверяем порядковый номер (индекс)
    }

    @Test
    public void values() {
        IngredientType[] types = IngredientType.values();
        assertEquals(2, types.length); // Проверяем общее количество значений
        assertEquals(IngredientType.SAUCE, types[0]); // Проверяем первое значение
        assertEquals(IngredientType.FILLING, types[1]); // Проверяем второе значение
    }
}
