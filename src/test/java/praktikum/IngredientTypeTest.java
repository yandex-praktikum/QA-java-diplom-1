package praktikum;

import org.junit.Assert;
import org.junit.Test;


public class IngredientTypeTest {
    private final String[] values = {"SAUCE", "FILLING"};

    // Проверяем метод, который возвращает список ингредиентов
    @Test
    public void values() {
        int i = 0;
        for (IngredientType value : IngredientType.values()) {
            Assert.assertEquals(value.toString(), values[i]);
            i++;
        }
    }

    // Проверяем метод, который возвращает ингредиент по названию
    @Test
    public void valueOf() {
        for (String value : values) {
            Assert.assertEquals(IngredientType.valueOf(value).toString(), value);
        }
    }
}