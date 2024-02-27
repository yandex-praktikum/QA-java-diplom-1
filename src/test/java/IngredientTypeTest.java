import org.junit.Test;
import static org.junit.Assert.*;
import praktikum.IngredientType;

public class IngredientTypeTest {
    // Проверяется, что массив содержит два элемента и что эти элементы соответствуют ожидаемым значениям
    @Test
    public void testValues() {
        IngredientType[] types = IngredientType.values();
        assertEquals(2, types.length);
        assertEquals(IngredientType.SAUCE, types[0]);
        assertEquals(IngredientType.FILLING, types[1]);
    }

    // Проверяется, что метод правильно возвращает типы ингредиентов для строк SAUCE и FILLING
    @Test
    public void testValueOf() {
        IngredientType sauceType = IngredientType.valueOf("SAUCE");
        assertEquals(IngredientType.SAUCE, sauceType);

        IngredientType fillingType = IngredientType.valueOf("FILLING");
        assertEquals(IngredientType.FILLING, fillingType);
    }
}
